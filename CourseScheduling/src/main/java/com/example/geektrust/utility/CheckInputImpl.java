package com.example.geektrust.utility;

import java.util.List;

import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CommandAndTokens;

public class CheckInputImpl implements CheckInput {

	@Override
	public void checkInputBeforeExecution(CommandAndTokens commandTokens) throws ValidationException {
		
		String commandToCheck = commandTokens.getCommand();
		List<String> listOfTokens = commandTokens.getTokens(); 
		
		CheckTokenValidation validateTokens = new CheckTokenValidation(listOfTokens);
		
		switch(commandToCheck) {
		
		case "ADD-COURSE-OFFERING" :
			validateTokens.checkAddCourseCommand(listOfTokens);
			break;			
		case "REGISTER" :
			validateTokens.checkRegisterCommand(listOfTokens);
			break;
		case "ALLOT" :
			validateTokens.checkAllotOrCancelCommand(listOfTokens);
			break;
		case "CANCEL" :
			validateTokens.checkAllotOrCancelCommand(listOfTokens);
			break;
		default : throw new ValidationException("INPUT_DATA_ERROR");
		}
	}	

}
