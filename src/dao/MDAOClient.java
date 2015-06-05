/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.Client;

/**
 * @author dennis
 */
public class MDAOClient implements IDAOClient {

    public int create(Client client) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionPool.getConnection();

            statement = connection.prepareStatement("INSERT INTO clients "
                    + "(fname,lname,passwd,phone,email) VALUES "
                    + "(?,?,?,?,?)");
            statement.setString(1, client.getfName());
            statement.setString(2, client.getlName());
            statement.setString(3, client.getPassword());
            statement.setString(4, client.getPhone());
            statement.setString(5, client.getEmail());

            return statement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
            return -1;
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
    public boolean find(String email, String passwd) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = ConnectionPool.getConnection();
            try {
                statement = connection.prepareStatement("SELECT email,passwd FROM clients WHERE email=? AND passwd=?");
                statement.setString(1, email);
                statement.setString(2, passwd);
                ResultSet resultSet = null;
                try {
                    resultSet = statement.executeQuery();
                    return resultSet.next();
                } finally {
                    if (resultSet != null) resultSet.close();
                }
            } finally {
                if (statement != null) statement.close();
            }

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e);
                    return false;
                }
            }
        }
    }

    @Override
    public Client findByEmail(String email) {
        Connection connection = null;
        PreparedStatement statement = null;
        Client client = new Client();
        try {
            try {
                connection = ConnectionPool.getConnection();
                try {
                    statement = connection.prepareStatement("SELECT * FROM clients WHERE email=?");
                    statement.setString(1, email);
                    ResultSet resultSet = null;
                    try {
                        resultSet = statement.executeQuery();
                        resultSet.next();
                        client.setId(resultSet.getInt("Id"));
                        client.setfName(resultSet.getString("fname"));
                        client.setlName(resultSet.getString("lname"));
                        client.setPhone(resultSet.getString("phone"));
                        client.setAdmin(resultSet.getBoolean("admin"));
                        client.setEmail(resultSet.getString("email"));
                        return client;

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
