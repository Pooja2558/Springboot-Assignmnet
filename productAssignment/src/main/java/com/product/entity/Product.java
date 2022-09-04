package com.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int productId;
private String name;
private String productType;

private double basePrice;

private String category;



public Product() {
	super();
	// TODO Auto-generated constructor stub
}





@Override
public String toString() {
	return "Product [productId=" + productId + ", name=" + name + ", productType=" + productType + ", basePrice="
			+ basePrice + ", category=" + category + "]";
}





public Product(int productId, String name, String productType, double basePrice, String category) {
	super();
	this.productId = productId;
	this.name = name;
	this.productType = productType;
	this.basePrice = basePrice;
	this.category = category;
}








public double getBasePrice() {
	return basePrice;
}





public void setBasePrice(double basePrice) {
	this.basePrice = basePrice;
}





public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getProductType() {
	return productType;
}
public void setProductType(String productType) {
	this.productType = productType;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}





}
