package data.filesystem;

import model.Origin;
import data.IOriginRepository;

public class OriginRepository extends BaseRepository<Origin> implements IOriginRepository {

	protected OriginRepository() {
		super("tblOrigin");
	}
	
	public Origin getById(int id) {
		return super.getById(id);
	}

}
