package data;

import model.Origin;

public interface IOriginRepository extends ICrud<Origin> {

	public abstract Origin getById(int id);

}