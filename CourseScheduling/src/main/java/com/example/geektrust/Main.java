package com.example.geektrust;

import java.io.IOException;
import java.util.List;

import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CommandAndTokens;
import com.example.geektrust.service.LearningManagementSystem;
import com.example.geektrust.utility.CommandTokenProcessingUtility;

public class Main {
    public static void main(String[] args) {
       
        try {
        	
        	if(args.length==0) throw new IOException("Please provide input");	         	
        	processCommandLineInput(args[0]);        	
        	
        } catch (IOException | ValidationException e) {        	
        	System.out.println(e.getMessage());
        }
        
    }

	public static void processCommandLineInput(String file) throws ValidationException, IOException {
		
		CommandTokenProcessingUtility fileToBeProcessed = new CommandTokenProcessingUtility(file);
		List<CommandAndTokens> listOfCommands = fileToBeProcessed.getListOfCommandAndTokens();
		
		LearningManagementSystem leanringManagement = new LearningManagementSystem();
		
//		System.out.println(listOfCommands);
		
	}

	
}
