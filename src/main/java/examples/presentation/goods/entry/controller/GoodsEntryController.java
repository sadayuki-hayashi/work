package examples.presentation.goods.entry.controller;

import examples.domain.goods.model.GoodsModel;
import examples.domain.goods.repository.GoodsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoodsEntryController {

	private final GoodsRepository goodsRepository;

	public GoodsEntryController(GoodsRepository goodsRepository) {
		super();
		this.goodsRepository = goodsRepository;
	}



	/**
	 * 登録時の初期表示を行います。
	 * @return "modelAndView"
	 */
	@RequestMapping(value="/goods/entry.do",method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public ModelAndView initialEntry() {
		GoodsModel model = new GoodsModel();
		ModelAndView modelAndView = new ModelAndView("goods/entry", "goodsModel", model);
		return modelAndView;
	}

	/**
	 * 更新時の初期表示を行います。
	 * @return "modelAndView"
	 */
	@RequestMapping(value="/goods/entry/{productid}.do",method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public ModelAndView initialUpdate(@PathVariable("productid") String productid) {
		GoodsModel model = this.goodsRepository.getGoods(productid);
		ModelAndView modelAndView = new ModelAndView("goods/detail", "goodsModel", model);
		return modelAndView;
	}

	/**
	 * 登録処理を行います
	 * @param goodsModel "goodsModel画面入力データ"
	 * @return "modelAndView"
	 */
	@RequestMapping(value="/goods/goodsEntry.do",method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ModelAndView goodsEntry(@Validated GoodsModel goodsModel, BindingResult result) {
		// 登録前の入力チェック実装
		if (result.hasErrors()) {
			// エラーが存在する場合には自画面へ遷移する。
			ModelAndView modelAndView = new ModelAndView("goods/entry", "goodsModel", goodsModel);
			return modelAndView;
		}

		try{
			// 登録処理の実行
			this.goodsRepository.goodsEntry(goodsModel);

			// 検索画面に遷移
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("goods/list");
			return modelAndView;
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
}
