package com.ty.one_to_many;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestSaveGetMobileSim {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		
		Mobile mobile=entityManager.find(Mobile.class, 6);
		
		
		if(mobile!=null) {
			System.out.println("mobile id is : "+mobile.getId());
			System.out.println("mobile cost is : "+mobile.getCost());
			System.out.println("mobile name is : "+mobile.getName());
			
			
			System.out.println("sim details=======");
		List<Sim> sim=mobile.getSims();
		
		for(Sim sims:sim) {
			System.out.println("sim id is : "+sims.getId());
			System.out.println("sim provider is : "+sims.getProvider());
			System.out.println("sim type is : "+sims.getType());
			System.out.println("++++++++++++++++++");
		}

		}
		else {
			System.out.println("mobile is not available");
		}
	}

}
