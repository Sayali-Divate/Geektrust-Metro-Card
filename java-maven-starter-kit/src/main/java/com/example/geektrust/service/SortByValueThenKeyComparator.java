package com.example.geektrust.service;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

import com.example.geektrust.model.CheckInDetails;

public class SortByValueThenKeyComparator implements Comparator<Map.Entry<String, Set<CheckInDetails>>> {

	@Override
	public int compare(Map.Entry<String, Set<CheckInDetails>> type1, Map.Entry<String, Set<CheckInDetails>> type2) {
		
		if(type1.getValue()==type2.getValue()) return type1.getKey().compareTo(type2.getKey());
		else return type2.getValue().size()-type1.getValue().size();
	}

}
