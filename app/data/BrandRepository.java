package data;

import java.util.List;

import model.Brand;

public class BrandRepository extends BaseRepository<Brand>{

	public BrandRepository() {
		super(Brand.class);
	}

	public final List<Brand> getAll() {

		return getResults(
				"SELECT * " +
				"FROM tblbrand ");
	}
	
	public final Brand getById(int id) {
		
		return getResult(
				"SELECT * " +
				"FROM tblbrand " +
				"WHERE Brand_ID = " +id + " ");
	}
	
}
