package commands;

import dao.DAOFactory;
import dao.IDAOOrder;
import manager.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by dennis on 08.06.2015.
 */
public class DeleteOrderCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL);
        IDAOOrder idaoOrder = daoFactory.getOrderDAO();
        idaoOrder.delete(Integer.parseInt(request.getParameter("orderId")));
        //System.out.println("To delete: " + Integer.parseInt(request.getParameter("orderId")));
        return Config.getInstance().getProperty(Config.CABINET);
    }
}
