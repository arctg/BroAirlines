/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Flight;
import logic.CurrentDate;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author dennis
 */
public class MDAOFlight implements IDAOFlight {
    @Override
    public Flight findFlight(Flight flight) {
        return null;
    }

    @Override
    public void add(Flight flight) {
        Connection connection = null;
        PreparedStatement statement = null;
        Date today;

        try {
            connection = ConnectionPool.getConnection();

            statement = connection.prepareStatement("INSERT INTO flights     "
                    + "(flightdate,price,airplanes_Id,fly_from,fly_to) VALUES "
                    + "(?,?,?,?,?)");
            statement.setTimestamp(1, new java.sql.Timestamp(flight.getFlightDate().getTime()));
            statement.setInt(2, flight.getPrice()*100); //we keep money in db in cents
            statement.setInt(3, flight.getAirplanesId());
            statement.setInt(4, flight.getFrom());
            statement.setInt(5, flight.getTo());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            //return -1;
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("MySQLClientDAO.create() can't close statement");
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("MySQLClientDAO.create() can't close connection");
                }
            }
        }


    }

    @Override
    public void delete(Flight flight) {

    }

    @Override
    public void update(Flight flight) {

    }

    @Override
    public List<Flight> findFlights(Date beginDate, Date endDate, int fly_from, int fly_to) {
        Date tmpDate = new Date();
        ArrayList<Flight> flightList = new ArrayList<Flight>();

        if ((beginDate.compareTo(CurrentDate.getCurrentDate())<=0)) beginDate = CurrentDate.getCurrentDate();
        if ((endDate.compareTo(CurrentDate.getCurrentDate()))<=0) endDate = CurrentDate.getCurrentDate();
        if(beginDate.compareTo(endDate)>0) {
            tmpDate = endDate;
            endDate = beginDate;
            beginDate = tmpDate;
        }

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnection();
            try {
                statement = connection.prepareStatement("SELECT * FROM flights WHERE TIMESTAMP(flightdate) BETWEEN ? AND ? AND fly_from=? AND fly_to=? ORDER BY flightdate");
                statement.setTimestamp(1, new Timestamp(beginDate.getTime()));
                statement.setTimestamp(2, new Timestamp(endDate.getTime()));
                statement.setInt(3,fly_from);
                statement.setInt(4,fly_to);
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery();
                    while (resultSet.next()){
                        Flight flight = new Flight();
                        flight.setId(resultSet.getInt("id"));
                        flight.setCreTime(resultSet.getTimestamp("cretime"));
                        flight.setFlightDate(resultSet.getTimestamp("flightdate"));
                        flight.setPrice(resultSet.getInt("price")/100);
                        flight.setAirplanesId(resultSet.getInt("airplanes_Id"));
                        flight.setFrom(resultSet.getInt("fly_from"));
                        flight.setTo(resultSet.getInt("fly_to"));
                        flightList.add(flight);
                    }
                    return flightList;
                } finally {
                    if (resultSet != null) resultSet.close();
                }
            } finally {
                if (statement != null) statement.close();
            }

        } catch (SQLException e) {
            System.out.println(e);
            return new ArrayList<>();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e);
                    return new ArrayList<>();
                }
            }
        }
    }

    @Override
    public int busyPlaces(int flightId) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getConnection();
            try {
                statement = connection.prepareStatement("select count(clients_Id) from orders where flights_Id=?");
                statement.setInt(1, flightId);
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery();
                    resultSet.next();

                    return resultSet.getInt("count(clients_Id)");
                } finally {
                    if (resultSet != null) resultSet.close();
                }
            } finally {
                if (statement != null) statement.close();
            }

        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e);
                    return 0;
                }
            }
        }
    }

    @Override
    public Flight findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        Flight flight = new Flight();
        try {
            try {
                connection = ConnectionPool.getConnection();
                try {
                    statement = connection.prepareStatement("SELECT * FROM flights WHERE Id=?");
                    statement.setInt(1, id);
                    ResultSet resultSet = null;
                    try {
                        resultSet = statement.executeQuery();
                        resultSet.next();
                        flight.setId(resultSet.getInt("id"));
                        flight.setCreTime(resultSet.getTimestamp("cretime"));
                        flight.setFlightDate(resultSet.getTimestamp("flightdate"));
                        flight.setPrice(resultSet.getInt("price")/100);
                        flight.setAirplanesId(resultSet.getInt("airplanes_Id"));
                        flight.setFrom(resultSet.getInt("fly_from"));
                        flight.setTo(resultSet.getInt("fly_to"));
                        return flight;

                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println(e);
                    } finally {
                        if (resultSet != null) resultSet.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                } finally {
                    if (statement != null) statement.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            } finally {
                if (connection != null) connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    }

