package model;

public class CategoryContainsProduct {
	
	public int productId;
	
	public int categoryId;
	
	public CategoryContainsProduct(final int productId, final int categoryId){
		this.categoryId = categoryId;
		this.productId = productId;
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
