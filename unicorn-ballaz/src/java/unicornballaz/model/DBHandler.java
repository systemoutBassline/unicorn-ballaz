/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unicornballaz.model;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
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
    private List<Users> userList;

    public DBHandler() {
        
    }
    
    public Users getUser(String username) {

		userList = getUsers();
		for (Users u : userList) {
			if (u.getUsername().equals(username)) {
				return u;
			}
		}
		return new Users();
	}

    @SuppressWarnings("unchecked")
	public List<Users> getUsers() {
		openConnection();
		Query q = em.createQuery("SELECT u FROM Users u");
		userList = q.getResultList();
		em.close();

		return userList;
	}
    
    public void createUser(String username, String password)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		openConnection();
		Users tempUser = new Users(username, password);

		em.getTransaction().begin();
		em.persist(tempUser);
		em.getTransaction().commit();
		closeConnection();
	}
    
    public boolean userExists(String username) {
		openConnection();
		Query q = em.createQuery("SELECT u FROM Users u");
		@SuppressWarnings("unchecked")
		List<Users> userList = q.getResultList();

        if (userList.stream().anyMatch((u) -> (username.equals(u.getUsername())))) {
            return true;
        } else {
        }
		return false;
	}
    
    public List<Products> getListFromDB() {
        openConnection();
        Query q = em.createQuery("SELECT p FROM Products p");
        List<Products> list = q.getResultList();
        closeConnection();
        return list;
    }
    
    @SuppressWarnings("unchecked")
	public boolean checkLogin(String username, String password)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		openConnection();
		Query q = em.createQuery("SELECT u FROM Users u");
		userList = q.getResultList();

		for (Users u : userList) {
			if (u.getUsername().equals(username)) {
				if (u.getPassword().equals((password))) {
					em.close();
					return true;
				}
			}
		}

		closeConnection();
		return false;
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
    
}
