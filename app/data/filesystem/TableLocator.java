package data.filesystem;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TableLocator {
	
	public static String FILE_EXTENSION = ".entry";
	
	public static Path getFolder(String tableName) {
		
		switch (tableName) {
		case "tblBrand":
			try {
				Path path = Paths.get(getBase()).resolve("brand/");
				
				if (path.toFile().exists()) {
					return path;
				} else if (path.toFile().mkdir()) {
					return path;
				}
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
		
		return null;
	}
	
	private static URI getBase() throws URISyntaxException {
		return BaseRepository.class.getProtectionDomain().getCodeSource().getLocation().toURI();
	}
}
