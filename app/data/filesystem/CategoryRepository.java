package data.filesystem;

import java.io.IOException;
import java.util.List;
import java.util.Comparator;
import java.util.Collections;


import model.Category;
import data.ICategoryRepository;

public class CategoryRepository extends BaseRepository<Category> implements ICategoryRepository {

	protected CategoryRepository() {
		super("tblCategory");

		try {
			super.initialize();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public final List<Category> getAll() {
		
		Collections.sort(entries, new Comparator<Category>(){
			  public int compare(Category s1, Category s2) {
				    return s1.getName().compareToIgnoreCase(s2.getName());
				  }
				});
		
		return entries;
		

	}

}
