package com.ty.one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestDeleteMobileSim {
	public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Mobile mobile=entityManager.find(Mobile.class, 1);
	List<Sim> sim=mobile.getSims();
	
	entityTransaction.begin();
	for(Sim sim1:sim) {
		entityManager.remove(sim1);
	}
	entityManager.remove(mobile);
	entityTransaction.commit();
	
	}

}
