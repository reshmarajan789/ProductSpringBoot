package com.project.Product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "product")
public class product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "product_id")
	private int id;
	@Column(name = "name")
	
	private String name;
	@NotNull
	
	private long price;
	@Pattern(regexp = "^\\d{10}$")
	
	private String productComanyPhoneNum;
	@Email(message = "message Shouldn't be null")
	
	private String productCompnayEmailId;
	
	@Min(1)@Max(2)
	private int  productToBeAddedTocart;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public String getProductComanyPhoneNum() {
		return productComanyPhoneNum;
	}
	public void setProductComanyPhoneNum(String productComanyPhoneNum) {
		this.productComanyPhoneNum = productComanyPhoneNum;
	}
	public String getProductCompnayEmailId() {
		return productCompnayEmailId;
	}
	public void setProductCompnayEmailId(String productCompnayEmailId) {
		this.productCompnayEmailId = productCompnayEmailId;
	}
	public int getProductToBeAddedTocart() {
		return productToBeAddedTocart;
	}
	public void setProductToBeAddedTocart(int productToBeAddedTocart) {
		this.productToBeAddedTocart = productToBeAddedTocart;
	}
	

}
