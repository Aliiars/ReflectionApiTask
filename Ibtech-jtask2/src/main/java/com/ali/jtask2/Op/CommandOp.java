package com.ali.jtask2.Op;

import java.util.List;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.ali.jtask2.model.Commandss;
import com.ali.jtask2.util.HibernateUtil;



public class CommandOp {
	
	public Commandss getCommand(String commandName) throws Exception, SystemException {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = (Transaction) session.beginTransaction();
			
			List<Commandss> commandss = session.createCriteria(Commandss.class).list();;
			
			//non-transactional
			//transaction.commit();
			
			for (Commandss commandItem : commandss) {
				if (commandItem.getCommandName().equals(commandName)) {
					return commandItem;
				}
			}
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return null;
	}

}
