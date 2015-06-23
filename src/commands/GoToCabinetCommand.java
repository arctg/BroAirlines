package commands;

import dao.*;
import entity.*;
import logic.CurrentDate;
import manager.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dennis on 29.05.2015.
 */
public class GoToCabinetCommand extends Command {
    private static final Logger log = LogManager.getLogger(GoToCabinetCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("client") == null) { //Checking if the user logged in
            log.info("unauthorised login attempt detected");
            return Config.getInstance().getProperty(Config.LOGIN);
        }

        Flight flight = null;
        Order order = null;
        Client client = null;

        ArrayList<Order> trueOrderList = null; //List of orders that could be deleted
        ArrayList<Order> nearTrueList = new ArrayList<>(); //List of orders that coldn't be deleted
        ArrayList<Order> falseOrderList = new ArrayList<>(); //List of past orders

        setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));

        IDAOFlight idaoFlight = daoFactory.getFlightDAO();
        IDAOOrder idaoOrder = daoFactory.getOrderDAO();

        HttpSession session = request.getSession();
        client = (Client) session.getAttribute("client");
        trueOrderList = idaoOrder.getAllById(client.getId());
        Iterator<Order> iter = trueOrderList.iterator();

        while (iter.hasNext()) {
            order = iter.next();
            flight = idaoFlight.findById(order.getFlightsId());

            if ((TimeUnit.HOURS.convert((flight.getFlightDate().getTime() -
                            CurrentDate.getCurrentDate().getTime()),
                    TimeUnit.MILLISECONDS) <= 72) & (TimeUnit.HOURS.convert((flight.getFlightDate().getTime() -
                            CurrentDate.getCurrentDate().getTime()),
                    TimeUnit.MILLISECONDS)) >= 0) {
                nearTrueList.add(order);
                iter.remove();
            }
            if (CurrentDate.getCurrentDate().compareTo(flight.getFlightDate()) >= 0) {
                falseOrderList.add(order);
                System.out.println("removing");
                iter.remove();
            }
        }


        request.setAttribute("trueOrderList", trueOrderList);
        request.setAttribute("nearTrueOrderList", nearTrueList);
        request.setAttribute("falseOrderList", falseOrderList);

        return Config.getInstance().getProperty(Config.CABINET);
    }
}
