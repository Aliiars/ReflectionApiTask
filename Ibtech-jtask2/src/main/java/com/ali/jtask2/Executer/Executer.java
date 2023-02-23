package com.ali.jtask2.Executer;

import java.lang.reflect.Method;
import java.util.List;

import org.hibernate.Session;
import com.ali.jtask2.model.Commandss;

public class Executer {
	
	public boolean execute(String CommandName,Session session,Object obj) {
		List<?> commandss = session.createQuery("from Commandss").list();
        for(Object acommand: commandss) {
        	Commandss acomm = (Commandss) acommand;
        	
        	if(acomm.getCommandName().equals(CommandName)) {
					Method methodForReflection;
					try {
						methodForReflection = obj.getClass().getSuperclass().getDeclaredMethod(acomm.getMethodName(),Session.class);
						methodForReflection.setAccessible(true);
						methodForReflection.invoke(obj, session);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return true;
        	}
        }
		return false;
	}

}
