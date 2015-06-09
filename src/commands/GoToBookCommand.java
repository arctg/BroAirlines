package commands;

import dao.IDAOAirplane;
import dao.IDAOFlight;
import entity.Airplane;
import entity.Flight;
import entity.Order;
import logic.PriceFixer;
import manager.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/**
 * Created by dennis on 04.06.2015.
 */
public class GoToBookCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Flight flight = null;
        Airplane airplane = null;
        Order order = new Order();
        int total = 0;
        IDAOFlight idaoFlight = daoFactory.getFlightDAO();
        IDAOAirplane idaoAirplane = daoFactory.getAirplaneDAO();

        flight = idaoFlight.findById(Integer.parseInt(request.getParameter("flightId")));
        airplane = idaoAirplane.findAirplaneById(flight.getAirplanesId());
        int busyPlaces = idaoFlight.busyPlaces(flight.getId());
        PriceFixer priceFixer = new PriceFixer();
        HttpSession session = request.getSession();

        if (request.getParameter("baggage")!=null) {
            request.setAttribute("baggage",PriceFixer.BAGGAGE);
            order.setLaggage(true);
            total = total + PriceFixer.BAGGAGE;
        };
        if (request.getParameter("priboarding")!=null) {
            request.setAttribute("priboarding",PriceFixer.PRIORITY_BOARDING);
            order.setPriorityBoard(true);
            total = total + PriceFixer.PRIORITY_BOARDING;
        };

        int price = priceFixer.fixer(Integer.parseInt(request.getParameter("flightId")),
                flight.getCreTime(),
                flight.getFlightDate(),
                flight.getPrice(),
                airplane.getNumOfSeats(),
                busyPlaces);

        total = total + price + flight.getPrice();
        order.setOrderPrice(total);
        order.setFlightsId(flight.getId());
        session.setAttribute("order",order);
        request.setAttribute("flight", flight);
        request.setAttribute("from",request.getParameter("from"));
        request.setAttribute("to",request.getParameter("to"));
        request.setAttribute("newprice",price);
        request.setAttribute("total",total);
        String page = Config.getInstance().getProperty(Config.BOOK);
        return page;
    }
}
