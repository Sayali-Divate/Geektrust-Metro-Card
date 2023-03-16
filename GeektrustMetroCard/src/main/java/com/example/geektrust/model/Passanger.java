package com.example.geektrust.model;

import java.util.Objects;

public class Passanger {

	private String metroCardId;
	private int balance;
	private int numberOfjourney;
	
	public Passanger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passanger(String metroCardId, int balance) {
		super();
		this.metroCardId = metroCardId;
		this.balance = balance;
	}	

	public String getMetroCardId() {
		return metroCardId;
	}

	public void setMetroCardId(String metroCardId) {
		this.metroCardId = metroCardId;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getNumberOfjourney() {
		return numberOfjourney;
	}

	public void setNumberOfjourney(int numberOfjourney) {
		this.numberOfjourney = numberOfjourney;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, metroCardId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passanger other = (Passanger) obj;
		return Objects.equals(metroCardId, other.metroCardId) && Objects.equals(balance, other.balance);
	}
	
	
}
