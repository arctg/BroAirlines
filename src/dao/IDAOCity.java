/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.City;
import java.util.List;
/**
 *
 * @author dennis
 */
public interface IDAOCity {
    public List<City> getAll();
    public City findById(int id);
}
