package tags;

import dao.DAOFactory;
import dao.IDAOAirplane;
import dao.IDAOFlight;
import entity.Airplane;
import entity.Flight;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/**
 * Created by dennis on 03.06.2015.
 */
public class FreePlacesTag extends TagSupport {
    private String freePlaces;
    static DAOFactory daoFactory;
    Airplane airplane = null;
    Flight flight = null;

    public static void setDAOFactory(DAOFactory factory) {
        daoFactory = factory;
    }

    public void setFreePlaces(int id) {
        setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOFlight idaoFlight = daoFactory.getFlightDAO();
        IDAOAirplane idaoAirplane = daoFactory.getAirplaneDAO();
        int numOfBusySeats = idaoFlight.busyPlaces(id);
        flight = idaoFlight.findById(id);

        this.freePlaces = Integer.toString(idaoAirplane.findAirplaneById(flight.getAirplanesId()).getNumOfSeats() - numOfBusySeats);

    }

    public int doStartTag() {
        try {
            pageContext.getOut().write(freePlaces);
        } catch (IOException e) {
            System.out.println(e);
        }
        return SKIP_BODY;
    }
}
