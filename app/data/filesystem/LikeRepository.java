package data.filesystem;

import model.Like;
import data.ILikeRepository;

public class LikeRepository extends BaseRepository<Like> implements ILikeRepository {

	protected LikeRepository() {
		super("tblLike");
	}

	@Override
	public Like get(int userId, int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void create(int userId, int productId) {
		// TODO Auto-generated method stub
		
	}

}
