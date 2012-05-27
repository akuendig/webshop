package data;

public interface ICrud<T> {
	public abstract boolean create(T entity);
	public abstract boolean update(T entity);
	public abstract T getById(final int id);
	public abstract boolean delete(T entity);
}
