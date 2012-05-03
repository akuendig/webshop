package data.database;

import data.IOriginRepository;
import model.Origin;


public class OriginRepository extends BaseRepository<Origin> implements IOriginRepository {

	public OriginRepository() {
		super(Origin.class);
	}
	
	/* (non-Javadoc)
	 * @see data.IOriginRepository#getById(int)
	 */
	@Override
	public final Origin getById(int id) {
		return getResult(
				"SELECT * " +
				"FROM tblorigin " +
				"WHERE Origin_ID = " +id+ " ");
	}

}
