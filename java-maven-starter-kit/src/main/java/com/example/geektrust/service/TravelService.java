package com.example.geektrust.service;

import java.util.List;

import com.example.geektrust.exception.ValidationExecption;
import com.example.geektrust.model.CommandAndInputs;

public interface TravelService {

	void executeCommand(List<CommandAndInputs> command) throws ValidationExecption;

}
