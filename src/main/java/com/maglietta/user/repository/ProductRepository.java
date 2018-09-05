package com.maglietta.user.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maglietta.user.domain.Product;

@Transactional
public interface ProductRepository extends JpaRepository<Product, Integer> {

}