/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.City;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dennis
 */
public class MDAOCity implements IDAOCity {
    private static final Logger log = LogManager.getLogger(MDAOCity.class);
    @Override
    public List<City> getAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<City> cityList = new ArrayList<>();

        try {
            connection = ConnectionPool.getConnection();
            try {
                statement = connection.prepareStatement("select * from cities");
                try {
                    resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        City city = new City();
                        city.setId(resultSet.getInt("id"));
                        city.setcName(resultSet.getString("cname"));
                        cityList.add(city);
                    }
                } finally {
                    if (resultSet != null) resultSet.close();
                }
            } finally {
                if (statement != null) statement.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
            log.warn(e);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e);
                    log.warn(e);
                }
            }
        }
        return cityList;

    }
    public City findById(int id){
        Connection connection = null;
        PreparedStatement statement = null;
        City city = new City();
        try {
            try {
                connection = ConnectionPool.getConnection();
                try {
                    statement = connection.prepareStatement("SELECT * FROM cities WHERE Id=?");
                    statement.setInt(1, id);
                    ResultSet resultSet = null;
                    try {
                        resultSet = statement.executeQuery();
                        resultSet.next();
                        city.setId(resultSet.getInt("Id"));
                        city.setcName(resultSet.getString("cname"));
                        city.setRegionsId(resultSet.getInt("regions_Id"));
                        return city;

                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println(e);
                        log.warn(e);
                    } finally {
                        if (resultSet != null) resultSet.close();
                    }
                } catch (SQLException e) {
                    System.out.println(e);
                    log.warn(e);
                } finally {
                    if (statement != null) statement.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
                log.warn(e);
            } finally {
                if (connection != null) connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e);
            log.warn(e);
        }
        return null;
    }
    }

