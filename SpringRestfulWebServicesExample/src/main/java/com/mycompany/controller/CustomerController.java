package com.mycompany.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.mycompany.bean.Customer;
import com.mycompany.service.CustomerService;

@RestController
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/getAllCustomers", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Customer> getAllCustomer() {
		logger.info("Start getAllCustomer....");
//		List<Customer> listOfCustomer = new CustomerService().getAllCustomers();
//		System.out.println(	listOfCustomer.size());
//		listOfCustomer.size();
		return customerService.getAllCustomers();
	}

	@RequestMapping(value = "/getCustomer/{customerId}", method = RequestMethod.GET, headers = "Accept=application/json")
	public @ResponseBody ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId) {
		logger.info("Start getCustomerById....");
		System.out.println("In getCustomerby Id Controller,Customer id " + customerId);
		Customer customer = customerService.getCustomerById(customerId);

		if (customerId <= 0) {
			logger.info("400 (BAD REQUEST) : " + customerId);
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		}
		if (customer == null) {
			logger.info("customer is null in case 404 no found /Customer id is not found : " + customerId);
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST, headers = "Accept=application/json")
	// @ResponseStatus(HttpStatus.CREATED)
	public @ResponseBody ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {

		if (customer.getCustomerId() <= 0) {
			logger.info("BAD Request to add new customer" + customer.getCustomerId());
			return new ResponseEntity<Customer>(HttpStatus.BAD_REQUEST);
		} else {
			logger.info("Added new customer");
			return new ResponseEntity<Customer>(customerService.addCustomer(customer), HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT, headers = "Accept=application/json")
	public @ResponseBody ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		logger.info("Start updateCustomer....");
		
		if( customerService.updateCustomer(customer) == null ) {
			logger.info("Customer not Exists to update, CustomerId-" +customer.getCustomerId());
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}else {
			logger.info("Customer update successfully, CustomerId-" +customer.getCustomerId());
			return new ResponseEntity<Customer> ( HttpStatus.OK);
		}
		
	}
	

	@RequestMapping(value = "/deleteCustomer/{customerId}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public @ResponseBody void deleteCustomer(@PathVariable("customerId") int customerId) {
		logger.info("Start deleteCustomer....");
		customerService.deleteCustomer(customerId);
	}

}