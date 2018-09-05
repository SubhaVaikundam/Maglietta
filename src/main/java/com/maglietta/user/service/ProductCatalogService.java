package com.maglietta.user.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maglietta.user.domain.Category;
import com.maglietta.user.domain.Department;
import com.maglietta.user.domain.Product;
import com.maglietta.user.repository.ProductRepository;



/**
 * 
 * @author Subha
 *
 */
@Service
public class ProductCatalogService {

	/**
	 *  The em
	 */
	@PersistenceContext
	private EntityManager em;
	
	@Autowired
	public ProductRepository productRepository;
	
	/**
	 *  Get Departments	
	 * @return
	 */
	public List<Department> getDepartments() {
		StoredProcedureQuery findDepartments = em.createNamedStoredProcedureQuery("getDepartments");		
        return findDepartments.getResultList();
	}
	
	/**
	 * Get Categories List  by Department Id	
	 * @param departmentId
	 * @return
	 */
	public List<Category> getCategoriesByDeptId(Integer departmentId) {
		StoredProcedureQuery findCategoriesByDeptId =
	              em.createNamedStoredProcedureQuery("getCategoriesByDeptId");
		findCategoriesByDeptId.setParameter("inDepartmentId", departmentId);
		return findCategoriesByDeptId.getResultList();
	}
	
	/**
	 * Get Product List  by Category Id
	 * @param categoryId
	 * @param shortProductDescriptionLength
	 * @param productsPerPage
	 * @param startItem
	 * @return
	 */
	public List<Product> getProductByCategoryId(Integer categoryId,Integer shortProductDescriptionLength,Integer productsPerPage,Integer startItem) {
		StoredProcedureQuery findProductsByCategoryId =
	              em.createNamedStoredProcedureQuery("findProductsByCategoryId");
		findProductsByCategoryId.setParameter("inCategoryId", categoryId);
		findProductsByCategoryId.setParameter("inShortProductDescriptionLength", shortProductDescriptionLength);
		findProductsByCategoryId.setParameter("inProductsPerPage", productsPerPage);
		findProductsByCategoryId.setParameter("inStartItem", startItem);
        return findProductsByCategoryId.getResultList();
	}
	
	/**
	 * Get product details by product id
	 * @param productId
	 * @return
	 */
	public Optional<Product> getProductDetailsByProductId(Integer productId) {
		return productRepository.findById(productId);
	}
	
}
