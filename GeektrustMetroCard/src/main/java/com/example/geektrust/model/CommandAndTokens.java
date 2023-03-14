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
	public void setCommand(String command) {
		this.command = command;
	}
	public List<String> getTokens() {
		return tokens;
	}
	public void setTokens(List<String> tokens) {
		this.tokens = tokens;
	}
	
	
}
