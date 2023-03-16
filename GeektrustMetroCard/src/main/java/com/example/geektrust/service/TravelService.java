package com.example.geektrust.service;

import java.util.List;
import java.util.Map;

import com.example.geektrust.exception.PassangerNotFoundException;
import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CheckInDetails;
import com.example.geektrust.model.CommandAndInputs;
import com.example.geektrust.model.JourneyCharge;
import com.example.geektrust.model.Passanger;

public interface TravelService {

	String executeCommand(List<CommandAndInputs> command) throws ValidationException, PassangerNotFoundException;
	
	Passanger registerMetroCardAndAddBalance(List<String> tokens);
	
	JourneyCharge chargesAndDiscountCalculation(String id, int charge) throws PassangerNotFoundException;
	
	void processCheckIn(List<String> tokens) throws PassangerNotFoundException;
	
	CheckInDetails enterCheckedInDetails(String id, String type, String station);
	
	String processPrintSummary();
	
	String passangerTypeSummary(String station);

}
