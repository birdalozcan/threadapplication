package com.application.thread;

import java.util.ArrayList;

public class ConfigThread extends MyThread {
	
	public ConfigThread (String filename, ArrayList<Integer> numberArray) {
		setFilename(filename);
		setNumberarray(numberArray);
	}
}
