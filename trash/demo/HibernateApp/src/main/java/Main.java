import entity.FilmsEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



public class Main {
    public static void main(String[] args) {


        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            FilmsEntity filmsEntity = new FilmsEntity();
            filmsEntity.setId(6);
            filmsEntity.setTitle("TestHibernate");
            filmsEntity.setBudget(10);
            filmsEntity.setDues(30);
            entityManager.persist(filmsEntity);

            transaction.commit();
        }
        finally {
            if (transaction.isActive())
            {
                transaction.rollback();

            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
