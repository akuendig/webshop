package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.ModelFactory;

import com.google.inject.Inject;

public abstract class BaseRepository<T> {
	
	@Inject
	protected Connection sqlConnection;
	
	protected final Class<T> modelClass;
	protected final ModelFactory<T> modelFactory;

	public BaseRepository(Class<T> clazz) {
		this.modelClass = clazz;
		this.modelFactory = new ModelFactory<T>(clazz);
	}

	protected final T getResult(String query) {

		try (Statement stmt = sqlConnection.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(query)) {
				if (rs.next()) {
					return modelFactory.create(rs);
				} else {
					return null;
				}
			}

		} catch (final SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	protected final List<T> getResults(String query) {

		List<T> results = new ArrayList<T>();

		try (Statement stmt = sqlConnection.createStatement()) {
			try (ResultSet rs = stmt.executeQuery(query)) {
				while (rs.next()) {
					results.add(modelFactory.create(rs));
				}
			}

		} catch (final SQLException ex) {
			ex.printStackTrace();
		}

		return results;
	}

	protected final boolean execute(String query) {

		try (Statement stmt = sqlConnection.createStatement()) {
			return stmt.execute(query);
		} catch (final SQLException ex) {
			ex.printStackTrace();
		}

		return false;
	}
}
