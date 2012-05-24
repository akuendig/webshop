package data;

import java.util.List;

import model.ShoppingCart;
import model.ShoppingCartEntry;

public interface IShoppingCartRepository extends ICrud<ShoppingCart> {

	public abstract void create(int userId);

	public abstract int getIdForUser(int userId);

	public abstract List<ShoppingCartEntry> getEntries(int shoppingCartId);

	public abstract ShoppingCartEntry getEntry(int shoppingCartId, int productId);

	public abstract int add(int shoppingCartId, int productId, int quantity);

	public abstract void remove(int shoppingCartId, int productId, int quantity);

}