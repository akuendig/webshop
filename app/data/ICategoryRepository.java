package data;

import java.util.List;

import model.Category;

public interface ICategoryRepository {

	public abstract List<Category> getAll();

}