package com.cg.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.entity.Employee;

public class TestDisplay {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String qry = "select e from Employee e";
		TypedQuery<Employee> query = entityManager.createQuery(qry,Employee.class);
		List<Employee> list = query.getResultList();
		
		for(Employee employee : list)
		{
//			if(employee.getDepartment() != null)
//			{
//				employee.getDepartment().setDepartmentName("NULL");
//			}
			System.out.println(employee.getEmployeeName()+" "+employee.getDepartment().getDepartmentName());
		}
		
		entityManager.close();
		entityManagerFactory.close();

	}

}
