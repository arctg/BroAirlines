package commands;

import manager.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dennis on 26.05.2015.
 */
public class GoToRegisterCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        page = Config.getInstance().getProperty(Config.REGISTER);
        return page;
    }
}
