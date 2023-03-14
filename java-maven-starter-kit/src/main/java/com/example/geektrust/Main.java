package com.example.geektrust;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


import com.example.geektrust.exception.PassangerNotFoundException;
import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CommandAndInputs;
import com.example.geektrust.service.TravelService;
import com.example.geektrust.service.TravelServiceImpl;
import com.example.geektrust.utility.CommandProcessingUtility;

public class Main {
    public static void main(String[] args) throws PassangerNotFoundException, ValidationException, FileNotFoundException {        

        try {             	
         	
        	if(args.length==0) throw new IOException("Please provide input");  	
        	
        	String commandLine = args[0];
        	processCommandLineArgument(commandLine);   	
        	
        	
            
        } catch (IOException | ValidationException  | PassangerNotFoundException e) {
        	
        	System.out.println(e.getMessage());
        }      
       
        
    }
    
    public static String processCommandLineArgument(String commandLine) throws ValidationException, PassangerNotFoundException {
    	
    	CommandProcessingUtility commandsToBeProcessed = new CommandProcessingUtility(commandLine); 
    	List<CommandAndInputs> commandList = commandsToBeProcessed.getCommandAndInputsFromFile();    
    	
//    	System.out.println(command);

    	TravelService service = new TravelServiceImpl();
    	return service.executeCommand(commandList);
    	
    }
}
