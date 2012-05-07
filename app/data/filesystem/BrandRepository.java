package data.filesystem;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.inject.Inject;

import model.Brand;
import data.IBrandRepository;

public class BrandRepository extends BaseRepository<Brand> implements IBrandRepository {

	protected BrandRepository() {
		super("tblBrand");

		try {
			super.initialize();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Brand> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Brand getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
}
