package data.filesystem;

import model.Product;
import model.User;
import data.IUserRepository;

public class ProductRepository extends BaseRepository<Product> implements IUserRepository {

	protected ProductRepository() {
		super("tblProduct");
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
