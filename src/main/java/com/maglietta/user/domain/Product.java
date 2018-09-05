package com.maglietta.user.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.ParameterMode;

/**
 * http://localhost:9080/maglietta/api/v1/category/id/2/1000/50/7
 * 
 * @author Subha
 *
 */
@Entity
@Table(name = "product")
@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(name = "findProductsByCategoryId", procedureName = "catalog_get_products_in_category", resultClasses = {
				Product.class }, parameters = {
						@StoredProcedureParameter(name = "inCategoryId", type = Integer.class, mode = ParameterMode.IN),
						@StoredProcedureParameter(name = "inShortProductDescriptionLength", type = Integer.class, mode = ParameterMode.IN),
						@StoredProcedureParameter(name = "inProductsPerPage", type = Integer.class, mode = ParameterMode.IN),
						@StoredProcedureParameter(name = "inStartItem", type = Integer.class, mode = ParameterMode.IN) })		 
		})
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Product() {
		//
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id", unique = true, nullable = false, scale = 0)
	private Integer product_id;

	@NotNull
	@Column(name = "name")
	private String name;

	@NotNull
	@Column(name = "description")
	private String description;

	@NotNull
	@Column(name = "price")
	private float price;

	@NotNull
	@Column(name = "discounted_price")
	private float discounted_price;

	@Column(name = "image")
	private String image;

	@Column(name = "image_2")
	private String image_2;

	@Column(name = "thumbnail")
	private String thumbnail;
	@NotNull
	@Column(name = "display")
	private int display;

	public Integer getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Integer product_id) {
		this.product_id = product_id;
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

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getDiscounted_price() {
		return discounted_price;
	}

	public void setDiscounted_price(float discounted_price) {
		this.discounted_price = discounted_price;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImage_2() {
		return image_2;
	}

	public void setImage_2(String image_2) {
		this.image_2 = image_2;
	}

	public int getDisplay() {
		return display;
	}

	public void setDisplay(int display) {
		this.display = display;
	}

}
