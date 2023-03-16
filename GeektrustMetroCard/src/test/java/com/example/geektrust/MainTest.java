package com.example.geektrust;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.example.geektrust.exception.PassangerNotFoundException;
import com.example.geektrust.exception.ValidationException;

public class MainTest {	
	
	@Test
	public void input1Test() throws ValidationException, PassangerNotFoundException {
		
		String inputfile = "src/test/java/resources/input1.txt" ;
		String actualOutput = Main.processCommandLineArgument(inputfile);
		
		String expectedOutput = "TOTAL_COLLECTION CENTRAL 300 0\n"
				+ "PASSENGER_TYPE_SUMMARY\n"
				+ "ADULT 1\n"
				+ "SENIOR_CITIZEN 1\n"
				+ "TOTAL_COLLECTION AIRPORT 403 100\n"
				+ "PASSENGER_TYPE_SUMMARY\n"
				+ "ADULT 2\n"
				+ "KID 2";
		
		assertEquals(expectedOutput, actualOutput.trim());
	}
	
	@Test
	public void input2Test() throws ValidationException, PassangerNotFoundException {
		
		String inputfile = "src/test/java/resources/input2.txt" ;
		String actualOutput = Main.processCommandLineArgument(inputfile);
		
		String expectedOutput = "TOTAL_COLLECTION CENTRAL 504 0\n"
				+ "PASSENGER_TYPE_SUMMARY\n"
				+ "ADULT 2\n"
				+ "KID 2\n"
				+ "TOTAL_COLLECTION AIRPORT 151 100\n"
				+ "PASSENGER_TYPE_SUMMARY\n"
				+ "ADULT 1\n"
				+ "KID 1";
		
		assertEquals(expectedOutput, actualOutput.trim());
	}
	
	@Test
	public void input3Test() throws ValidationException, PassangerNotFoundException {
		
		String inputfile = "src/test/java/resources/input3.txt" ;
		String actualOutput = Main.processCommandLineArgument(inputfile);
		
		String expectedOutput = "TOTAL_COLLECTION CENTRAL 300 50\n"
				+ "PASSENGER_TYPE_SUMMARY\n"
				+ "ADULT 1\n"
				+ "KID 1\n"
				+ "SENIOR_CITIZEN 1\n"
				+ "TOTAL_COLLECTION AIRPORT 225 125\n"
				+ "PASSENGER_TYPE_SUMMARY\n"
				+ "ADULT 1\n"
				+ "KID 1\n"
				+ "SENIOR_CITIZEN 1";
		
		assertEquals(expectedOutput, actualOutput.trim());
	}
	
	@Test
	public void input4Test() throws ValidationException, PassangerNotFoundException {
		
		String inputfile = "src/test/java/resources/input4.txt" ;
		String actualOutput = Main.processCommandLineArgument(inputfile);
		
		String expectedOutput = "TOTAL_COLLECTION CENTRAL 457 50\n"
				+ "PASSENGER_TYPE_SUMMARY\n"
				+ "ADULT 2\n"
				+ "SENIOR_CITIZEN 1\n"
				+ "TOTAL_COLLECTION AIRPORT 252 100\n"
				+ "PASSENGER_TYPE_SUMMARY\n"
				+ "ADULT 1\n"
				+ "KID 1\n"
				+ "SENIOR_CITIZEN 1";
		
		assertEquals(expectedOutput, actualOutput.trim());
	}
	
}