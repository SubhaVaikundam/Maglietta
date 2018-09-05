package com.maglietta.user.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maglietta.user.domain.Customer;
/**
 * 
 * @author Subha
 *
 */
@Transactional
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
