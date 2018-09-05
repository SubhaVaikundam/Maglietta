package com.maglietta.user.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maglietta.user.constant.Constant;
import com.maglietta.user.domain.Customer;
import com.maglietta.user.dto.MessageResponse;
import com.maglietta.user.exception.CustomerCreateException;
import com.maglietta.user.service.CustomerService;

/**
 * 
 * @author Subha
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/maglietta/api", produces = { "application/json" })
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = { "/v1/customers" }, method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return new ResponseEntity<>(customerService.getAll(), HttpStatus.OK);
	}

	/**
	 * 
	 * @param customerId
	 * @return
	 */
	@RequestMapping(value = "/v1/customer/id/{customerId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Customer>> getCustomerByCustomerId(@PathVariable final Integer customerId) {
		return (ResponseEntity<Optional<Customer>>) new ResponseEntity<>(
				customerService.getCustomerByCustomerId(customerId), HttpStatus.OK);
	}
	
	/**
	 * 
	 * @param customer
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping(value = { "/v1/createcustomer" }, method = RequestMethod.POST)
	public ResponseEntity<MessageResponse> createCustomer(@RequestBody Customer customer)
			{
		if (customer != null) {
			return new ResponseEntity<>(customerService.createNewCustomer(customer), HttpStatus.OK);
		} else {
			throw new CustomerCreateException(Constant.ERROR_EMPTY_LIST_CREATION);
		}

	}
	
	
	
	
}
