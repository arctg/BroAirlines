package dao;

/**
 * Created by dennis on 24.05.2015.
 */
import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionPool {
    private static DataSource dataSource;

    public static synchronized Connection getConnection() {
        if (dataSource == null) {
            try {
                Context initContext = new InitialContext();
                Context envContext  = (Context)initContext.lookup("java:/comp/env");
                dataSource = (DataSource)envContext.lookup("jdbc/BroAirlines");
            } catch (NamingException e) {
                System.out.println("Cannot find the data source");
            }
        }

        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.out.println("Cannot establish connection " + e);
            return null;
        }
    }
}