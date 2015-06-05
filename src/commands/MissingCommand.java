package commands;
import manager.Config;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by dennis on 25.05.2015.
 */
public class MissingCommand extends Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("client")==null) {
            return Config.getInstance().getProperty(Config.LOGIN);
        } else {
            System.out.println(request.getSession().getAttribute("client"));
            return Config.getInstance().getProperty(Config.CABINET);
        }
    }
}
