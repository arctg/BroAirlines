package commands;

import dao.DAOFactory;
import dao.IDAOAirplane;
import dao.IDAOCity;
import entity.Airplane;
import entity.City;
import logic.CurrentDate;
import manager.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by dennis on 29.05.2015.
 */
public class GoToAdminPanelCommand extends Command {
    private static final Logger log = LogManager.getLogger(GoToAdminPanelCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("client")==null){ //Checking if the user logged in
            log.info("unauthorised login attempt detected");
            return Config.getInstance().getProperty(Config.LOGIN);
        }

        List<City> city = null;
        List<Airplane> airplane = null;

        setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOCity idaoCity = daoFactory.getCityDAO();
        IDAOAirplane idaoAirplane = daoFactory.getAirplaneDAO();
        airplane = idaoAirplane.getAll();
        city = idaoCity.getAll();
        request.setAttribute("city",city);
        request.setAttribute("airplane",airplane);

        return Config.getInstance().getProperty(Config.ADMINPANEL);
    }
}
