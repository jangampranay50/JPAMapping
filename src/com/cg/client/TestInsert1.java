package com.cg.client;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.entity.Department;
import com.cg.entity.Employee;

public class TestInsert1 {

	public static void main(String[] args) {
		
		EntityManagerFactory  entityManagerFactory=Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager  = entityManagerFactory.createEntityManager();
		Scanner scr = new Scanner(System.in);
		System.out.println("enter employee name");
		String name = scr.nextLine();
		System.out.println("enter salary");
		double salary = scr.nextDouble();
		System.out.println("Enter department id");
		int deptid = scr.nextInt();
		if(entityManager.find(Department.class,deptid)!=null)
		{
		Department dept = new Department();
		
		dept.setDepartmentId(deptid);
		
		Employee  employee = new Employee();
		
		employee.setEmployeeName(name);
		employee.setEmployeeSalary(salary);
		
		employee.setDepartment(dept);
		
		entityManager.getTransaction().begin();
		
		//entityManager.persist(dept);
		entityManager.persist(employee);
		
		entityManager.getTransaction().commit();
		}
		else
		{
			System.out.println(deptid+"not found");
		}
		
		
		entityManager.close();
        entityManagerFactory.close();
        System.out.println(" object persisted ");
        
	}

}
