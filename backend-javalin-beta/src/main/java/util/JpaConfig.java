package util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaConfig {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("library-jpa");

    public static EntityManagerFactory getEmf(){
        return emf;
    }

    public static void closeEmf(){
        emf.close();
    }
}
