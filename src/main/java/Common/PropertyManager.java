// This cloass is for Configurations.Properties file
package Common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyManager {
    private static PropertyManager instance;
    private static final Object lock = new Object();
    private static String baseURL;

    //Create a Singleton instance. We need only one instance of Property Manager.
    public static PropertyManager getInstance () {
        if (instance == null) {
            synchronized (lock) {
                instance = new PropertyManager();
                instance.loadData();
            }
        }
        return instance;
    }

    //Get all configuration data and assign to related fields
    public void loadData(){
        Properties property = new Properties();
        try {
            property.load(new FileInputStream("D:\\Automation\\TestNGERListeners\\src\\main\\resources\\configuration.properties"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Configuration properties file cannot be found");
        }
      //Get properties from configuration.properties
      baseURL = property.getProperty("url");
    }

    public String getURL(){
        return baseURL;
    }
}
