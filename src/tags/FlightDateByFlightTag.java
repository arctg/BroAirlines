package tags;

import dao.DAOFactory;
import dao.IDAOFlight;
import entity.Flight;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by dennis on 08.06.2015.
 */
public class FlightDateByFlightTag extends TagSupport {
    private static final Logger log = LogManager.getLogger(FlightDateByFlightTag.class);
    private String flightDate;
    int id;;
    Flight flight = null;
    static DAOFactory daoFactory;

    public static void setDAOFactory(DAOFactory factory) {
        daoFactory = factory;
    }

    public void setFlightId(String id) {
        setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOFlight idaoFlight = daoFactory.getFlightDAO();
        flight = idaoFlight.findById(Integer.parseInt(id));
        this.flightDate = flight.getFlightDate().toString();
    }

    public int doStartTag() {
        try {
            pageContext.getOut().write(flightDate);
        } catch (IOException e) {
            System.out.println(e);
            log.warn(e);
        }
        return SKIP_BODY;
    }
}
