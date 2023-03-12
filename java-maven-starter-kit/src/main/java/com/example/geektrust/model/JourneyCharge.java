package com.example.geektrust.model;

public class JourneyCharge {

	private int discount;
	private int amountPaid;
	
	public JourneyCharge(int discount, int amountPaid) {
		super();
		this.discount = discount;
		this.amountPaid = amountPaid;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(int amountPaid) {
		this.amountPaid = amountPaid;
	}
	
	
}
