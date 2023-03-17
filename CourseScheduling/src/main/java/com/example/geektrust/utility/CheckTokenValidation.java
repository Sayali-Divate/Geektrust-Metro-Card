package com.example.geektrust.utility;

import java.util.List;

import com.example.geektrust.exception.ValidationException;

public class CheckTokenValidation {

	private List<String> tokens;

	public CheckTokenValidation(List<String> tokens) {
		super();
		this.tokens = tokens;
	}

	public void checkAddCourseCommand(List<String> listOfTokens) throws ValidationException {
		
		if(listOfTokens.size()!=5 || listOfTokens.get(2).length()!=8) 
			throw new ValidationException("INPUT_DATA_ERROR");		
		try {
			int minReg = Integer.parseInt(listOfTokens.get(3));
			int maxReg = Integer.parseInt(listOfTokens.get(4));
			if(minReg<1 || maxReg<1) throw new ValidationException("INPUT_DATA_ERROR");			
		}
		catch(Exception e) {
			throw new ValidationException("INPUT_DATA_ERROR");
		}		
	}

	public void checkRegisterCommand(List<String> listOfTokens) throws ValidationException {		
		if(listOfTokens.size()!=2) throw new ValidationException("INPUT_DATA_ERROR");
		
	}

	public void checkAllotOrCancelCommand(List<String> listOfTokens) throws ValidationException {		
		if(listOfTokens.size()!=1) throw new ValidationException("INPUT_DATA_ERROR");
	}
	
	
}
