package com.example.geektrust.serviceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
	public void checkPassangerNotFoundException() {
		
		Passanger passanger = new Passanger("MC1", 50);
		
	}
	
}
