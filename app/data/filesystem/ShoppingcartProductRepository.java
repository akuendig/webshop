package data.filesystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.ShoppingCartEntry;
import data.IShoppingcartProductRepository;

public class ShoppingcartProductRepository extends Table<ShoppingCartEntry> implements IShoppingcartProductRepository {

	public ShoppingcartProductRepository() {
		super("tblShoppingcartContainsProduct");

	}

	@Override
	public List<ShoppingCartEntry> getByShoppingcartId(int shoppingcartId) {

		ArrayList<ShoppingCartEntry> result = new ArrayList<ShoppingCartEntry>();
		
		for (ShoppingCartEntry entry: entries) {
			if (entry.getShoppingCartId() == shoppingcartId) {
				result.add(entry);
			}
		}
		
		return result;
	}

	@Override
	public ShoppingCartEntry create(int shoppingCartId, int productId,
			int quantity) {
		
		ShoppingCartEntry entry = new ShoppingCartEntry();
		
		entry.setProductId(productId);
		entry.setQuantity(quantity);
		entry.setShoppingCartId(shoppingCartId);
		
		entries.add(entry);

		try {
			save();
			return entry;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean update(ShoppingCartEntry entry) {
		
		try {
			save();
			return true;
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(ShoppingCartEntry entry) {

		if (!entries.remove(entry)) {
			return false;
		}

		
		try {
			save();
			return true;
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
			entries.add(entry);
			return false;
		}
	}

}
