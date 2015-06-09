package tags;

import dao.*;
import entity.Airplane;
import entity.Flight;
import entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by dennis on 07.06.2015.
 */
public class VendorNameByFlightTag extends TagSupport {
    private static final Logger log = LogManager.getLogger(VendorNameByFlightTag.class);

    private String vendorname;
    int id;
    Airplane airplane = null;
    Flight flight = null;
    Order order = null;
    static DAOFactory daoFactory;

    public static void setDAOFactory(DAOFactory factory) {
        daoFactory = factory;
    }

    public void setFlightId(String id) {

        setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOFlight idaoFlight = daoFactory.getFlightDAO();
        flight = idaoFlight.findById(Integer.parseInt(id));
        IDAOAirplane idaoAirplane = daoFactory.getAirplaneDAO();
        airplane = idaoAirplane.findAirplaneById(flight.getAirplanesId());
        this.vendorname = airplane.getVendorName();



    }

    public int doStartTag() {
        try {
            pageContext.getOut().write(vendorname);
        } catch (IOException e) {
            System.out.println(e);
            log.warn(e);
        }
        return SKIP_BODY;
    }
}
