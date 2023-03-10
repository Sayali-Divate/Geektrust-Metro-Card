package com.example.geektrust.service;

import java.util.List;

import com.example.geektrust.exception.ValidationExecption;
import com.example.geektrust.model.CommandAndInputs;

public class CheckingInputsImpl implements CheckingInputs {

	@Override
	public void checkInputBeforeExecution(CommandAndInputs commandWithTokens) throws ValidationExecption {
		
		String command = commandWithTokens.getCommand();
		List<String> inputs = commandWithTokens.getInputs();
		
		if(command.equals("BALANCE")) {			
			checkForBalanceCommand(inputs);
		}		
	}

	public void checkForBalanceCommand(List<String> inputs) {
		// TODO Auto-generated method stub
		
	}

	

	
}
