package com.maglietta.user.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.maglietta.user.domain.Category;
import com.maglietta.user.domain.Product;
import com.maglietta.user.domain.Department;
import com.maglietta.user.service.ProductCatalogService;

/**
 * 
 * @author Subha
 *
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/maglietta/api", produces = { "application/json" })
public class ProductCatalogController {
	@Autowired
	private ProductCatalogService productCatalogService;
	
	/**
	 * http://localhost:9080/maglietta/api/v1/departments
	 * @return
	 */
	@RequestMapping(value = { "/v1/departments" }, method = RequestMethod.GET)
	public ResponseEntity<List<Department>> getDepartments() {
		return new ResponseEntity<>(productCatalogService.getDepartments(), HttpStatus.OK);
	}
	
	/**
	 * http://localhost:9080/maglietta/api/v1/categories/departmentid/3
	 * @return
	 */
	@RequestMapping(value = { "/v1/categories/departmentid/{departmentId}" }, method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getCategoriesByDeptId(@PathVariable final Integer departmentId) {
		return new ResponseEntity<>(productCatalogService.getCategoriesByDeptId(departmentId), HttpStatus.OK);
	}
	
	
	/*
	 * http://localhost:9080/maglietta/api/v1/products/categoryid/2/1000/50/7
	 */
	@RequestMapping(value = "/v1/products/categoryid/{categoryId}/{shortProductDescriptionLength}/{productsPerPage}/{startItem}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable final Integer categoryId,@PathVariable final Integer shortProductDescriptionLength
			,@PathVariable final Integer productsPerPage,@PathVariable final Integer startItem) {
		return (ResponseEntity<List<Product>>) new ResponseEntity<>(
				productCatalogService.getProductByCategoryId(categoryId,shortProductDescriptionLength,productsPerPage,startItem), HttpStatus.OK);
	}
	
	/**
	 * http://localhost:9080/maglietta/api/v1/product/productid/10
	 * @param productId
	 * @return
	 */
	@RequestMapping(value = "/v1/product/productid/{productId}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Optional<Product>> getProductDetailsByProductId(@PathVariable final Integer productId) {
		return (ResponseEntity<Optional<Product>>) new ResponseEntity<>(
				productCatalogService.getProductDetailsByProductId(productId), HttpStatus.OK);
	}
	
	
	
	
}
