package com.example.geektrust;

import java.io.IOException;
import java.util.List;

import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CommandAndTokens;
import com.example.geektrust.utility.CommandLineProcessingUtility;

public class Main {
    public static void main(String[] args) {
        
    	try {
    		
    		if(args.length==0) throw new IOException("Please provide input");
    		
    		String commandLine = args[0];
    		processCommandLineArgument(commandLine);  
    		
			
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	private static void processCommandLineArgument(String commandLine) throws ValidationException {
		
		CommandLineProcessingUtility utility = new CommandLineProcessingUtility(commandLine);
		List<CommandAndTokens> listOfCommands = utility.getCommandsFromFile();		
		
		
	}
}
