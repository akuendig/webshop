package data.filesystem;

import java.util.ArrayList;
import java.util.List;

import model.CategoryContainsProduct;
import data.ICategoryProductRepository;

public class CategoryProductRepository extends Table<CategoryContainsProduct> implements ICategoryProductRepository {

	public CategoryProductRepository() {
		super("tblCategoryContainsProduct");
	}

	@Override
	public List<Integer> getByCategory(int category) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		
		for (CategoryContainsProduct entry: entries) {
			if (entry.getCategoryId() == category) {
				result.add(entry.getProductId());
			}
		}
		
		return result;
	}

}
