/**
 * 
 */
package com.smita.rest.model;

import java.io.Serializable;

/**
 * @author Smita
 *
 */
public class Customer implements Serializable{
	private static final long serialVersionUID = 2521193082584311744L;
	private int customerId;
	private String customerName;
	private String email;
	private String phone;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", email=" + email + ", phone="
				+ phone + "]";
	}
	public Customer(int customerId, String customerName, String email, String phone) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.email = email;
		this.phone = phone;
	}
	
}
