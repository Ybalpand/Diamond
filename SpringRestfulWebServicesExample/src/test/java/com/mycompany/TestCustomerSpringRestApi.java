package com.mycompany;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.mycompany.bean.Customer;
import com.mycompany.bean.Document;

public class TestCustomerSpringRestApi {
	public static final String GET_ALL_CUSTOMER = "http://localhost:8080/SpringRestfulWebServicesExample/getAllCustomers";
	public static final String GET_CUSTOMER_BY_ID = "http://localhost:8080/SpringRestfulWebServicesExample/getCustomer/1";
	public static final String ADD_NEW_CUST = "http://localhost:8080/SpringRestfulWebServicesExample/addCustomer";
	public static final String UPDATE_CUST = "http://localhost:8080/SpringRestfulWebServicesExample/updateCustomer";
	public static final String DELETE_CUST = "http://localhost:8080/SpringRestfulWebServicesExample/deleteCustomer/1";
	
	public static void main(String[] args) {
		
		/*
		 * System.out.println("create"); addNewCustomer();
		 * 
		 * System.out.println("update"); updateCustomer();
		 * 
		 * System.out.println("delete"); deleteCustomer();
		 */
		  
		  System.out.println("create"); addNewCustomer();
		  
		  System.out.println("get All customer"); getAllCustomer();
		 
			System.out.println("get  customer By Id ");
//			System.out.println(c.getCustomerId()+c.getCustomerName());
			
	}
	

	private static void addNewCustomer() {
		RestTemplate restTemplate=new RestTemplate();
		List<Document> docList = new ArrayList<Document>();
		Document doc1 = new Document(101, "AdharCard", "2020/04/30 " , "Pune");
		Document doc2 = new Document(102, "ElectionID", "2020/05/01 ", "Nagpur");
		Document doc3 = new Document(103, "PanCard", "2020/05/02 ", "Mumbai");
		docList.add(doc1);
		docList.add(doc2);
		docList.add(doc3);
		
		Customer newCust =new Customer(99999, "NewCust", docList);
		Customer response = restTemplate.postForObject(ADD_NEW_CUST, newCust,Customer.class);	
		System.out.println(response);
	}

	private static void updateCustomer(){
		RestTemplate restTemplate=new RestTemplate();
		
		List<Document> docList = new ArrayList<Document>();
		Document doc1 = new Document(501, "AdharCard", "2020/04/30 " , "Pune");
		Document doc2 = new Document(502, "ElectionID", "2020/05/01 ", "Nagpur");
		Document doc3 = new Document(503, "PanCard", "2020/05/02 ", "Mumbai");
		docList.add(doc1);
		docList.add(doc2);
		docList.add(doc3);
		
		Customer updateCust =new Customer(100001, "VIVEK", docList);
		restTemplate.put(UPDATE_CUST, updateCust);
		//System.out.println(response);
	}
	
	private static List<Customer> getAllCustomer() {
		RestTemplate restTemplate=new RestTemplate();
		 return restTemplate.getForObject(GET_ALL_CUSTOMER, List.class);	
		
	}
	

	private static Customer getCustomerById() {
		RestTemplate restTemplate=new RestTemplate();
		 return restTemplate.getForObject(GET_CUSTOMER_BY_ID, Customer.class);	
		 
	}

	private static void deleteCustomer() {
		RestTemplate restTemplate=new RestTemplate();
		 restTemplate.delete(DELETE_CUST);
		
	}

}
