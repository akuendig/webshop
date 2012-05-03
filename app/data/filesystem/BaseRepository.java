package data.filesystem;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.inject.Inject;

import fj.F;
import fj.data.Array;


public abstract class BaseRepository<T> {

	@Inject
	TableLocator locator;
	
	ObjectMapper mapper = new ObjectMapper();

	Class<T> clazz;
	String tableName;
	
	protected BaseRepository(String tableName, Class<T> clazz) {
		this.tableName = tableName;
		this.clazz = clazz;
	}

	protected Array<Path> getFiles() {

		try (DirectoryStream<Path> stream = Files.newDirectoryStream(locator
				.getFolder(tableName))) {
			
			return Array.iterableArray(stream);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Array.empty();
	}
	
	protected Array<String> read(Array<Path> files) {
		return
			files
			.map(new F<Path, String>() {
				public String f(Path path) {
					
					try {
						return
							join(Files.readAllLines(path, Charset.forName("UTF-8")));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					return "";
				}
			});
	}
	
	protected Array<T> parse(Array<String> entries) {
		return
			entries
			.map(new F<String, T>() {
				public T f(String entry) {
					try {
						return mapper.readValue(entry, clazz);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
				}
			});
	}

	protected String join(Iterable<String> s) {

		StringBuilder builder = new StringBuilder();
		Iterator<String> iter = s.iterator();

		while (iter.hasNext()) {
			builder.append(iter.next());
		}

		return builder.toString();
	}
}
