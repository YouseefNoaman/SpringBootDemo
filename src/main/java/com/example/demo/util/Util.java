package com.example.demo.util;

import com.example.demo.entity.Customer;

public class Util {

	/**
	 * @param String
	 * @return boolean, if the String is not null and not empty  
	 */
	public boolean checkString(String s) {
		if (s != null && !s.trim().equals(""))
			return true;
		return false;
	}

	/**
	 * @param Customer
	 * @return boolean, if the Customer is not null, and name and phoneNumber are not empty or null 
	 */
	public boolean checkCustomerObj(Customer c) {
		if (c != null && checkString(c.getName()) && checkString(c.getPhoneNumber()))
			return true;
		return false;
	}

}
