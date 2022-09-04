package com.product.entity;

public class ProductResponce {
 
	private int productId;
	private String name;
	private String productType;
	private String category;
	private double baseprice;
	private double discount;
    private charges charges;
    private double finalPrice;
	public ProductResponce() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public ProductResponce(int productId, String name, String productType, String category, double baseprice,
			double discount, com.product.entity.charges charges, double finalPrice) {
		super();
		this.productId = productId;
		this.name = name;
		this.productType = productType;
		this.category = category;
		this.baseprice = baseprice;
		this.discount = discount;
		this.charges = charges;
		this.finalPrice = finalPrice;
	}



	public charges getCharges() {
		return charges;
	}



	public void setCharges(charges charges) {
		this.charges = charges;
	}



	public double getFinalPrice() {
		return finalPrice;
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
	public double getBaseprice() {
		return baseprice;
	}
	public void setBaseprice(double baseprice) {
		this.baseprice = baseprice;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	@Override
	public String toString() {
		return "ProductResponce [productId=" + productId + ", name=" + name + ", productType=" + productType
				+ ", category=" + category + ", baseprice=" + baseprice + ", discount=" + discount + ", charges="
				+ charges + ", finalPrice=" + finalPrice + "]";
	}
	
    
    
   
}