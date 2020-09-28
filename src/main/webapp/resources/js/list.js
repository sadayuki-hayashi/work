/**
 * 商品登録画面に遷移
 * @returns
 */
function createNewProduct(){
	location.href = "entry.do"
}

/**
 * 商品更新画面に遷移
 * @returns
 */
function thisProductDetail(productid){
	location.href = "detail.do" + "?productid=" + productid
}
