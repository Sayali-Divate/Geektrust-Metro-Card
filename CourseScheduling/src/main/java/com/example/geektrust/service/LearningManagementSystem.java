package com.example.geektrust.service;

import java.util.List;

import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CommandAndTokens;
import com.example.geektrust.utility.CheckInput;
import com.example.geektrust.utility.CheckInputImpl;

public class LearningManagementSystem {

	
	public void executeCommands(List<CommandAndTokens> commandsAndTokens) throws ValidationException {
		
		for(CommandAndTokens commandTokens : commandsAndTokens) {
			
			CheckInput inputValidationCheck = new CheckInputImpl();
			inputValidationCheck.checkInputBeforeExecution(commandTokens);
		}
	}
}
