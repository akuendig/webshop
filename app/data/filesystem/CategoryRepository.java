package data.filesystem;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.Category;
import data.ICategoryRepository;

public class CategoryRepository extends BaseRepository<Category> implements ICategoryRepository {

	public CategoryRepository() {
		super("tblCategory");
	}

	@Override
	public final List<Category> getAll() {
		
		List<Category> copy = getListCopy();
		
		Collections.sort(copy, new Comparator<Category>(){
			  public int compare(Category s1, Category s2) {
				    return s1.getName().compareToIgnoreCase(s2.getName());
				  }
				});
		
		return copy;
	}

}
