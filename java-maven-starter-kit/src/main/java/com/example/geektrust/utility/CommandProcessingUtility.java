package com.example.geektrust.utility;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.geektrust.model.CommandAndInputs;

public class CommandProcessingUtility {

	private String file;

	public CommandProcessingUtility(String file) {
		super();
		this.file = file;
	}
	
	public List<CommandAndInputs> getCommandAndInputsFromFile(){
		
		return Stream.of(file.split("\n"))
				.filter(line-> !line.isBlank())
				.map(line -> parseToCommandAndInput(line))
				.collect(Collectors.toList());		
	}
	
	public CommandAndInputs parseToCommandAndInput(String str) {
		
		String[] commandLine = str.split(" ");
		List<String> inputs = Stream.of(commandLine).skip(1).collect(Collectors.toList());
		CommandAndInputs inputsWithCommand = new CommandAndInputs(commandLine[0], inputs);
		return inputsWithCommand;
	}
}
