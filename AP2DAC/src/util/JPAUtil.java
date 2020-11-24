package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("AP2DAC");
	
	public static EntityManager criarEntityManager() {
		return emf.createEntityManager();
	}
}
