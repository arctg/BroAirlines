package logic;

import dao.DAOFactory;
import dao.IDAOAirplane;
import dao.IDAOFlight;
import entity.Airplane;
import entity.Flight;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by dennis on 04.06.2015.
 */

/**
 * Setting global prices for
 * @value PRIORITY_BOARDING - Priority bording service
 * @value BAGGAGE - baggage service
 * and returns new Date object
 * @see PriceFixer
 *
 *
 *
 */

public class PriceFixer {
    static DAOFactory daoFactory;
    public static final int PRIORITY_BOARDING = 2000;
    public static final int BAGGAGE = 1500;


    public static void setDAOFactory(DAOFactory factory) {
        daoFactory = factory;
    }

    /**
     * genereates price for flight bases on creation date of flight,
     * flight date and number of free places in airplane.
     * @param createDate - creating date of flight
     * @param flightDate - flight date
     * @param numOfPlaces - number of places in airplane
     * @param numOfBusyPlaces - number of busy places
     * @value BASE_COEFFICIENT - coefficient that gives max 25% add price for one service
     *
     *
     * @see PriceFixer
     *
     *
     *
     */

    public int fixer(int flightId, Date createDate, Date flightDate, int flightPrice, int numOfPlaces, int numOfBusyPlaces) {
        //changing price by dates
        final double BASE_COEFICIENT = 0.25;
        int priceCoeficient = 0;
        double dateCoeficient, placeCoeficient;

        Date currentDate = CurrentDate.getCurrentDate();

        double a = TimeUnit.DAYS.convert((currentDate.getTime() - createDate.getTime()), TimeUnit.MILLISECONDS);
        double b = TimeUnit.DAYS.convert((flightDate.getTime() - createDate.getTime()), TimeUnit.MILLISECONDS);
        double c = a / b;

        dateCoeficient = BASE_COEFICIENT * flightPrice * c;
        placeCoeficient = BASE_COEFICIENT * flightPrice * (((double) numOfBusyPlaces) / (double) numOfPlaces);
        priceCoeficient = (int) (dateCoeficient + placeCoeficient);

        return priceCoeficient;
    }


}
