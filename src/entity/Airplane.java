/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author dennis
 */
public class Airplane {
    private int id;
    private int numOfSeats;
    private String vendorName;
    
    
    public void setId(int id){
        this.id=id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setNumOfSeats(int numOfSeats){
        this.numOfSeats = numOfSeats;
    }
    
    public int getNumOfSeats(){
        return numOfSeats;
    }
    
    public void setVendorName(String vendorName){
        this.vendorName = vendorName;
    }
    
    public String getVendorName(){
        return vendorName;
    }


}
