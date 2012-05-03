package data;

import java.util.List;

import model.Brand;

public interface IBrandRepository {

	public abstract List<Brand> getAll();

	public abstract Brand getById(int id);

}