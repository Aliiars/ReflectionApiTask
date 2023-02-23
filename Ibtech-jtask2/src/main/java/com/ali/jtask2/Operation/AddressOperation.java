package com.ali.jtask2.Operation;

import java.util.List;

import com.ali.jtask2.model.Address;

public class AddressOperation {
	
	public void add(List<Address> addressList, Address address) {
		
		addressList.add(address);
	}
	
	public void update(List<Address> addressList, Address address, int index) {
		
		addressList.set(index, address);
	}
	
	public void delete(List<Address> addressList, int index) {
		
		addressList.remove(index);
	}

}
