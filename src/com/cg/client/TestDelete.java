package com.cg.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Department;

public class TestDelete {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		
		Department department = entityManager.find(Department.class,1022);
		
		if(department != null)
		{
			entityManager.remove(department);
			System.out.println("Removed Successfully");
		}
		else
		{
			System.out.println("Deleting Failed / NOT FOUND ");
		}
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
