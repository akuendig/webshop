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

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import fj.data.Array;

public class Table<T> {

    protected final T NULL = null;
    protected final String tableName;
    protected ArrayList<T> entries;

    public Table(String tableName) {
        
        this.tableName = tableName;
    }
    
    protected boolean Serialize(ObjectOutputStream out) throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper o = new ObjectMapper();
        o.writeValue(out, entries);
        return true;
    }
    
    protected boolean Deserialize(ObjectInputStream in) throws JsonParseException, JsonMappingException, IOException {
        ObjectMapper o = new ObjectMapper();
        entries = o.readValue(in, new TypeReference<ArrayList<T>>() { });
        return true;
    }

    protected boolean initialize() throws IOException, ClassNotFoundException {
    	Path table = getTableFile();
    	
    	if (table.toFile().isFile()) {
    		try (InputStream stream = Files.newInputStream(table)) {
    			try (ObjectInputStream in = new ObjectInputStream(stream)) {
    				return Deserialize(in);
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
    	
    	if (table.toFile().isFile() || table.toFile().createNewFile()) {
    		try (OutputStream stream = Files.newOutputStream(table, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE)) {
    			try (ObjectOutputStream out = new ObjectOutputStream(stream)) {
    				return Serialize(out);
    			}
    		}
    	} else {
    		return false;
    	}
    }

    protected Array<T> getQuery() {
        return Array.iterableArray(entries);
    }

    private Path getTableFile() {
    	
    	return TableLocator.getFolder(tableName).resolve("all.table");
    }

}