package commands;

import dao.*;
import entity.*;
import logic.CurrentDate;
import manager.Config;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by dennis on 29.05.2015.
 */
public class GoToCabinetCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Airplane aiplane = null;
        Flight flight = null;
        Order order = null;
        //City city = null;
        Client client = null;
        ArrayList<Order> trueOrderList = null;
        ArrayList<Order> nearTrueList = new ArrayList<>();
        ArrayList<Order> falseOrderList = new ArrayList<>();
        setDAOFactory(DAOFactory.getDaoFactory(DAOFactory.Factories.MYSQL));
        //IDAOAirplane idaoAirplane = daoFactory.getAirplaneDAO();
        IDAOFlight idaoFlight = daoFactory.getFlightDAO();
        IDAOOrder idaoOrder = daoFactory.getOrderDAO();
        //IDAOCity idaoCity = daoFactory.getCityDAO();
        HttpSession session = request.getSession();
        client = (Client)session.getAttribute("client");
        trueOrderList = idaoOrder.getAllById(client.getId());
        Iterator<Order> iter = trueOrderList.iterator();

        while(iter.hasNext()){
            order = iter.next();
            flight = idaoFlight.findById(order.getFlightsId());

            if ((TimeUnit.DAYS.convert((flight.getFlightDate().getTime() -
                    CurrentDate.getCurrentDate().getTime()),
                    TimeUnit.MILLISECONDS)<3)&(TimeUnit.DAYS.convert((flight.getFlightDate().getTime() -
                            CurrentDate.getCurrentDate().getTime()),
                    TimeUnit.MILLISECONDS))>0){
                nearTrueList.add(order);
                iter.remove();
            }
            if (CurrentDate.getCurrentDate().compareTo(flight.getFlightDate())>=0){
                falseOrderList.add(order);
                System.out.println("removing");
                iter.remove();
            }
        }

//        System.out.println("Size of trueList: " + trueOrderList.size());
//        System.out.println("Size of nearTrueList: " + nearTrueList.size());
//        System.out.println("Size of falseList " + falseOrderList.size());
//        System.out.println(request.getLocale());
        request.setAttribute("trueOrderList", trueOrderList);
        request.setAttribute("nearTrueOrderList",nearTrueList);
        request.setAttribute("falseOrderList",falseOrderList);

        return Config.getInstance().getProperty(Config.CABINET);
    }
}
