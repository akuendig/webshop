package data;

import java.util.List;

import model.Category;

public class CategoryRepository extends BaseRepository<Category> {

	public CategoryRepository() {
		super(Category.class);
	}
	
	public final List<Category> getAll() {

		return getResults(
				"SELECT * " +
				"FROM tblcategory " +
				"ORDER BY CategoryName ");
	}

}
