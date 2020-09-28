package examples.presentation.goods.entry.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class GoodsForm {
	/** 商品ID */
	private String productid;
	/** 商品名 */
	@NotNull
	@Size(min = 1, max = 50)
	private String productname;
	/** 値段 */
	@NotNull
	@Pattern(regexp="[0-9]*")
	@Size(min = 1, max = 10)
	private String price;
	/** 出品者名 */
	private String sellerid;
	/** 商品説明 */
	private String description;

	public String getProductid() {
		return productid;
	}
	public void setProductid(String productid) {
		this.productid = productid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
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

}
