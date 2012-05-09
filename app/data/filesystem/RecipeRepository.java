package data.filesystem;

import model.Recipe;
import model.User;
import data.IUserRepository;

public class RecipeRepository extends BaseRepository<Recipe> implements IUserRepository {

	protected RecipeRepository() {
		super("tblRecipe");
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
