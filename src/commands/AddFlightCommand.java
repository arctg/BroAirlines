package commands;

import dao.DAOFactory;
import dao.IDAOCity;
import dao.IDAOFlight;
import dao.MySQLDAOFactory;
import entity.Airplane;
import entity.City;
import entity.Client;
import entity.Flight;
import logic.CurrentDate;
import logic.MD5;
import manager.Config;
import manager.Message;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;



/**
 * Created by dennis on 30.05.2015.
 */
public class AddFlightCommand extends Command {
    private static final Logger log = LogManager.getLogger(AddFlightCommand.class);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("client")==null){ //Checking if the user logged in
            log.info("unauthorised login attempt detected");
            return Config.getInstance().getProperty(Config.LOGIN);
        }

        Flight flight = new Flight();
        String page = null;
        Date date = CurrentDate.getCurrentDate();
        Date setDate = null;
        List<City> cityList= null;


        Command.setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOFlight idaoFlight = daoFactory.getFlightDAO();
        try {
            setDate = new SimpleDateFormat("yy-MM-dd HH:mm").parse(request.getParameter("date"));
        } catch (ParseException ea) {
            log.warn(ea);
            try {
                setDate = new SimpleDateFormat("yy-MM-dd").parse(request.getParameter("date"));
            } catch (ParseException e) {
                System.out.println(e);
                log.warn(e);
                request.setAttribute("error", Message.getInstance().getProperty(Message.INVALID_DATE));
                page = Config.getInstance().getProperty(Config.ERROR);
                return page;
            }
        }
        if (Integer.parseInt(request.getParameter("fromcity")) == Integer.parseInt(request.getParameter("tocity"))) {
            request.setAttribute("error", Message.getInstance().getProperty(Message.CITY_ERROR));
            log.warn("fromCity==toCity");
            page = Config.getInstance().getProperty(Config.ERROR);
            return page;
        } else if (date.compareTo(setDate) >= 0) {
            request.setAttribute("error", Message.getInstance().getProperty(Message.DATE_ERROR));
            page = Config.getInstance().getProperty(Config.ERROR);
            return page;
        } else {
            try {
                flight.setFlightDate(new SimpleDateFormat("yy-MM-dd HH:mm").parse(request.getParameter("date")));
            } catch (ParseException e) {
                System.out.println(e);
                log.warn(e);
                try {
                    flight.setFlightDate(new SimpleDateFormat("yy-MM-dd").parse(request.getParameter("date")));
                } catch (ParseException el) {
                    log.warn(el);
                }
                request.setAttribute("error", Message.getInstance().getProperty(Message.DATE_ERROR));
            }
            flight.setFrom(Integer.parseInt(request.getParameter("fromcity")));
            flight.setTo(Integer.parseInt(request.getParameter("tocity")));
            //flight.setPrice(Integer.parseInt(request.getParameter("price")) * 100);
            flight.setPrice((int)((Float.parseFloat(request.getParameter("price"))) * 100));
            flight.setAirplanesId(Integer.parseInt(request.getParameter("airplane")));

            idaoFlight.add(flight);
            log.info("Flight addeded");
            log.info("redirecting to main");

            IDAOCity idaoCity = daoFactory.getCityDAO();
            cityList = idaoCity.getAll();
            request.setAttribute("city",cityList);

            page = Config.getInstance().getProperty(Config.MAIN);
        }
        return page;
    }
}



