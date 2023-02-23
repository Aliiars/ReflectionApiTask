package com.ali.jtask2.model;

import java.util.List;

import javax.persistence.*;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import com.ali.jtask2.model.*;
import com.ali.jtask2.util.HibernateUtil;



@Entity
public class Phone  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Phone() {
		super();
	}

	public Phone(String phoneNumber, Customer customer) {

		this.phoneNumber = phoneNumber;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "Phone [id=" + id + ", phoneNumber=" + phoneNumber + ", customer=" + customer + "]";
	}

	


}
