/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Region;
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
public class MDAORegion implements IDAORegion {
    private static final Logger log = LogManager.getLogger(MDAOOrder.class);
    @Override
    public List<Region> getAll() {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        ArrayList<Region> regionList = new ArrayList<>();

        try {
            connection = ConnectionPool.getConnection();
            try {
                statement = connection.prepareStatement("select * from regions");
                try {


                    resultSet = statement.executeQuery();
                    while (resultSet.next()) {
                        Region region = new Region();
                        region.setId(resultSet.getInt("id"));
                        region.setrName(resultSet.getString("rname"));
                        regionList.add(region);
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
        return regionList;
    }
}
