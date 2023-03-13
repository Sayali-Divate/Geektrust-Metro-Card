package com.example.geektrust;

import java.io.IOException;
import java.util.List;

import com.example.geektrust.exception.PassangerNotFoundException;
import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CommandAndInputs;
import com.example.geektrust.service.TravelService;
import com.example.geektrust.service.TravelServiceImpl;
import com.example.geektrust.utility.CommandProcessingUtility;

public class Main {
    public static void main(String[] args) throws PassangerNotFoundException, ValidationException {        

        try {       	
        	
        	if(args[0]==null) throw new IOException("Please provide input");
        	
//        	for(String str : args) System.out.println(str);
        	
        	String[] commandLine = args;
        	processCommandLineArgument(commandLine);
            
        } catch (IOException | ValidationException  | PassangerNotFoundException e) {
        	
        	System.out.println(e.getMessage());
        }
        
    }
    
    public static void processCommandLineArgument(String[] commandLine) throws ValidationException, PassangerNotFoundException {
    	
    	CommandProcessingUtility commandsToBeProcessed = new CommandProcessingUtility(commandLine); 
    	List<CommandAndInputs> command = commandsToBeProcessed.getCommandAndInputsFromFile();
    	
//    	System.out.println(command);
    	TravelService service = new TravelServiceImpl();
    	service.executeCommand(command);
    	
    }
}
