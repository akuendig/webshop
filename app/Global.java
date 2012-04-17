import play.*;
import play.libs.*;

import java.util.*;

import com.typesafe.plugin.inject.InjectPlugin;

public class Global extends GlobalSettings {
    
    public void onStart(Application app) {
      Logger.warn("getting an instance from guice:");
    }
}
