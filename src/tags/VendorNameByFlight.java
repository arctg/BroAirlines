package tags;

import dao.*;
import entity.Airplane;
import entity.City;
import entity.Flight;
import entity.Order;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.net.Inet4Address;

/**
 * Created by dennis on 07.06.2015.
 */
public class VendorNameByFlight extends TagSupport {
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
        }
        return SKIP_BODY;
    }
}
