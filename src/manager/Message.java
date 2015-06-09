package manager;
import javax.servlet.http.HttpServlet;
import java.util.Locale;
import java.util.ResourceBundle;
/**
 * Created by dennis on 24.05.2015.
 */
public class Message {

    private static Message instance;
    private ResourceBundle resource;

    private static final String BUNDLE_NAME = "manager.messages";
    public static final String SERVLET_EXCEPTION = "SERVLET_EXCEPTION";
    public static final String IO_EXCEPTION = "IO_EXCEPTION";
    public static final String REGISTER_ERROR = "REGISTER_ERROR";
    public static final String LOGIN_ERROR = "LOGIN_ERROR";
    public static final String EMAIL_ERROR = "EMAIL_ERROR";
    public static final String DATE_ERROR = "DATE_ERROR";
    public static final String CITY_ERROR = "CITY_ERROR";
    public static final String INVALID_DATE = "INVALID_DATE";
    public static final String login = "login";


    public static Message getInstance(){
        if (instance ==null ) {
            instance = new Message();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}
