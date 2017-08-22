package com.application.thread;

import java.util.ArrayList;

public class SelectAlgorithmFactory {
	
	public static Algorithm getAlgorithm(int value, ArrayList<Integer> inputArray) {
	    if (value == 1)
	      return Algorithm.insertionSort(inputArray);
	    else if (value == 2)
	      return Algorithm.mergeSort(inputArray);
	    else if (value == 3)
	      return Algorithm.selectionSort(inputArray);
	    
	    return null;
	  }
}
