package commands;

import dao.DAOFactory;
import dao.IDAOAirplane;
import dao.IDAOCity;
import dao.IDAOFlight;
import entity.Airplane;
import entity.City;
import entity.Flight;
import logic.CurrentDate;
import manager.Config;
import manager.Message;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dennis on 01.06.2015.
 */
public class FindFlightCommand extends Command {
    private static final Logger log = LogManager.getLogger(FindFlightCommand.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        if (request.getSession().getAttribute("client")==null){ //Checking if the user logged in
            log.info("unauthorised login attempt detected");
            return Config.getInstance().getProperty(Config.LOGIN);
        }

        Flight flight = null;
        List<Flight> flightList = null;
        //Airplane airplane = null;
        ArrayList<Airplane> airplaneList = new ArrayList<Airplane>();
        City city = null;
        String page = null;

        Command.setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        IDAOFlight idaoFlight = daoFactory.getFlightDAO();
        IDAOCity idaoCity = daoFactory.getCityDAO();
        IDAOAirplane idaoAirplane = daoFactory.getAirplaneDAO();
        try {
            flightList = idaoFlight.findFlights(
                    new SimpleDateFormat("yy-MM-dd HH:mm").parse(request.getParameter("begindate")),
                    new SimpleDateFormat("yy-MM-dd HH:mm").parse(request.getParameter("enddate")),
                    Integer.parseInt(request.getParameter("fromcity")),
                    Integer.parseInt(request.getParameter("tocity"))
            );
        }catch (ParseException e){
            System.out.println(e);
            log.warn(e);
            try {
                flightList = idaoFlight.findFlights(
                        new SimpleDateFormat("yy-MM-dd").parse(request.getParameter("begindate")),
                        new SimpleDateFormat("yy-MM-dd").parse(request.getParameter("enddate")),
                        Integer.parseInt(request.getParameter("fromcity")),
                        Integer.parseInt(request.getParameter("tocity")));
            }catch (ParseException e2){
                System.out.println(e2);
                request.setAttribute("error",Message.getInstance().getProperty(Message.INVALID_DATE));
                log.warn(e2);
                page = Config.getInstance().getProperty(Config.ERROR);
                return page;
            }
        }

        System.out.println(flightList.size());
        for (int i=0;i<flightList.size();i++){
            if ((flightList.get(i).getFlightDate().compareTo(CurrentDate.getCurrentDate())<=0)|
                    (idaoFlight.busyPlaces(flightList.get(i).getId()))==
                            idaoAirplane.findAirplaneById(flightList.get(i).getAirplanesId()).getNumOfSeats()){
                System.out.println("removed");
                flightList.remove(i);
            }

//            System.out.println(idaoAirplane.findAirplaneById(flightList.get(i).getAirplanesId()).getVendorName());
//            System.out.println(flightList.get(i).getCreTime());
//            System.out.println(flightList.get(i).getFlightDate());
//            System.out.println(idaoCity.findById(flightList.get(i).getFrom()).getcName());
//            System.out.println(idaoCity.findById(flightList.get(i).getTo()).getcName());
//            System.out.println(flightList.get(i).getPrice());
//            System.out.println(idaoFlight.busyPlaces(flightList.get(i).getAirplanesId()));
            Airplane airplane = null;
//            System.out.println("Fuck!" + idaoAirplane.findAirplaneById(flightList.get(i).getAirplanesId()));
//            airplane = idaoAirplane.findAirplaneById(flightList.get(i).getAirplanesId());
            airplaneList.add(idaoAirplane.findAirplaneById(flightList.get(i).getAirplanesId()));


        }

        String resBeginDate = request.getParameter("begindate");
        String resEndDate = request.getParameter("enddate");
        City resFromCity = idaoCity.findById(Integer.parseInt(request.getParameter("fromcity")));
        City resToCity = idaoCity.findById(Integer.parseInt(request.getParameter("tocity")));

        request.setAttribute("begindate",resBeginDate);
        request.setAttribute("enddate",resEndDate);
        request.setAttribute("fromcity",resFromCity);
        request.setAttribute("tocity",resToCity);
        request.setAttribute("flightList",flightList);
        request.setAttribute("airplaneList",airplaneList);


        page = Config.getInstance().getProperty(Config.RESULT);
        return page;
    }




    }

