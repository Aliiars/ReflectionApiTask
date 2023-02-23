package com.ali.jtask2.Op;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Session;

import com.ali.jtask2.model.Customer;
import com.ali.jtask2.util.HibernateUtil;

public class CustomerOp {
	
public void saveCustomer(Customer customer) {
		
		org.hibernate.Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.save(customer);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	//update object
	public void updateCustomer(Customer customer) {
		
		org.hibernate.Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.saveOrUpdate(customer);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	
	//delete object
	public void deleteCustomer(int id) {
		
		Customer customer = null;
		
		org.hibernate.Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//delete object
			customer = session.get(Customer.class, id);
			session.delete(customer);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	

	//read object
	public Customer getCustomerById(int id) {
		
		Customer customer = null;
		
		org.hibernate.Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			customer = session.get(Customer.class, id);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return customer;
		
	}
	
	//read all Customers
	@SuppressWarnings("unchecked")
	public List<Customer> getAllCustomers() {
		
		List<Customer> customers = null;
		
		org.hibernate.Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//get customers
			customers = session.createCriteria(Customer.class).list();
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}	
		return customers;
	}

}
