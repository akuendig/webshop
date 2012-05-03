package data;

import model.Like;

public class LikeRepository extends BaseRepository<Like> implements ILikeRepository {

	public LikeRepository() {
		super(Like.class);
	}

	/* (non-Javadoc)
	 * @see data.ILikeRepository#get(int, int)
	 */
	@Override
	public final Like get (int userId, int productId) {

		return getResult(
				"SELECT * " +
				"FROM user_likes_product " +
				"WHERE User_id = " + userId +
				" AND Product_id = " + productId + " ");
	}

	/* (non-Javadoc)
	 * @see data.ILikeRepository#create(int, int)
	 */
	@Override
	public final void create (int userId, int productId) {

		execute("INSERT INTO user_likes_product " +
				"VALUES ( " + userId + " , " + productId + ") ");
	}

}
