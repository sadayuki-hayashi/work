package examples.presentation.goods.entry.controller;

import examples.domain.goods.repository.GoodsRepository;
import examples.domain.goods.model.GoodsModel;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GoodsDetailController {

	private final GoodsRepository goodsRepository;

	public GoodsDetailController(GoodsRepository goodsRepository) {
		super();
		this.goodsRepository = goodsRepository;
	}

	/**
	 * 更新時の初期表示を行います。
	 * @return "modelAndView"
	 */
	@RequestMapping(value="/goods/detail.do",method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public ModelAndView initialUpdate(@RequestParam("productid") String productid) {
		GoodsModel model = this.goodsRepository.getGoods(productid);
		ModelAndView modelAndView = new ModelAndView("goods/detail", "goodsModel", model);
		return modelAndView;
	}

	/**
	 * 更新処理を行います
	 * @param goodsModel "goodsModel画面入力データ"
	 * @return "modelAndView"
	 */
	@RequestMapping(value="/goods/goodsUpdate.do",method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public ModelAndView goodsUpdate(@Validated GoodsModel goodsModel, BindingResult result) {
		// 登録前の入力チェック実装
		if (result.hasErrors()) {
			// エラーが存在する場合には自画面へ遷移する。
			ModelAndView modelAndView = new ModelAndView("goods/detail", "goodsModel", goodsModel);
			return modelAndView;
		}

		try{
			// 更新処理の実行
			this.goodsRepository.goodsUpdate(goodsModel);

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
