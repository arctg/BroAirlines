/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.Client;
import java.util.List;
/**
 *
 * @author dennis
 */
public interface IDAOClient {
    public int create(Client client);
    public boolean find(String email, String passwd);
    public Client findByEmail(String email);
//    public void update(Client client);
//    public void delete(Client client);
//    public List<Client> getAll();
}
