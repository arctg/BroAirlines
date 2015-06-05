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
public class Region {
    private int id;
    private String rName;

    public void setId(int id) {
        this.id = id;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public int getId() {
        return id;
    }

    public String getrName() {
        return rName;
    }
    
    
}
