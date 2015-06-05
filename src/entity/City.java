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
public class City {
    private int id;
    private String cName;
    private int regionsId;

    public int getId() {
        return id;
    }

    public String getcName() {
        return cName;
    }

    public int getRegionsId() {
        return regionsId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public void setRegionsId(int regionsId) {
        this.regionsId = regionsId;
    }
    
    
}
