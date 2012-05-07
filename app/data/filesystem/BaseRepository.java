package data.filesystem;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.google.inject.Inject;

import fj.data.Array;


public abstract class BaseRepository<T> {

	final String tableName;
	
	ArrayList<T> entries;
	
	protected Array<T> getQuery() {
		return Array.iterableArray(entries);
	}
	
	protected BaseRepository(String tableName) {
		this.tableName = tableName;
	}
	
	protected boolean initialize() throws IOException, ClassNotFoundException {
		Path table = getTableFile();
		ObjectMapper o = new ObjectMapper();
		
		if (table.toFile().isFile()) {
			try (InputStream stream = Files.newInputStream(table)) {
				try (ObjectInputStream in = new ObjectInputStream(stream)) {
					entries = o.readValue(in, new TypeReference<ArrayList<T>>() { });
					return true;
				}
			}
		} else if (table.toFile().createNewFile()) {
			entries = new ArrayList<T>();
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean save() throws IOException, ClassNotFoundException {
		Path table = getTableFile();
		ObjectMapper o = new ObjectMapper();
		
		if (table.toFile().isFile() || table.toFile().createNewFile()) {
			try (OutputStream stream = Files.newOutputStream(table, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)) {
				try (ObjectOutputStream out = new ObjectOutputStream(stream)) {
					o.writeValue(out, entries);
					return true;
				}
			}
		} else {
			return false;
		}
	}
	
	private Path getTableFile() {
		
		return TableLocator.getFolder(tableName).resolve("all.table");
	}
}
