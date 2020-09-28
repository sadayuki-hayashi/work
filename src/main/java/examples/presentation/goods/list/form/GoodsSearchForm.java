package examples.presentation.goods.list.form;

public class GoodsSearchForm {
	/** 商品名 */
	private String productname;

	/** 検索用値段最小値 */
	private String priceMin;

	/** 検索用値段最大値 */
	private String priceMax;

	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(String priceMin) {
		this.priceMin = priceMin;
	}
	public String getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(String priceMax) {
		this.priceMax = priceMax;
	}
}
