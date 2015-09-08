package manager;
import java.util.ResourceBundle;
/**
 * Created by dennis on 24.05.2015.
 */
public class Config {
    private static Config instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "manager.config";
    public static final String REGISTER = "REGISTER";
    public static final String MAIN = "MAIN";
    public static final String ERROR = "ERROR";
    public static final String LOGIN = "LOGIN";
    public static final String ADMINPANEL = "ADMINPANEL";
    public static final String CABINET = "CABINET";
    public static final String RESULT = "RESULT";
    public static final String BOOK = "BOOK";


    public static Config getInstance(){
        if(instance==null) {
            instance = new Config();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key){
        return (String)resource.getObject(key);
    }

}
