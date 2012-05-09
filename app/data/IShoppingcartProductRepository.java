package data;

import java.util.List;

import model.ShoppingCartEntry;

public interface IShoppingcartProductRepository {
	List<ShoppingCartEntry> getByShoppingcartId(int id);
	
	ShoppingCartEntry create(int shoppingCartId, int productId, int quantity);
	boolean update(ShoppingCartEntry entry);
	boolean delete(ShoppingCartEntry entry);
}
