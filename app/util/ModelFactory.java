package util;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModelFactory<T> {

	private Class<T> myClass;
	private Constructor<T> constructor;
	
	public ModelFactory(Class<T> clazz) {
		myClass = clazz;
	}

	public T create(ResultSet set) throws SQLException {
		try {
			if (constructor == null) {
				constructor = myClass.getConstructor(ResultSet.class);
			}

			return constructor.newInstance(set);
		} catch (IllegalArgumentException | NoSuchMethodException
				| SecurityException | InstantiationException
				| IllegalAccessException | InvocationTargetException e) {
			e.printStackTrace();
			return null;
		}
	}
}
