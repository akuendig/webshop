package data.filesystem;

import model.Origin;
import data.IOriginRepository;

public class OriginRepository extends BaseRepository<Origin> implements IOriginRepository {

	public OriginRepository() {
		super("tblOrigin", Origin.class);
	}
	
	public Origin getById(int id) {
		return super.getById(id);
	}
}
