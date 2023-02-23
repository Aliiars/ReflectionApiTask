package com.ali.jtask2.Op;

import java.util.List;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.ali.jtask2.model.Phone;
import com.ali.jtask2.util.HibernateUtil;

public class PhoneOp {
	
public void savePhone(Phone phone) {
		
		org.hibernate.Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.save(phone);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	//update object
	public void updatePhone(Phone phone) {
		
		org.hibernate.Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.saveOrUpdate(phone);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	
	//delete object
	public void deletePhone(int id) throws Throwable, SystemException {
		
		Phone phone = null;
		
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = (Transaction) session.beginTransaction();
			
			//delete object
			phone = session.get(Phone.class, id);
			session.delete(phone);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	

	//read object
	public Object getPhoneById(int id) throws Exception, SystemException {
		
		Phone phone = null;
		
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = (Transaction) session.beginTransaction();
			
			//save object
			phone = session.get(Phone.class, id);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return phone;
		
	}
	
	//read all Phones
	@SuppressWarnings("unchecked")
	public List<Phone> getAllPhones() throws Exception, SystemException {
		
		List<Phone> phones = null;
		
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = (Transaction) session.beginTransaction();
			
			//get phones
			phones = session.createCriteria(Phone.class).list();
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}	
		return phones;
	}

}
