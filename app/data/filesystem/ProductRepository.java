package data.filesystem;

import java.util.ArrayList;
import java.util.List;

import com.google.inject.Inject;

import model.Product;
import model.ShoppingCartEntry;
import data.ICategoryProductRepository;
import data.IProductRepository;
import data.IShoppingCartRepository;

public class ProductRepository extends BaseRepository<Product> implements IProductRepository {
	
	ICategoryProductRepository categoryRepo;
	
	IShoppingCartRepository shoppingCartRepo;
	
	ICategoryProductRepository categoryProductRepo;

	@Inject
	public ProductRepository(ICategoryProductRepository categoryRepo, IShoppingCartRepository shoppingCartRepo, ICategoryProductRepository catProdRepo) {
		super("tblProduct", Product.class);
		
		this.categoryRepo = categoryRepo;
		this.shoppingCartRepo = shoppingCartRepo;
		this.categoryProductRepo = catProdRepo;
	}
	
	public Product getById(int id) {
		return super.getById(id);
	}

	@Override
	public List<Product> getAll() {
		return getListCopy();
	}

	@Override
	public List<Product> getRefined(String name, int categoryId, int brandId) {
		
		ArrayList<Product> results = new ArrayList<Product>();
		List<Integer> products = null;
		
		if (categoryId > 0) {
			products = categoryRepo.getByCategory(categoryId);
		}

		for (Product entry: entries) {
			if (entry.getName().matches(name) &&							// names equal &&
				(categoryId == 0 || products.contains(entry.getId())) &&		// (no category set || 
				(brandId <= 0 || entry.getBrandId() == brandId)){
				results.add(entry);
			}
		}
		
		return results;
	}

	@Override
	public List<Product> getByName(String name) {
		
		ArrayList<Product> results = new ArrayList<Product>();

		for (Product entry: entries) {
			if (entry.getName().matches(name)) {
				results.add(entry);
			}
		}
		
		return results;
	}

	@Override
	public List<Product> getByCategory(int categoryId) {
		
		if (categoryId <= 0) {
			return getAll();
		}
		
		ArrayList<Product> results = new ArrayList<Product>();
		List<Integer> products = categoryRepo.getByCategory(categoryId);

		for (Product entry: entries) {
			if (products.contains(entry.getId())){
				results.add(entry);
			}
		}
		
		return results;
	}

	@Override
	public List<Product> getByBrand(int brandId) {
		
		if (brandId <= 0) {
			return getAll();
		}
		
		ArrayList<Product> results = new ArrayList<Product>();

		for (Product entry: entries) {
			if (entry.getBrandId() == brandId) {
				results.add(entry);
			}
		}
		
		return results;
	}

	@Override
	public List<Product> getByPopularity() {

		return getAll();
	}

	@Override
	public List<Product> getProductsInShoppingCart(int shoppingCartId) {

		ArrayList<Product> results = new ArrayList<Product>();
		List<ShoppingCartEntry> entries = shoppingCartRepo.getEntries(shoppingCartId);
		
		for (ShoppingCartEntry entry: entries) {
			results.add(getById(entry.getProductId()));
		}
		
		return results;
	}
	
	//@Override
	public void add(Product product) {
		this.create(product);		
	}

}
