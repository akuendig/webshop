package data.filesystem;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class TableLocator {
	
	public Path getFolder(String tableName) {
		
		switch (tableName) {
		case "tblBrand":
			Path path = FileSystems.getDefault().getPath(getBase() + "/brand");
			
			if (path.toFile().exists()) {
				return path;
			} else if (path.toFile().mkdir()) {
				return path;
			}
			break;

		default:
			break;
		}
		
		return null;
	}
	
	private String getBase() {
		return BaseRepository.class.getProtectionDomain().getCodeSource().getLocation().getPath();
	}
}
