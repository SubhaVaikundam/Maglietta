package com.maglietta.user.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * http://localhost:9080/maglietta/api/v1/departments
 * @author Subha
 *
 */
@Entity
@Table(name = "department")
@NamedStoredProcedureQueries({
	  @NamedStoredProcedureQuery(
	    name = "getDepartments", 
	    procedureName = "catalog_get_departments", 
	    resultClasses = { Department.class } 
	    ) 
	})
public class Department implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default Constructor	
	 */
	public Department(){
		/**
		 * default constructor
		 */
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id",unique = true, nullable = false, scale = 0)
	private Integer department_id;
	
		
	@NotNull
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "description")
	private String description;

	public Integer getDepartment_id() {
		return department_id;
	}


	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
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
