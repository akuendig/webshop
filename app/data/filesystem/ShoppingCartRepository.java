package data.filesystem;

import java.util.List;

import model.ShoppingCartEntry;
import data.IShoppingCartRepository;

public class ShoppingCartRepository extends BaseRepository<ShoppingCartEntry> implements IShoppingCartRepository {

	protected ShoppingCartRepository() {
		super("tblShoppingCart");
	}

	@Override
	public void create(int userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIdForUser(int userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ShoppingCartEntry> getEntries(int shoppingCartId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShoppingCartEntry getEntry(int shoppingCartId, int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int shoppingCartId, int productId, int quantity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(int shoppingCartId, int productId, int quantity) {
		// TODO Auto-generated method stub
		
	}

}
