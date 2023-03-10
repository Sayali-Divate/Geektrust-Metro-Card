package com.example.geektrust;

import java.io.IOException;
import java.util.List;

import com.example.geektrust.exception.ValidationExecption;
import com.example.geektrust.model.CommandAndInputs;
import com.example.geektrust.service.TravelService;
import com.example.geektrust.service.TravelServiceImpl;
import com.example.geektrust.utility.CommandProcessingUtility;

public class Main {
    public static void main(String[] args) {        

        try {       	
        	
        	if(args[0]==null) throw new IOException("Please provide input");
        	
        	String commandLine = args[0];
        	processCommandLineArgument(commandLine);
            
        } catch (IOException | ValidationExecption e ) {
        	
        	System.out.println(e.getMessage());
        }
        
    }
    
    public static void processCommandLineArgument(String commandLine) throws ValidationExecption {
    	
    	CommandProcessingUtility commandsToBeProcessed = new CommandProcessingUtility(commandLine); 
    	List<CommandAndInputs> command = commandsToBeProcessed.getCommandAndInputsFromFile();
    	TravelService service = new TravelServiceImpl();
    	service.executeCommand(command);
    	
    }
}
