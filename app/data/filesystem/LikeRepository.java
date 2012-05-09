package data.filesystem;

import model.Like;
import data.ILikeRepository;

public class LikeRepository extends BaseRepository<Like> implements ILikeRepository {

	public LikeRepository() {
		super("tblLike");
	}

	@Override
	public Like get(int userId, int productId) {

		for (Like entry: entries) {
			if (entry.getProductId() == productId &&
				entry.getUserId() == userId) {
				return entry;
			}
		}
		
		return null;
	}

	@Override
	public void create(int userId, int productId) {

		Like like = new Like();
		
		like.setProductId(productId);
		like.setUserId(userId);
		
		create(like);
	}

}
