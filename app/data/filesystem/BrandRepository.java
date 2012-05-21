package data.filesystem;

import java.util.List;

import model.Brand;
import data.IBrandRepository;

public class BrandRepository extends BaseRepository<Brand> implements IBrandRepository {

	public BrandRepository() {
		super("tblBrand", Brand.class);
	}

	public Brand getById(int id) {
		return super.getById(id);
	}

	@Override
	public List<Brand> getAll() {
		return getListCopy();
	}
}
