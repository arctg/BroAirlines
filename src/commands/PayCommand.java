package commands;

import dao.DAOFactory;
import dao.IDAOCity;
import dao.IDAOOrder;
import entity.City;
import entity.Client;
import entity.Flight;
import entity.Order;
import manager.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by dennis on 05.06.2015.
 */
public class PayCommand extends Command {
    private static final Logger log = LogManager.getLogger(PayCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("client")==null){ //Checking if the user logged in
            log.info("unauthorised login attempt detected");
            return Config.getInstance().getProperty(Config.LOGIN);
        }

        Order order = null;
        String page = null;
        Client client = null;

        client = (Client)request.getSession().getAttribute("client");
        order = (Order)request.getSession().getAttribute("order");

        Command.setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOOrder idaoOrder = daoFactory.getOrderDAO();

        order.setClientsId(client.getId());
        idaoOrder.create(order);

//        page = Config.getInstance().getProperty(Config.CABINET);
//        return page;

        List<City> cityList= null;
        IDAOCity idaoCity = daoFactory.getCityDAO();
        cityList = idaoCity.getAll();
        request.setAttribute("city",cityList);

        return Config.getInstance().getProperty(Config.MAIN);
    }
}
