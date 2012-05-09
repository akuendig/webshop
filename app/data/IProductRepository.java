package data;

import java.util.List;

import model.Product;

public interface IProductRepository {

	public abstract Product getById(final int id);

	public abstract List<Product> getAll();

	public abstract List<Product> getRefined(String name, int categoryId,
			int brandId);

	public abstract List<Product> getByName(final String name);

	public abstract List<Product> getByCategory(final int categoryId);

	public abstract List<Product> getByBrand(final int brandId);

	public abstract List<Product> getByPopularity();

	public abstract List<Product> getProductsInShoppingCart(int shoppingCartId);

}