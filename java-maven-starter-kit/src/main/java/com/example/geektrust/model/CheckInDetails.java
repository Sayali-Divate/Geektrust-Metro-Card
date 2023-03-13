package com.example.geektrust.model;

import java.util.Objects;

public class CheckInDetails {

	private String metroCardId;
	private String passangerType;
	private String fromStation;
	private int charge;
	private JourneyCharge actualCharge;
	
	public CheckInDetails(String metroCardId, String passangerType, String fromStation) {
		super();
		this.metroCardId = metroCardId;
		this.passangerType = passangerType;
		this.fromStation = fromStation;
		this.charge = setChargeBasedOnPassangerType(this.passangerType);
	}

	private int setChargeBasedOnPassangerType(String passangerType) {	
		
		switch(passangerType) {
		
			case "ADULT" : return 200;
			case "SENIOR_CITIZEN" : return 100;
			default : return 50;			
				
		}
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

	public void setCharge(int charge) {
		this.charge = charge;
	}

	@Override
	public int hashCode() {
		return Objects.hash(metroCardId, passangerType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckInDetails other = (CheckInDetails) obj;
		return Objects.equals(metroCardId, other.metroCardId) && Objects.equals(passangerType, other.passangerType);
	}
	
	
	
	
}
