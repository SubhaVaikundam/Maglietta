package com.maglietta.user.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * http://localhost:9080/maglietta/api/v1/categories/id/3
 * @author Subha
 *
 */
@Entity
@Table(name = "category")
@NamedStoredProcedureQueries({
	  @NamedStoredProcedureQuery(
	    name = "getCategoriesByDeptId", 
	    procedureName = "catalog_get_department_categories", 
	    resultClasses = { Category.class },
	    parameters = { 
	            @StoredProcedureParameter(name = "inDepartmentId",type = Integer.class,mode = ParameterMode.IN)            
	        })
	})
public class Category implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	
	public Category()
	{
		/**
		 * default constructor
		 */	
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id",unique = true, nullable = false, scale = 0)
	private Integer category_id;
	
		
	@NotNull
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "description")
	private String description;


	public Integer getCategory_id() {
		return category_id;
	}


	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	

}
