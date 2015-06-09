package commands;

import manager.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by dennis on 26.05.2015.
 */
public class LogoutCommand extends Command {
    private static final Logger log = LogManager.getLogger(LogoutCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;

        request.getSession().removeAttribute("client");
        request.getSession().invalidate();
//        response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
//        response.setHeader("Pragma","no-cache");
//        response.setDateHeader("Expires", 0);
        log.debug("client is logged out");

        page = Config.getInstance().getProperty(Config.LOGIN);
        return page;
    }
}
