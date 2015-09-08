/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import java.util.Date;
/**
 *
 * @author dennis
 */
public class Flight {
    private int id;
    private Date creTime;
    private Date flightDate;
    private int price;
    private int airplanesId;
    private int from;
    private int to;

    public void setId(int id) {
        this.id = id;
    }

    public void setCreTime(Date creTime) {
        this.creTime = creTime;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setAirplanesId(int airplanesId) {
        this.airplanesId = airplanesId;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public int getId() {
        return id;
    }

    public Date getCreTime() {
        return creTime;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public int getPrice() {
        return price;
    }

    public int getAirplanesId() {
        return airplanesId;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }
    
    
}
