/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dennis
 */
public class MDAOOrder implements IDAOOrder {
    private static final Logger log = LogManager.getLogger(MDAOOrder.class);

    @Override
    public void update(Order order) {}

    @Override
    public void delete(int orderId) {
        ArrayList<Order> orderList = new ArrayList<>();
        PreparedStatement statement = null;
        try(Connection connection = ConnectionPool.getConnection()){
            statement = connection.prepareStatement("delete from orders where Id=?");
            statement.setInt(1,orderId);
            try{
                statement.executeUpdate();
            }catch (SQLException e){
                System.out.println(e);
                log.warn(e);
            }
        }catch (SQLException e){
            System.out.println(e);
            log.warn(e);
        }
    }

    @Override
    public void create(Order order) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getConnection();

            statement = connection.prepareStatement("INSERT INTO orders "
                    + "(flights_Id,clients_Id,laggage,priboard,orderprice) VALUES "
                    + "(?,?,?,?,?)");
            statement.setInt(1, order.getFlightsId());
            statement.setInt(2, order.getClientsId());
            statement.setBoolean(3, order.isLaggage());
            statement.setBoolean(4, order.isPriorityBoard());
            statement.setInt(5, order.getOrderPrice());

            statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            log.warn(e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("MySQLClientDAO.create() can't close statement");
                    log.warn(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println("MySQLClientDAO.create() can't close connection");
                    log.warn(e);
                }
            }
        }

    }

    @Override
    public ArrayList<Order> getAllById(int clientId) {
        ArrayList<Order> orderList = new ArrayList<>();
        PreparedStatement statement = null;
        try(Connection connection = ConnectionPool.getConnection()){
            statement = connection.prepareStatement("select * from orders where clients_Id=?");
            statement.setInt(1,clientId);
            try(ResultSet resultSet = statement.executeQuery()){
                while(resultSet.next()){
                    Order order = new Order();
                    order.setId(resultSet.getInt("Id"));
                    order.setFlightsId(resultSet.getInt("flights_Id"));
                    order.setClientsId(resultSet.getInt("clients_Id"));
                    order.setLaggage(resultSet.getBoolean("laggage"));
                    order.setDateTime(resultSet.getTimestamp("datetime"));
                    order.setPriorityBoard(resultSet.getBoolean("priboard"));
                    order.setOrderPrice(resultSet.getInt("orderprice"));
                    orderList.add(order);
                }
                return orderList;
            }catch (SQLException e){
                System.out.println(e);
                log.warn(e);
            }
        }catch (SQLException e){
            System.out.println(e);
            log.warn(e);
        }
        return null;
    }

    @Override
    public Order find(Order order) {
        return null;
    }


}
