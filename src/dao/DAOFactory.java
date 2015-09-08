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
public abstract class DAOFactory {

    public enum Factories {
        MYSQL
    }

    public abstract IDAOAirplane getAirplaneDAO();
    public abstract IDAOCity getCityDAO();
    public abstract IDAOClient getClientDAO();
    public abstract IDAOFlight getFlightDAO();
    public abstract IDAOOrder getOrderDAO();
    public abstract IDAORegion getRegionDAO();

    public static DAOFactory getDaoFactory(Factories factoryName){
        switch (factoryName){
            case MYSQL:return new MySQLDAOFactory();
            default: return null;
        }
    }
    
}
