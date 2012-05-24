package data.filesystem;

import java.util.ArrayList;
import java.util.List;

import model.CategoryContainsProduct;
import data.ICategoryProductRepository;

public class CategoryProductRepository extends Table<CategoryContainsProduct> implements ICategoryProductRepository {

	public CategoryProductRepository() {
		super("tblCategoryContainsProduct", CategoryContainsProduct.class);
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

	@Override
	public boolean create(CategoryContainsProduct entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CategoryContainsProduct entity) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CategoryContainsProduct getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(CategoryContainsProduct entity) {
		// TODO Auto-generated method stub
		return false;
	}
}