/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.sql.Timestamp;
import java.util.Date;
/**
 *
 * @author dennis
 */
public class Order {
    private int id;
    private int flightsId;
    private int clientsId;
    private boolean laggage;
    private Date dateTime;
    private int orderPrice;
    private boolean priorityBoard;

    public void setId(int id) {
        this.id = id;
    }

    public void setFlightsId(int flightsId) {
        this.flightsId = flightsId;
    }

    public void setClientsId(int clientsId) {
        this.clientsId = clientsId;
    }

    public void setLaggage(boolean laggage) {
        this.laggage = laggage;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public void setOrderPrice(int orderPrice){
        this.orderPrice = orderPrice;
    }

    public void setPriorityBoard(boolean priorityBoard){
        this.priorityBoard = priorityBoard;
    }

    public int getId() {
        return id;
    }

    public int getFlightsId() {
        return flightsId;
    }

    public int getClientsId() {
        return clientsId;
    }

    public boolean isLaggage() {
        return laggage;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public boolean isPriorityBoard(){
        return priorityBoard;
    }
    
    
}
