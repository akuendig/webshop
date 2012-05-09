package data;

import java.util.List;

public interface ICategoryProductRepository {
	List<Integer> getByCategory(int category);
}
