package com.maglietta.user.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maglietta.user.constant.Constant;
import com.maglietta.user.domain.Customer;
import com.maglietta.user.dto.MessageResponse;
import com.maglietta.user.exception.CustomerCreateException;
import com.maglietta.user.exception.NoCustomerFoundException;
import com.maglietta.user.repository.CustomerRepository;

/**
 * 
 * @author Subha
 *
 */
@Service
public class CustomerService {
	@Autowired
	public CustomerRepository customerRepository;

	/** The em. */
	@PersistenceContext
	private EntityManager em;

	/**
	 * 
	 * @return
	 */
	public List<Customer> getAll() {
		List<Customer> customerDetails;
		customerDetails = customerRepository.findAll();
		if (!customerDetails.isEmpty()) {
			return customerDetails;
		} else {
			throw new NoCustomerFoundException(Constant.NO_RESULTS_FOUND);
		}
	}

	/**
	 * 
	 * @param customerId
	 * @return
	 */
	public Optional<Customer> getCustomerByCustomerId(Integer customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);

		if (!customer.isPresent()) {
			throw new NoCustomerFoundException("id-" + customerId +"  "+ Constant.NO_RESULTS_FOUND);
		} else{
			return customer;
		}

	}

	/**
	 * 
	 * @param customer
	 * @return
	 */
	public MessageResponse createNewCustomer(Customer customer) {

		try {
			customerRepository.save(customer);
		} catch (Exception e) {
			throw new CustomerCreateException(Constant.CUSTOMER_CREATE_FAILURE_MESSAGE);
		}
		return new MessageResponse(Constant.CUSTOMER_CREATE_SUCCESS_MESSAGE);
	}
}
