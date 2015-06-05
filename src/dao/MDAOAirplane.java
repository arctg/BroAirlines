/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Airplane;
import entity.Airplane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dennis
 */
public class MDAOAirplane implements IDAOAirplane {
    @Override
    public Airplane findAirplaneById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Airplane airplane = new Airplane();

        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement("select * from airplanes where Id=?");
            statement.setInt(1,id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {

                airplane.setId(resultSet.getInt("Id"));
                airplane.setVendorName(resultSet.getString("vendorname"));
                airplane.setNumOfSeats(resultSet.getInt("numofseats"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (resultSet!=null){
                try{
                    resultSet.close();
                }catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
        }
        return airplane ;

    }

    @Override
    public void insertAirplane(Airplane airplane) {

    }

    @Override
    public void deleteAirplane(Airplane airplane) {

    }

    @Override
    public List<Airplane> getAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Airplane> airplaneList = new ArrayList<>();

        try {
            connection = ConnectionPool.getConnection();
            statement = connection.prepareStatement("select * from airplanes");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Airplane airplane = new Airplane();
                airplane.setId(resultSet.getInt("id"));
                airplane.setVendorName(resultSet.getString("vendorname"));
                airplane.setNumOfSeats(resultSet.getInt("numofseats"));
                airplaneList.add(airplane);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }finally {
            if (resultSet!=null){
                try {
                    resultSet.close();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
            if (statement!=null){
                try{
                    statement.close();
                }catch (SQLException e) {
                    System.out.println(e);
                }
            }
            if (connection!=null){
                try {
                    connection.close();
                }catch (SQLException e){
                    System.out.println(e);
                }
            }
        }
        return airplaneList;

    }


}
