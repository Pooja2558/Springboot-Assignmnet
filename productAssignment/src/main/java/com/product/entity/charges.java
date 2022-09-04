package com.product.entity;

public class charges {
	private double gst;
    private double deliverycharges;
	public charges() {
		super();
		// TODO Auto-generated constructor stub
	}
	public charges(double gst, double deliverycharges) {
		super();
		this.gst = gst;
		this.deliverycharges = deliverycharges;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	public double getDeliverycharges() {
		return deliverycharges;
	}
	public void setDeliverycharges(double deliverycharges) {
		this.deliverycharges = deliverycharges;
	}
	@Override
	public String toString() {
		return "charges [gst=" + gst + ", deliverycharges=" + deliverycharges + "]";
	}

	
    
    
}
