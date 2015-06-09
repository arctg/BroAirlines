package commands;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import java.io.IOException;
import dao.DAOFactory;

/**
 * Created by dennis on 24.05.2015.
 */
public abstract class Command {
    protected static DAOFactory daoFactory;


    public abstract String execute(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException,IOException;

    public static void setDAOFactory(DAOFactory factory) {

        daoFactory = factory;
    }
}
