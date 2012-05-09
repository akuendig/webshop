package data.filesystem;


import java.io.IOException;
import java.util.ArrayList;

import model.EntityBase;


import fj.F;


public abstract class BaseRepository<T extends EntityBase> extends Table<T> {
    
    private int maxId = 0;
    
    protected BaseRepository(String tableName) {
        super(tableName);
		
		try {
			super.load();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
        
        for (EntityBase entity: entries) {
            maxId = Math.max(maxId, entity.getId());
        }
	}
    
    protected ArrayList<T> getListCopy() {
    	return new ArrayList<T>(entries);
    }
	
	protected T getById(final int id) {
        
        return
            getQuery()
            .find(new F<T, Boolean>() {
                public Boolean f(T entry) {
                    return entry.getId() == id;
                }
            })
            .orSome(NULL);
    }
	
	protected boolean create(T entity) {
	    
	    if (entity.getId() != 0) return false;
	    
	    maxId++;
	    entity.setId(maxId);
	    
	    entries.add(entity);
	    
        try {
            save();
            return true;
        } catch (ClassNotFoundException | IOException e) {

            e.printStackTrace();
            maxId--;
            entries.remove(entity);
            entity.setId(0);
            
            return false;
        }
	}
	
	protected boolean update(T entity) {
	    try {
            save();
            return true;
        } catch (ClassNotFoundException | IOException e) {

            e.printStackTrace();
            return false;
        }
	}
	
	protected boolean delete(T entity) {
	    
	    if (!entries.remove(getById(entity.getId())))
	        return false;
	    
        try {
            save();
            return true;
        } catch (ClassNotFoundException | IOException e) {

            e.printStackTrace();
            entries.add(entity);
            
            return false;
        }
	}
}
