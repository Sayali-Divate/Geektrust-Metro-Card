package com.example.geektrust.service;

import java.util.List;

import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CommandAndInputs;

public interface CheckingInputs {

	void checkInputBeforeExecution(CommandAndInputs inputs) throws ValidationException;

	

}
