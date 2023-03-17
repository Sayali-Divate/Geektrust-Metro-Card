package com.example.geektrust.model;

import java.util.List;

public class CommandAndTokens {

	private String command;
	private List<String> tokens;
	
	public CommandAndTokens(String command, List<String> tokens) {
		super();
		this.command = command;
		this.tokens = tokens;
	}	

	public String getCommand() {
		return command;
	}

	public List<String> getTokens() {
		return tokens;
	}

	@Override
	public String toString() {
		return "CommandAndTokens [command=" + command + ", tokens=" + tokens + "]";
	}
	
	
}
