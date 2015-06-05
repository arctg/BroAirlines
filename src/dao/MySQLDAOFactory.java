/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author dennis
 */
public class MySQLDAOFactory extends DAOFactory {

    @Override
    public IDAOAirplane getAirplaneDAO() {
        return new MDAOAirplane();
    }

    public IDAOCity getCityDAO(){
        return new MDAOCity();
    }

    public IDAOClient getClientDAO() {
        return new MDAOClient();
    }

    public IDAOFlight getFlightDAO() {
        return new MDAOFlight();
    }

    public IDAOOrder getOrderDAO() {
        return new MDAOOrder();
    }

    public IDAORegion getRegionDAO() {
        return new MDAORegion();
    }



}
