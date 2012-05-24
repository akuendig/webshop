package data;

import java.util.List;

import model.CategoryContainsProduct;

public interface ICategoryProductRepository extends ICrud<CategoryContainsProduct> {
	
	public abstract List<Integer> getByCategory(int categoryId);

}
