package com.ty.one_to_many;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class TestSaveAccountPage {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		UserAccount account=new UserAccount();
		account.setName("sexy sufiyan");
		account.setEmail("sexy sufiyan@gmail.com");
		account.setMobile(69693969);
		account.setPassword("sexy96");
		
		
		Page page1=new Page();
		page1.setName("FC");
		page1.setTitle("smarty");
		page1.setDescription("dekho mujhe sexy huu naa");
		
		Page page2=new Page();
		page2.setName("INSTA");
		page2.setTitle("cool dude");
		page2.setDescription("joosa kuditiya");
		
		List<Page> list=new ArrayList();
		list.add(page1);
		list.add(page2);
		account.setPage(list);
		
		
		entityTransaction.begin();
		entityManager.persist(account);
		entityManager.persist(page1);
		entityManager.persist(page2);
		entityTransaction.commit();
		
		
		
		
	}

}
