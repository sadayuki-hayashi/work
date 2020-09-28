package examples.domain.goods.model;

public class GoodsModel {
	/** 商品ID */
	private int productid;

	/** 商品名 */
	private String productname;

	/** 価格 */
	private int price;

	/** 出品者名 */
	private String sellerid;

	/** 商品説明 */
	private String description;

	/** 更新日時 */
	private String updatetime;

	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSellerid() {
		return sellerid;
	}
	public void setSellerid(String sellerid) {
		this.sellerid = sellerid;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(String updatetime) {
		this.updatetime = updatetime;
	}
}
