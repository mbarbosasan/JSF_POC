package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ap2DSW");
	
	public static EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	
	//public static Object getPrimaryKey(Object lancamento) {
		//return emf.getPersistenceUnitUtil().getIdentifier(lancamento);
	//}

}
