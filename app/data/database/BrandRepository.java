package data.database;

import java.util.List;

import data.IBrandRepository;

import model.Brand;

public class BrandRepository extends BaseRepository<Brand> implements IBrandRepository{

	public BrandRepository() {
		super(Brand.class);
	}

	/* (non-Javadoc)
	 * @see data.IBrandRepository#getAll()
	 */
	@Override
	public final List<Brand> getAll() {

		return getResults(
				"SELECT * " +
				"FROM tblbrand ");
	}
	
	/* (non-Javadoc)
	 * @see data.IBrandRepository#getById(int)
	 */
	@Override
	public final Brand getById(int id) {
		
		return getResult(
				"SELECT * " +
				"FROM tblbrand " +
				"WHERE Brand_ID = " +id + " ");
	}
	
}
