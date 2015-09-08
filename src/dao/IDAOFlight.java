/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.Flight;

import java.util.Date;
import java.util.List;

/**
 *
 * @author dennis
 */
public interface IDAOFlight {
    void add(Flight flight);
    void update(Flight flight);
    Flight findFlight(Flight flight);
    void delete(Flight flight);
    List<Flight> findFlights(Date beginDate,Date endDate, int fly_from, int fly_to);
    public int busyPlaces(int flightId);
    public Flight findById(int id);

}
