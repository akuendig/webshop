package data.database;

import java.util.List;

import data.ICategoryRepository;

import model.Category;

public class CategoryRepository extends BaseRepository<Category> implements ICategoryRepository {

	public CategoryRepository() {
		super(Category.class);
	}
	
	/* (non-Javadoc)
	 * @see data.ICategoryRepository#getAll()
	 */
	@Override
	public final List<Category> getAll() {

		return getResults(
				"SELECT * " +
				"FROM tblcategory " +
				"ORDER BY CategoryName ");
	}

}
