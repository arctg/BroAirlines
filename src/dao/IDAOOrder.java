/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.util.List;
import entity.Order;

/**
 *
 * @author dennis
 */
public interface IDAOOrder {
    public void create(Order order);
    public Order find(Order order);
    public void update(Order order);
    public void delete(Order order);
    public List<Order> getAll();
    
}
