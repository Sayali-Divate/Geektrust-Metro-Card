package com.example.geektrust.service;

import java.util.List;

import com.example.geektrust.exception.ValidationExecption;
import com.example.geektrust.model.CommandAndInputs;
import com.example.geektrust.model.StationAndPassangerSummary;

public class TravelServiceImpl implements TravelService {
	
	private StationAndPassangerSummary summary;	

	public TravelServiceImpl() {
		super();
		this.summary = new StationAndPassangerSummary();
	}

	@Override
	public void executeCommand(List<CommandAndInputs> command) throws ValidationExecption {
		
		
			
		for(CommandAndInputs inputs : command) {
			
			CheckingInputs inputCheckService = new CheckingInputsImpl();
			inputCheckService.checkInputBeforeExecution(inputs);
			
		}
			
		
		
	}

	
}
