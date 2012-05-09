package data.filesystem;

import java.io.IOException;
import java.util.List;

import model.Brand;
import data.IBrandRepository;

public class BrandRepository extends BaseRepository<Brand> implements IBrandRepository {

	protected BrandRepository() {
		super("tblBrand");

		try {
			super.load();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
	}

	public Brand getById(int id) {
		return super.getById(id);
	}

	@Override
	public List<Brand> getAll() {
		return getListCopy();
	}
}
