package commands;

import manager.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dennis on 29.05.2015.
 */
public class GoToCabinetCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String uri = request.getRequestURI();
//        System.out.println(uri);
        return Config.getInstance().getProperty(Config.CABINET);
    }
}
