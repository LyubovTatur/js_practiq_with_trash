package com.company;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main
{

    public static <Films> void main(String[] args) {
	// write your code here
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try{
            transaction.begin();



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

