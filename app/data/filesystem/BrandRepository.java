package data.filesystem;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

import model.Brand;
import data.IBrandRepository;

public class BrandRepository extends BaseRepository implements IBrandRepository {

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
	
	private static Brand parse(String text) {
		try {
			return mapper.readValue(text, Brand.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
