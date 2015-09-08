package commands;

import dao.DAOFactory;
import dao.IDAOCity;
import dao.IDAOClient;
import dao.IDAORegion;
import entity.City;
import entity.Client;
import entity.Region;
import logic.MD5;
import manager.Config;
import manager.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by dennis on 25.05.2015.
 */
public class LoginCommand extends Command {
    private static final Logger logger = LogManager.getLogger(LoginCommand.class.getName());
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        Client client = null;
        String email = request.getParameter("email");
        String passwd = MD5.getHash(request.getParameter("passwd")); //converting newpasswd to MD5hash
        System.out.println(passwd);
        List<City> city = null;

        setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));

        IDAOClient idaoClient = daoFactory.getClientDAO();
        IDAOCity idaoCity = daoFactory.getCityDAO();
        Locale locale = request.getLocale();
        System.out.println(locale.toString());


        if (idaoClient.find(email,passwd)){
            city = idaoCity.getAll();
            client = idaoClient.findByEmail(email);
            request.setAttribute("city",city);
            HttpSession session = request.getSession(true);
            session.setAttribute("client",client);
            page = Config.getInstance().getProperty(Config.MAIN);
            logger.debug("Client " + email + " logged in");
        }

        else {
            System.out.println(Message.getInstance().getProperty(Message.LOGIN_ERROR));
            request.setAttribute("error", Message.getInstance().getProperty(Message.LOGIN_ERROR));
            page = Config.getInstance().getProperty(Config.ERROR);
            logger.debug("no such client found");
        }
        return page;
    }
}
