package com.example.geektrust.utility;

import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CommandAndTokens;

public interface CheckInput {

	
	void checkInputBeforeExecution(CommandAndTokens commandTokens) throws ValidationException;

}
