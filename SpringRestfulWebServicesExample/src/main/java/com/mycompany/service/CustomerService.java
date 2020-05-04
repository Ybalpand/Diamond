package com.mycompany.service;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.mycompany.bean.Customer;
import com.mycompany.bean.Document;

@Service
public class CustomerService {

	static HashMap<Integer, Customer> customerIdMap = getCustomerIdMap();

	public CustomerService() {
		super();
		if (customerIdMap == null) {
			customerIdMap = new HashMap<Integer, Customer>();
			
			  List<Document> docList = new ArrayList<Document>();
			  
			  Document doc1 = new Document(1, "AdharCard", "2020/04/30 " , "Pune");
			  Document doc2 = new Document(2, "ElectionID", "2020/05/01 ", "Nagpur");
			  Document doc3 = new Document(3, "PanCard", "2020/05/02 ", "Mumbai");
			  docList.add(doc1); docList.add(doc2); docList.add(doc3);
			  
			  customerIdMap.put(1, new Customer(1, "A", docList)); 
			  customerIdMap.put(2, new Customer(2, "B", docList)); 
			  customerIdMap.put(3, new Customer(3, "C", docList));
			 
		}

	}

	public List<Customer> getAllCustomers() {
		List<Customer> listOfCustomers = new ArrayList(customerIdMap.values());
		return listOfCustomers;
	}

	
	public Customer getCustomerById( int customerId) {
		System.out.println("Rceived customer id "+customerId);
		Customer customerById = customerIdMap.get(customerId);
		System.out.println(customerById);
		return customerById;
	}	
	
	
	public Customer addCustomer(Customer customer) {
		customerIdMap.put(customer.getCustomerId(), customer);
		System.out.println("add new customer check");
		Customer custmerobj = customerIdMap.get(customer.getCustomerId());
		System.out.println("return new customer with customer id "+custmerobj.getCustomerId());
		return custmerobj;
	}

	private static HashMap<Integer, Customer> getCustomerIdMap() {
		return customerIdMap;
	}

	public Customer updateCustomer(Customer customer) {
		if(customerIdMap.containsKey(customer.getCustomerId()))
		{
			customerIdMap.put(customer.getCustomerId(), customer);
			Customer custmerobj = customerIdMap.get(customer.getCustomerId());
			return custmerobj;
		}else {
			return null;
		}
		
	}
	
	public void deleteCustomer(int customerId)
	{
		customerIdMap.remove(customerId);
	}

}