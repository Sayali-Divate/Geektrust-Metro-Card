package com.example.geektrust.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.geektrust.exception.ValidationException;
import com.example.geektrust.model.CommandAndInputs;

public class CommandProcessingUtility {

	private String file;	

	public CommandProcessingUtility() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CommandProcessingUtility(String file) {
		super();
		this.file = file;
	}
	
	public List<CommandAndInputs> getCommandAndInputsFromFile() throws ValidationException{
		
		try (Stream<String> lines = Files.lines(Paths.get(this.file))) {
			return lines.filter(line -> !isBlankOrComment(line)).map(line -> parseToCommandAndInput(line))
					.collect(Collectors.toList());
		} catch (IOException e) {
			throw new ValidationException("Some error occurred while processing input file");
		}
		
	}
	
	private boolean isBlankOrComment(String line) {
		return line.trim().isEmpty() || line.trim().startsWith("#");
	}
	
	public CommandAndInputs parseToCommandAndInput(String str) {		
		try {
			String[] commandWithArguments = str.split(" ");
			List<String> tokens = Arrays.stream(commandWithArguments).skip(1).collect(Collectors.toList());
			CommandAndInputs input = new CommandAndInputs(commandWithArguments[0], tokens);
			return input;
		} catch (Exception e) {
			throw new UnsupportedOperationException("Invalid Command Supplied: " + str);
		}
		
		
	}
}
