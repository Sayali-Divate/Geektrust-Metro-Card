package com.example.geektrust.model;

public class CheckInDetails {

	private String metroCardId;
	private String passangerType;
	private String fromStation;
	private int charge;
	private JourneyCharge actualCharge;	
	
	public CheckInDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CheckInDetails(String metroCardId, String passangerType, String fromStation) {
		super();
		this.metroCardId = metroCardId;
		this.passangerType = passangerType;
		this.fromStation = fromStation;		
	}

	public String getMetroCardId() {
		return metroCardId;
	}

	public void setMetroCardId(String metroCardId) {
		this.metroCardId = metroCardId;
	}

	public String getPassangerType() {
		return passangerType;
	}

	public void setPassangerType(String passangerType) {
		this.passangerType = passangerType;
	}

	public String getFromStation() {
		return fromStation;
	}

	public void setFromStation(String fromStation) {
		this.fromStation = fromStation;
	}

	public JourneyCharge getActualCharge() {
		return actualCharge;
	}

	public void setActualCharge(JourneyCharge actualCharge) {
		this.actualCharge = actualCharge;
	}

	public int getCharge() {
		return charge;
	}

	public void setCharge(String passangerType) {
		
		switch(passangerType) {
		
		case "ADULT" : this.charge = 200;
						break;
		case "SENIOR_CITIZEN" : this.charge = 100;
								break;
		default : this.charge=50;	
		
		}
			
	}
	
}
