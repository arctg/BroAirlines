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
public class PriceFixer {
    static DAOFactory daoFactory;
    public static final int PRIORITY_BOARDING = 2000;
    public static final int BAGGAGE = 1500;


    public static void setDAOFactory(DAOFactory factory) {
        daoFactory = factory;
    }


    public  int fixer(int flightId, Date createDate, Date flightDate, int flightPrice, int numOfPlaces, int numOfBusyPlaces) {
        final double BASE_COEFICIENT = 0.25;
        int priceCoeficient = 0;
        double dateCoeficient, placeCoeficient;
        try {
            //Date currentDate = new SimpleDateFormat("yy-MM-dd HH:mm").parse("2015-06-22 00:00");
            //Date currentDate = new Date();
            Date currentDate = CurrentDate.getCurrentDate();

            double a = TimeUnit.DAYS.convert((currentDate.getTime() - createDate.getTime()), TimeUnit.MILLISECONDS);
            double b = TimeUnit.DAYS.convert((flightDate.getTime() - createDate.getTime()), TimeUnit.MILLISECONDS);
            double c = a / b;

            dateCoeficient = BASE_COEFICIENT * flightPrice * c;
            //System.out.println("date coef is" + dateCoeficient);

            placeCoeficient = BASE_COEFICIENT * flightPrice * (((double)numOfBusyPlaces) / (double)numOfPlaces);
            //System.out.println("place coef is" + placeCoeficient);
            priceCoeficient = (int) (dateCoeficient + placeCoeficient);
            //System.out.println("new price is" + priceCoeficient);

        } catch (Exception e) {
            System.out.println(e);
        }
    return priceCoeficient;
    }



}
