package sk.train.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Starter {

	public static void main(String[] args) {
		 
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Muster_JPA_Hibernate_H2_Local");
		 EntityManager em = emf.createEntityManager();
		 

	}

}
