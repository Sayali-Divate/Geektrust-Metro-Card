package com.example.geektrust.utility;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CommandAndTokens;

public class CommandTokenProcessingUtility {

	private final String file;

	public CommandTokenProcessingUtility(String file) {
		super();
		this.file = file;
	}
	
	public List<CommandAndTokens> getListOfCommandAndTokens() throws ValidationException, IOException{
		
		BufferedReader reader = null;
		
		try{
			FileInputStream fileStream = new FileInputStream(this.file);
			reader = new BufferedReader(new InputStreamReader(fileStream));
			
			return reader.lines().filter(line -> !isBlankOrComment(line))
					.map(line -> parseToCommandInputObject(line))
					.collect(Collectors.toList());
			
		} catch (Exception e) {
			throw new ValidationException("Some error occured while processing file");	
			
		} finally {
			reader.close();
		}
	}

	public CommandAndTokens parseToCommandInputObject(String line) {
		
		String[] commandTokenArray = line.trim().split(" ");
		
		List<String> litsOfTokens = Arrays.stream(commandTokenArray).skip(1).collect(Collectors.toList());
		
		CommandAndTokens commandTokenObject = new CommandAndTokens(commandTokenArray[0], litsOfTokens);
		return commandTokenObject;
		
	}

	private boolean isBlankOrComment(String line) {
		return line.trim().isEmpty() || line.trim().startsWith("#");
	}
	
	
}
