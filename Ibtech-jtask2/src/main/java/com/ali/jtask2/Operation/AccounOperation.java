package com.ali.jtask2.Operation;

import java.util.List;

import com.ali.jtask2.model.Account;

public class AccounOperation {
	
public void add(List<Account> accountList, Account account) {
		
		accountList.add(account);
	}
	
	public void update(List<Account> accountList, Account account, int index) {
		
		accountList.set(index, account);
	}
	
	public void delete(List<Account> accountList, int index) {
		
		accountList.remove(index);
	}

}
