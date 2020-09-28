package examples.presentation.goods.list.controller;

import examples.presentation.goods.list.form.GoodsSearchForm;
import examples.presentation.goods.list.validation.PriceCorrelationValidator;
import examples.domain.goods.model.GoodsModel;
import examples.domain.goods.repository.GoodsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class GoodsListController {

	private final GoodsRepository goodsRepository;

	private final PriceCorrelationValidator priceCorrelationValidator;


	/**
	 * コンストラクター
	 */
	public GoodsListController(GoodsRepository goodsRepository, PriceCorrelationValidator priceCorrelationValidator) {
		this.goodsRepository = goodsRepository;
		this.priceCorrelationValidator = priceCorrelationValidator;
	}

	@ModelAttribute
	GoodsSearchForm setUpForm(){
		GoodsSearchForm form = new GoodsSearchForm();
		return form;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(priceCorrelationValidator);
	}

	/**
	 * 検索画面の初期表示用メソッド
	 * @return
	 */
	@RequestMapping(value="/goods/list.do",method = RequestMethod.GET, produces="text/plain;charset=UTF-8")
	public String initialList() {
		return "goods/list";
	}

	/**
	 * 検索画面の検索用メソッド
	 * @param goodsModel
	 * @return
	 */
	@RequestMapping(value="/goods/list.do",method = RequestMethod.POST, produces="text/plain;charset=UTF-8")
	public String searchList(@Validated GoodsSearchForm GoodsSearchForm, BindingResult result, Model model) {

		if (!result.hasErrors()) {
			List<GoodsModel> list = this.goodsRepository.getGoodsList(GoodsSearchForm);
			if(list.size() == 0) {
				//goodsModel.setErrorMsg("取得件数が0件です。検索項目の変更をし、再度検索をして下さい。");
			}else {
				//goodsModel.setGoodsList(list);
			}
			model.addAttribute("GoodsList", list);
		}

		return "goods/list";
	}
}
