package commands;

import dao.DAOFactory;
import dao.IDAOOrder;
import entity.Client;
import entity.Flight;
import entity.Order;
import manager.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dennis on 05.06.2015.
 */
public class PayCommand extends Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = null;
        String page = null;
        Client client = null;
        Flight flight = null;
        boolean laggage = false;
        boolean priboarding = false;
        int total = 0;

        client = (Client)request.getSession().getAttribute("client");
        order = (Order)request.getSession().getAttribute("order");

        Command.setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOOrder idaoOrder = daoFactory.getOrderDAO();

        order.setClientsId(client.getId());
        idaoOrder.create(order);

        page = Config.getInstance().getProperty(Config.CABINET);
        return page;
    }
}
