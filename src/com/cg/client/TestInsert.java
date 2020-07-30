package com.cg.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Department;
import com.cg.entity.Employee;

public class TestInsert {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Department department = new Department();
		department.setDepartmentName("Marketing");
		
		Employee employee = new Employee();
		
		employee.setEmployeeName("Kavita");
		employee.setEmployeeSalary(15000);
		employee.setDepartment(department);
		
		entityManager.getTransaction().begin();
		
		entityManager.persist(department);
		entityManager.persist(employee);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		System.out.println("Object Persisted");

	}

}
