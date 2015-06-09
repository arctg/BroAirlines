package tags;

import dao.DAOFactory;
import dao.IDAOAirplane;
import dao.IDAOCity;
import dao.IDAOFlight;
import entity.City;
import entity.Flight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by dennis on 07.06.2015.
 */
public class DirectionTag extends TagSupport {
    private static final Logger log = LogManager.getLogger(DirectionTag.class);
    private String direction;
    City city = null;
    Flight flight = null;
    static DAOFactory daoFactory;

    public static void setDAOFactory(DAOFactory factory) {
        daoFactory = factory;
    }

    public void setId(String id) {

        setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOFlight idaoFlight = daoFactory.getFlightDAO();
        IDAOCity idaoCity = daoFactory.getCityDAO();
        flight = idaoFlight.findById(Integer.parseInt(id));
        String cityFrom = idaoCity.findById(flight.getFrom()).getcName();
        String  cityTo = idaoCity.findById(flight.getTo()).getcName();
        this.direction = cityFrom + " - " + cityTo;
    }

    public int doStartTag() {
        try {
            pageContext.getOut().write(direction);
        } catch (IOException e) {
            System.out.println(e);
            log.warn(e);
        }
        return SKIP_BODY;
    }
}
