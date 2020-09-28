package examples.domain.goods.repository;

import examples.presentation.goods.list.form.GoodsSearchForm;
import examples.domain.goods.model.GoodsModel;
import examples.domain.goods.orm.mapper.GoodsMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GoodsRepository {

	private final GoodsMapper goodsMapper;

	public GoodsRepository(GoodsMapper goodsMapper) {
		super();
		this.goodsMapper = goodsMapper;
	}

	@Transactional(readOnly=true)
	public List<GoodsModel> getGoodsList(GoodsSearchForm goodsSearchForm) {
		return this.goodsMapper.getGoodsList(goodsSearchForm);
	}

	@Transactional(readOnly=true)
	public GoodsModel getGoods(String productId) {
		return this.goodsMapper.getGoods(productId);
	}

	@Transactional
	public void goodsEntry(GoodsModel goodsModel) {
		this.goodsMapper.goodsEntry(goodsModel);
	}

	@Transactional
	public void goodsUpdate(GoodsModel goodsModel) {
		this.goodsMapper.goodsUpdate(goodsModel);
	}
}
