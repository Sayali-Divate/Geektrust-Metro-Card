package com.example.geektrust.model;

import java.util.Objects;

public class JourneyCharge {

	private int discount;
	private int amountPaid;	
	
	public JourneyCharge() {
		super();
		// TODO Auto-generated constructor stub
	}
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
	
	@Override
	public String toString() {
		return "JourneyCharge [discount=" + discount + ", amountPaid=" + amountPaid + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(amountPaid, discount);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JourneyCharge other = (JourneyCharge) obj;
		return amountPaid == other.amountPaid && discount == other.discount;
	}
	
	
	
	
}
