package examples.domain.goods.orm.mapper;

import examples.presentation.goods.list.form.GoodsSearchForm;
import examples.domain.goods.model.GoodsModel;

import java.util.List;

public interface GoodsMapper {

	public List<GoodsModel> getGoodsList(GoodsSearchForm goodsSearchForm);

	public GoodsModel getGoods(String productId);

	public boolean goodsEntry(GoodsModel goodsModel);

	public boolean goodsUpdate(GoodsModel goodsModel);
}
