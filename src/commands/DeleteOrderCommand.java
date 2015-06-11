package commands;

import dao.DAOFactory;
import dao.IDAOCity;
import dao.IDAOOrder;
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
 * Created by dennis on 08.06.2015.
 */
public class DeleteOrderCommand extends Command {
    private static final Logger log = LogManager.getLogger(DeleteOrderCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("client")==null){ //Checking if the user logged in
            log.info("unauthorised login attempt detected");
            return Config.getInstance().getProperty(Config.LOGIN);
        }

        DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL);
        IDAOOrder idaoOrder = daoFactory.getOrderDAO();
        idaoOrder.delete(Integer.parseInt(request.getParameter("orderId")));
        System.out.println("To delete: " + Integer.parseInt(request.getParameter("orderId")));
        log.debug("order deleted");
        //return Config.getInstance().getProperty(Config.CABINET);

        List<City> cityList= null;
        IDAOCity idaoCity = daoFactory.getCityDAO();
        cityList = idaoCity.getAll();
        request.setAttribute("city",cityList);

        return Config.getInstance().getProperty(Config.MAIN);
    }
}
