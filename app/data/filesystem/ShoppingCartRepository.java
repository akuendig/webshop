package data.filesystem;

import java.util.List;

import com.google.inject.Inject;

import play.mvc.Controller;
import scala.collection.generic.BitOperations.Int;

import model.ShoppingCart;
import model.ShoppingCartEntry;
import data.IShoppingCartRepository;
import data.IShoppingcartProductRepository;

public class ShoppingcartRepository extends BaseRepository<ShoppingCart> implements IShoppingCartRepository {
	
	IShoppingcartProductRepository shoppingcartProductRepo;

	@Inject
	public ShoppingcartRepository(IShoppingcartProductRepository shoppingcartProductRepo) {
		super("tblShoppingCart", ShoppingCart.class);
		
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
	public int add(int shoppingCartId, int productId, int quantity) {

		ShoppingCartEntry entry = getEntry(shoppingCartId, productId);
		int change = 0;
		
		if (entry == null && quantity <= 0) {
			return change;
		} 
		else if(entry == null) {
			entry = shoppingcartProductRepo.create(shoppingCartId, productId, quantity);
			change = quantity;
		}
		else if(-quantity < entry.getQuantity()) {
			entry.setQuantity(entry.getQuantity() + quantity);
			change = quantity;
		}
		else {
			change = Integer.MIN_VALUE;
			remove(shoppingCartId, productId, entry.getQuantity());
		}
		shoppingcartProductRepo.update(entry);
		return change;
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
