package com.example.geektrust.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.exception.PassangerNotFoundException;
import com.example.geektrust.model.CheckInDetails;
import com.example.geektrust.model.JourneyCharge;
import com.example.geektrust.model.Passanger;
import com.example.geektrust.service.TravelService;
import com.example.geektrust.service.TravelServiceImpl;

public class ServiceTest {
	
	private TravelService cardService;
	
	@BeforeEach
	public void initializeService() {
		
		this.cardService = new TravelServiceImpl();
	}
	
	@Test
	public void passangerRegistrationTest(){
		
		List<String> tokens = new ArrayList<>();
		tokens.add("MC1");
		tokens.add("100");
		
		cardService.registerMetroCardAndAddBalance(tokens);
		
		List<String> tokens1 = new ArrayList<>();
		tokens1.add("MC1");
		tokens1.add("50");
		
		Passanger passanger = cardService.registerMetroCardAndAddBalance(tokens1);
		Passanger expectedPassanger = new Passanger("MC1", 150);
		
		assertEquals(expectedPassanger, passanger);
	}
	
	@Test
	public void checkInExceptionTest() {
		
		List<String> tokens = new ArrayList<>();
		tokens.add("MC1");
		tokens.add("ADULT");
		tokens.add("CENTRAL");
		
		try {
			cardService.processCheckIn(tokens);
		} catch (PassangerNotFoundException e) {
			
			assertEquals("Invalid id. Passanger is not registered for metro card", e.getMessage());
		}
	}
	
	@Test
	public void journeyChargeTest() throws PassangerNotFoundException {
		
		List<String> tokens = new ArrayList<>();
		tokens.add("MC1");
		tokens.add("200");
		
		cardService.registerMetroCardAndAddBalance(tokens);
		
		CheckInDetails personChecksIn1 = cardService.enterCheckedInDetails("MC1", "ADULT", "CENTRAL");		
		JourneyCharge centralCharge1 =  cardService.chargesAndDiscountCalculation("MC1", personChecksIn1.getCharge());
		JourneyCharge expectedCharge1 = new JourneyCharge(0, 200);		
		
//		System.out.println(centralCharge1);
		
		CheckInDetails personChecksIn2 = cardService.enterCheckedInDetails("MC1", "ADULT", "AIRPORT");		
		JourneyCharge airportCharge2 =  cardService.chargesAndDiscountCalculation("MC1", personChecksIn2.getCharge());
		JourneyCharge expectedCharge2 = new JourneyCharge(100, 102);
		
//		System.out.println(airportCharge2);
		
		CheckInDetails personChecksIn3 = cardService.enterCheckedInDetails("MC1", "ADULT", "CENTRAL");		
		JourneyCharge centralCharge3 =  cardService.chargesAndDiscountCalculation("MC1", personChecksIn3.getCharge());
		JourneyCharge expectedCharge3 = new JourneyCharge(0, 204);
		
//		System.out.println(centralCharge3);
		
		assertTrue(centralCharge1.equals(expectedCharge1) && airportCharge2.equals(expectedCharge2) && centralCharge3.equals(expectedCharge3));
		
	}

	
	
}
