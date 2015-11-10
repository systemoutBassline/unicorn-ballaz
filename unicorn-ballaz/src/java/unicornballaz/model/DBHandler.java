/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicornballaz.model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 *
 * @author Charlotte
 */
public class DBHandler {

    private static final String PERSISTENCE_UNIT_NAME = "unicorn-county";
    private EntityManagerFactory factory;
    private EntityManager em;

    public DBHandler() {

    }

    public void openConnection() {
        try {
            factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
            em = factory.createEntityManager();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }

    public void closeConnection() {
        em.close();
    }
    
    public List<Products> getListFromDB() {
        openConnection();
        Query q = em.createQuery("SELECT p FROM Products p");
        List<Products> list = q.getResultList();
        closeConnection();
        return list;
    }
}
