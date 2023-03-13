package com.example.geektrust.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StationAndPassangerSummary {

	private Map<String, Passanger> cardIdPassangerMap;
	private int amountOfTravelChargesAirport;
	private int amoutOfDiscountAirport;
	private int amountOfTravelChargesCentral;
	private int amountOfDiscountCentral;
	private List<CheckInDetails> passangerCheckInList;
	

	public StationAndPassangerSummary() {
		super();
		this.cardIdPassangerMap = new HashMap<>();
		this.amountOfDiscountCentral=0;
		this.amountOfTravelChargesAirport=0;
		this.amountOfTravelChargesCentral=0;
		this.amoutOfDiscountAirport=0;
		this.passangerCheckInList = new ArrayList<>();
	}

	public Map<String, Passanger> getCardIdPassangerMap() {
		return cardIdPassangerMap;
	}

	public void setCardIdPassangerMap(Map<String, Passanger> cardIdPassangerMap) {
		this.cardIdPassangerMap = cardIdPassangerMap;
	}

	public int getAmountOfTravelChargesAirport() {
		return amountOfTravelChargesAirport;
	}

	public void setAmountOfTravelChargesAirport(int amountOfTravelChargesAirport) {
		this.amountOfTravelChargesAirport = amountOfTravelChargesAirport;
	}

	public int getAmoutOfDiscountAirport() {
		return amoutOfDiscountAirport;
	}

	public void setAmoutOfDiscountAirport(int amoutOfDiscountAirport) {
		this.amoutOfDiscountAirport = amoutOfDiscountAirport;
	}

	public int getAmountOfTravelChargesCentral() {
		return amountOfTravelChargesCentral;
	}

	public void setAmountOfTravelChargesCentral(int amountOfTravelChargesCentral) {
		this.amountOfTravelChargesCentral = amountOfTravelChargesCentral;
	}

	public int getAmountOfDiscountCentral() {
		return amountOfDiscountCentral;
	}

	public void setAmountOfDiscountCentral(int amountOfDiscountCentral) {
		this.amountOfDiscountCentral = amountOfDiscountCentral;
	}

	public List<CheckInDetails> getPassangerCheckInList() {
		return passangerCheckInList;
	}

	public void setPassangerCheckInList(List<CheckInDetails> passangerCheckInList) {
		this.passangerCheckInList = passangerCheckInList;
	}
	
	
	
}
