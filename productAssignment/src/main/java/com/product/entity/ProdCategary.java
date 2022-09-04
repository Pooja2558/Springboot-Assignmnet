package com.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdCategary {
	
	private Long dis;
	private Long gst;
	private Long deliverycharge;
	@Id
	private String category;
	
	public ProdCategary() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProdCategary(Long dis, Long gst, Long deliverycharge, String category) {
		super();
		this.dis = dis;
		this.gst = gst;
		this.deliverycharge = deliverycharge;
		this.category = category;
	}

	public Long getDis() {
		return dis;
	}

	public void setDis(Long dis) {
		this.dis = dis;
	}

	public Long getGst() {
		return gst;
	}

	public void setGst(Long gst) {
		this.gst = gst;
	}

	public Long getDeliverycharge() {
		return deliverycharge;
	}

	public void setDeliverycharge(Long deliverycharge) {
		this.deliverycharge = deliverycharge;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ProdCategary [dis=" + dis + ", gst=" + gst + ", deliverycharge=" + deliverycharge + ", category="
				+ category + "]";
	}
	
	
	


	
	
	

}
