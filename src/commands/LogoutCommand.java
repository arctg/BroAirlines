package commands;

import manager.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dennis on 26.05.2015.
 */
public class LogoutCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;

        request.getSession().removeAttribute("client");
        request.getSession().removeAttribute("admin");
        //request.getSession(false);
        request.getSession().invalidate();
        page = Config.getInstance().getProperty(Config.LOGIN);
        return page;
    }
}
