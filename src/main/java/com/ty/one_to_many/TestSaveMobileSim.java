package com.ty.one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveMobileSim {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Mobile mobile = new Mobile();
		mobile.setName("1plus");
		mobile.setCost(30000);

		Sim sim1 = new Sim();
		sim1.setProvider("BSNL");
		sim1.setType("2g");

		Sim sim2 = new Sim();
		sim2.setProvider("Vodafone");
		sim2.setType("4g");

		List<Sim> sims = new ArrayList<Sim>();
		sims.add(sim1);
		sims.add(sim2);

		mobile.setSims(sims);

		entityTransaction.begin();
		entityManager.persist(mobile);
		entityManager.persist(sim1);
		entityManager.persist(sim2);
		entityTransaction.commit();

	}

}
