package commands;

import dao.DAOFactory;
import dao.IDAOCity;
import entity.City;
import manager.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dennis on 29.05.2015.
 */
public class GoToMainCommand extends Command {
    private static final Logger log = LogManager.getLogger(GoToMainCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("client")==null){ //Checking if the user logged in
            log.info("unauthorised login attempt detected");
            return Config.getInstance().getProperty(Config.LOGIN);
        }

        List<City> city = null;

        setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOCity idaoCity = daoFactory.getCityDAO();

        city = idaoCity.getAll();
        request.setAttribute("city",city);

        return Config.getInstance().getProperty(Config.MAIN);
    }
}
