package data;

import model.Like;

public interface ILikeRepository {

	public abstract Like get(int userId, int productId);

	public abstract void create(int userId, int productId);

}