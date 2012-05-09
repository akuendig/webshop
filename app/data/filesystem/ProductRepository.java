package data.filesystem;

import java.util.List;

import model.Product;
import data.IProductRepository;

public class ProductRepository extends BaseRepository<Product> implements IProductRepository {

	protected ProductRepository() {
		super("tblProduct");
	}
	
	public Product getById(int id) {
		return super.getById(id);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getRefined(String name, int categoryId, int brandId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByCategory(String categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByBrand(String brandId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getByPopularity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> getProductsInShoppingCart(int shoppingCartId) {
		// TODO Auto-generated method stub
		return null;
	}

}
