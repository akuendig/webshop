package data.filesystem;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TableLocator {
	
	public static String FILE_EXTENSION = ".entry";
	
	public static Path getFolder(String tableName) {

		return getOrCreate("tables");
	}
	
	private static String getBase() throws URISyntaxException {
		return "C:\\";
	}
	
	private static Path getOrCreate(String directory) {
		
		try {
			Path path = Paths.get(getBase()).resolve(directory);
			
			if (path.toFile().exists()) {
				return path;
			} else if (path.toFile().mkdir()) {
				return path;
			}
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
