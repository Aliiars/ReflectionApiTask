package com.ali.jtask2.Op;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.ali.jtask2.model.Account;
import com.ali.jtask2.util.HibernateUtil;

import antlr.collections.List;

public class AccountOp {
	public void saveAccount(Account account) {
		
		org.hibernate.Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.save(account);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	//update object
	public void updateAccount(Account account) {
		
		org.hibernate.Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.saveOrUpdate(account);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	
	//delete object
	public void deleteAccount(int id) throws Exception, SystemException {
		
		Account account = null;
		
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = (Transaction) session.beginTransaction();
			
			//delete object
			account = session.get(Account.class, id);
			session.delete(account);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	

	//read object
	public Object getAccountById(int id) throws Exception, SystemException {
		
		Account account = null;
		
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = (Transaction) session.beginTransaction();
			
			//save object
			account = session.get(Account.class, id);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return account;
		
	}
	
	//read all Accounts
	@SuppressWarnings("unchecked")
	public List getAllAccounts() throws Exception, SystemException {
		
		List accounts = null;
		
		Transaction transaction = null;

		try(Session session = HibernateUtil.getSessionFactory().openSession()){
			//start transaction
			transaction = (Transaction) session.beginTransaction();
			
			//get accounts
			accounts = (List) session.createCriteria(Account.class).list();
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}	
		return accounts;
	}
	

}
