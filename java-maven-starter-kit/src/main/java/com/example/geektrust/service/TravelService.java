package com.example.geektrust.service;

import java.util.List;

import com.example.geektrust.exception.PassangerNotFoundException;
import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CommandAndInputs;

public interface TravelService {

	String executeCommand(List<CommandAndInputs> command) throws ValidationException, PassangerNotFoundException;

}
