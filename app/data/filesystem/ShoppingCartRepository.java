package data.filesystem;

import java.util.List;

import com.google.inject.Inject;

import model.ShoppingCart;
import model.ShoppingCartEntry;
import data.IShoppingCartRepository;
import data.IShoppingcartProductRepository;

public class ShoppingCartRepository extends BaseRepository<ShoppingCart> implements IShoppingCartRepository {
	
	IShoppingcartProductRepository shoppingcartProductRepo;

	@Inject
	public ShoppingCartRepository(IShoppingcartProductRepository shoppingcartProductRepo) {
		super("tblShoppingCart");
		
		this.shoppingcartProductRepo = shoppingcartProductRepo;
	}

	@Override
	public void create(int userId) {

		ShoppingCart sc = new ShoppingCart();
		sc.setUserId(userId);
		create(sc);
	}

	@Override
	public int getIdForUser(int userId) {
		
		for (ShoppingCart sc: entries) {
			if (sc.getUserId() == userId) {
				return sc.getId();
			}
		}

		return 0;
	}

	@Override
	public List<ShoppingCartEntry> getEntries(int shoppingCartId) {

		return shoppingcartProductRepo.getByShoppingcartId(shoppingCartId);
	}

	@Override
	public ShoppingCartEntry getEntry(int shoppingCartId, int productId) {
		
		for (ShoppingCartEntry entry: shoppingcartProductRepo.getByShoppingcartId(shoppingCartId)) {
			if (entry.getProductId() == productId) {
				return entry;
			}
		}
		
		return null;
	}

	@Override
	public void add(int shoppingCartId, int productId, int quantity) {

		ShoppingCartEntry entry = getEntry(shoppingCartId, productId);
		
		if (entry == null) {
			entry = shoppingcartProductRepo.create(shoppingCartId, productId, quantity);
		} else {
			entry.setQuantity(entry.getQuantity() + quantity);
		}
		
		shoppingcartProductRepo.update(entry);
	}

	@Override
	public void remove(int shoppingCartId, int productId, int quantity) {

		ShoppingCartEntry entry = getEntry(shoppingCartId, productId);
		
		if (entry == null) {
			return;
		}

		entry.setQuantity(entry.getQuantity() - quantity);

		if (entry.getQuantity() <= 0) {
			shoppingcartProductRepo.delete(entry);
		}
	}

}
