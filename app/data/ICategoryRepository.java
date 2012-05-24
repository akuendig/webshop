package data;

import java.util.List;

import model.Category;

public interface ICategoryRepository extends ICrud<Category> {

	public abstract List<Category> getAll();

}