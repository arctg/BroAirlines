package commands;

import dao.DAOFactory;
import dao.IDAOAirplane;
import dao.IDAOCity;
import entity.Airplane;
import entity.City;
import manager.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dennis on 29.05.2015.
 */
public class GoToAdminPanelCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
