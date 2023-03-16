package com.example.geektrust.model;

import java.util.List;
import java.util.Objects;

public class CommandAndInputs {

	private String command;
	private List<String> inputs;	
	
	public CommandAndInputs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CommandAndInputs(String command, List<String> inputsWithoutCommand) {
		
		this.command = command;
		this.inputs = inputsWithoutCommand;
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public List<String> getInputs() {
		return inputs;
	}
	public void setInputs(List<String> inputs) {
		this.inputs = inputs;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(command, inputs);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommandAndInputs other = (CommandAndInputs) obj;
		return Objects.equals(command, other.command) && Objects.equals(inputs, other.inputs);
	}
	
	@Override
	public String toString() {
		return "CommandAndInputs [command=" + command + ", inputs=" + inputs + "]";
	}
	
	
}
