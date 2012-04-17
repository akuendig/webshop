package data;

import model.Origin;


public class OriginRepository extends BaseRepository<Origin> {

	public OriginRepository() {
		super(Origin.class);
	}
	
	public final Origin getById(int id) {
		return getResult(
				"SELECT * " +
				"FROM tblorigin " +
				"WHERE Origin_ID = " +id+ " ");
	}

}
