package com.example.geektrust.service;

import java.util.List;

import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CommandAndInputs;

public class CheckingInputsImpl implements CheckingInputs {

	@Override
	public void checkInputBeforeExecution(CommandAndInputs commandWithTokens) throws ValidationException {
		
		String command = commandWithTokens.getCommand();

		List<String> inputs = commandWithTokens.getInputs();
		
		if(command.equals("BALANCE")) 		
			checkForBalanceCommand(inputs);
		
		else if(command.equals("CHECK_IN"))
			checkForCheckInCommand(inputs);
		
		else if(command.equals("PRINT_SUMMARY")) {			
			if(inputs.size()!=0)
				throw new ValidationException("There should be no inputs after PRINT_SUMMARY command");
		}
		else
			throw new ValidationException("Invalid command");
			
	}

	private void checkForCheckInCommand(List<String> inputs) throws ValidationException {
		
		if(inputs.size()!=3)
			throw new ValidationException("Please enter valid number of inputs with CHECK_IN command");
		
		String type=inputs.get(1);
		if(!type.equals("ADULT") && !type.equals("SENIOR_CITIZEN") && !type.equals("KID"))
			throw new ValidationException("Enter type of passanger as ADULT or SENIOR_CITIZEN or KID");
		
		String station = inputs.get(2);
		if(!station.equals("AIRPORT") && !station.equals("CENTRAL"))
			throw new ValidationException("Metro card facility available only for AIRPORT and CENTRAL stations");
	}

	private void checkForBalanceCommand(List<String> inputs) throws ValidationException {
		
		if(inputs.size()!=2)
			throw new ValidationException("Please enter valid number of inputs with BALANCE command");
		
		int balance = Integer.parseInt(inputs.get(1));
		if(balance<0)
			throw new ValidationException("Metro card balance can not be negative");
	}

	

	
}
