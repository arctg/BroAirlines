package tags;

import dao.DAOFactory;
import dao.IDAOAirplane;
import dao.IDAOFlight;
import entity.Airplane;
import entity.Flight;
import logic.PriceFixer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by dennis on 04.06.2015.
 */
public class AdditionPriceTag extends TagSupport {
    private static final Logger log = LogManager.getLogger(AdditionPriceTag.class);
    private String addPrice;
    static DAOFactory daoFactory;
    Airplane airplane = null;

    public static void setDAOFactory(DAOFactory factory) {
        daoFactory = factory;
    }

    public void setAddPrice(Flight flight){
        setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOAirplane idaoAirplane = daoFactory.getAirplaneDAO();
        IDAOFlight idaoFlight = daoFactory.getFlightDAO();
        airplane = idaoAirplane.findAirplaneById(flight.getAirplanesId());

        PriceFixer priceFixer = new PriceFixer();
        String price = Integer.toString(priceFixer.fixer(
                flight.getId(),
                flight.getCreTime(),
                flight.getFlightDate(),
                flight.getPrice(),
                airplane.getNumOfSeats(),
                idaoFlight.busyPlaces(flight.getId()))/100
        );

        System.out.println(price);
        this.addPrice = price;
    }

    public int doStartTag() {
        try {
            pageContext.getOut().write("~" + addPrice);
        } catch (IOException e) {
            System.out.println(e);
            log.warn(e);
        }
        return SKIP_BODY;
    }
}
