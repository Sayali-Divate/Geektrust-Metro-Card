package com.example.geektrust.utilityTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.geektrust.model.CommandAndInputs;
import com.example.geektrust.utility.CommandProcessingUtility;

public class UtilityTest {

	private CommandProcessingUtility utility;
	
	@BeforeEach
	public void initializeUtility() {
		this.utility = new CommandProcessingUtility();
	}
	
	@Test
	public void commandAndInputsTest() {
		
		CommandAndInputs cmdIp =  utility.parseToCommandAndInput("BALANCE MC1 100");
		
		List<String> inputList = new ArrayList<>();
		inputList.add("MC1");
		inputList.add("100");
		
//		System.out.println(cmdIp);
		
		CommandAndInputs expected = new CommandAndInputs("BALANCE", inputList);
		
//		System.out.println(expected);
		
		assertTrue(expected.equals(cmdIp));
	}
}
