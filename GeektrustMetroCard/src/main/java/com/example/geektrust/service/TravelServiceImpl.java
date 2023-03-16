package com.example.geektrust.service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.example.geektrust.exception.PassangerNotFoundException;
import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CheckInDetails;
import com.example.geektrust.model.CommandAndInputs;
import com.example.geektrust.model.JourneyCharge;
import com.example.geektrust.model.Passanger;
import com.example.geektrust.model.StationAndPassangerSummary;

public class TravelServiceImpl implements TravelService {	
	
	private StationAndPassangerSummary summary;

	public TravelServiceImpl() {
		super();
		this.summary = new StationAndPassangerSummary();
	}	
	
	@Override
	public String executeCommand(List<CommandAndInputs> commandLine) throws ValidationException, PassangerNotFoundException {		
		
		String output="";
		
		for(CommandAndInputs inputs : commandLine) {
			
			CheckingInputs inputCheckService = new CheckingInputsImpl();
			inputCheckService.checkInputBeforeExecution(inputs);
			
			String command = inputs.getCommand();
			List<String> tokens = inputs.getInputs();
			
			switch(command) {
			
				case "BALANCE" : 					
					registerMetroCardAndAddBalance(tokens);
					break;
					
				case "CHECK_IN" :					
					processCheckIn(tokens);
					break;
					
				case "PRINT_SUMMARY" :					
					output = processPrintSummary();
			}
			
		}
		return output;
		
	}

	public String processPrintSummary() {		
		
		String overallSummary ="";
		
		overallSummary+="TOTAL_COLLECTION CENTRAL "+summary.getAmountOfTravelChargesCentral()+" "+summary.getAmountOfDiscountCentral()+"\n";
		overallSummary+="PASSENGER_TYPE_SUMMARY\n";
		overallSummary+= passangerTypeSummary("CENTRAL")+"\n";
		overallSummary+="TOTAL_COLLECTION AIRPORT "+summary.getAmountOfTravelChargesAirport()+" "+summary.getAmoutOfDiscountAirport()+"\n";
		overallSummary+="PASSENGER_TYPE_SUMMARY\n";
		overallSummary+= passangerTypeSummary("AIRPORT");
		
		System.out.println(overallSummary);
		return overallSummary;
	}

	public String passangerTypeSummary(String station) {
		
		Map<String, Set<CheckInDetails>> passangerTypeAndSetOfUniquePassangerById = summary.getPassangerCheckInList().stream().filter(passanger->passanger.getFromStation().equals(station)).collect(Collectors.groupingBy(passanger-> passanger.getPassangerType(), Collectors.toSet()));
		

		Map<String, Integer> sortedMap = passangerTypeAndSetOfUniquePassangerById.entrySet().stream()
                .sorted(new SortByValueThenKeyComparator())
                .collect(Collectors.toMap(Map.Entry::getKey,
				        entry-> entry.getValue().size(),
				        (oldValue, newValue) -> oldValue, 
				        LinkedHashMap::new));
      
		String summaryOfPassangersAtStation= sortedMap.entrySet().stream()
																	.map(entry->entry.getKey()+" "+entry.getValue())
																	.collect(Collectors.joining("\n"));		
		
		return summaryOfPassangersAtStation;		
		
		
	}

	public void processCheckIn(List<String> tokens) throws PassangerNotFoundException {
		
		String id = tokens.get(0);
		String type = tokens.get(1);
		String station = tokens.get(2);
		
		CheckInDetails checkIn = enterCheckedInDetails(id,type,station);		
		JourneyCharge chargeAndDiscount = chargesAndDiscountCalculation(id, checkIn.getCharge());
		checkIn.setActualCharge(chargeAndDiscount);
		summary.getPassangerCheckInList().add(checkIn);
		
		updateStationSummary(checkIn);
		
	}

	public void updateStationSummary(CheckInDetails checkIn) {
		
		switch(checkIn.getFromStation()) {
		
			case "CENTRAL" :
				summary.setAmountOfDiscountCentral(summary.getAmountOfDiscountCentral()+checkIn.getActualCharge().getDiscount());
				summary.setAmountOfTravelChargesCentral(summary.getAmountOfTravelChargesCentral()+checkIn.getActualCharge().getAmountPaid());
				break;
			case "AIRPORT" : 
				summary.setAmoutOfDiscountAirport(summary.getAmoutOfDiscountAirport()+checkIn.getActualCharge().getDiscount());
				summary.setAmountOfTravelChargesAirport(summary.getAmountOfTravelChargesAirport()+checkIn.getActualCharge().getAmountPaid());
			default : return;
		}
		
	}

	public JourneyCharge chargesAndDiscountCalculation(String id, int charge) throws PassangerNotFoundException {
		
		Passanger currPassanger = summary.getCardIdPassangerMap().get(id);
		
		if(currPassanger==null)
			throw new PassangerNotFoundException("Invalid id. Passanger is not registered for metro card");
		 
		int payableAmount=0;
		int discount=0;
		
		currPassanger.setNumberOfjourney(currPassanger.getNumberOfjourney()+1);
		if(currPassanger.getNumberOfjourney()%2==0) {			
			charge/=2;
			discount = charge;
		}
		if(currPassanger.getBalance()<charge) {
			
			int requiredCharge = charge - currPassanger.getBalance();
			payableAmount = (int)(requiredCharge*0.02) + charge;	
			currPassanger.setBalance(0);
		}
		else {
			
			payableAmount = charge;
			currPassanger.setBalance(currPassanger.getBalance()-payableAmount);
		}
		
		summary.getCardIdPassangerMap().put(id, currPassanger);
		
		JourneyCharge journeyCharge = new JourneyCharge(discount, payableAmount);
		return journeyCharge;
		
	}

	public CheckInDetails enterCheckedInDetails(String id, String type, String station) {	
		
		CheckInDetails checkedIn = new CheckInDetails(id, type, station);
		checkedIn.setCharge(type);
		return checkedIn;
	}

	public Passanger registerMetroCardAndAddBalance(List<String> tokens) {
		
		String cardId = tokens.get(0);
		int balance = Integer.parseInt(tokens.get(1));
		
		Map<String, Passanger> map = summary.getCardIdPassangerMap();
		
		if(map.containsKey(cardId)) {
			Passanger passanger = map.get(cardId);			
			int newBalance = passanger.getBalance() + balance;
			passanger.setBalance(newBalance);
			
			map.put(cardId, passanger);
			return passanger;
		}
		else {
			Passanger passanger = new Passanger(cardId, balance);
			map.put(cardId, passanger);
			return passanger;
		}
		
		
	}

	
}
