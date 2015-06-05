/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author dennis
 */
public class MDAOOrder implements IDAOOrder {
    @Override
    public void update(Order order) {}

    @Override
    public void delete(Order order) {}

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
    public List<Order> getAll() {
        return null;
    }

    @Override
    public Order find(Order order) {
        return null;
    }


}
