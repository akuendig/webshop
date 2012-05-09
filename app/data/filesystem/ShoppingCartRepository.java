package data.filesystem;

import model.ShoppingCartEntry;
import model.User;
import data.IUserRepository;

public class ShoppingCartRepository extends BaseRepository<ShoppingCartEntry> implements IUserRepository {

	protected ShoppingCartRepository() {
		super("tblShoppingCart");
	}

	@Override
	public boolean contains(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserReg(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
