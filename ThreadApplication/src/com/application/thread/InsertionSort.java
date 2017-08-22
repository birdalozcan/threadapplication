package com.application.thread;

import java.util.ArrayList;

public class InsertionSort extends Algorithm {
	
	private static InsertionSort singletonInsertionObject;	//Singleton Patern kullanýldý.
	private static ArrayList<Integer> inputArray = new ArrayList<Integer>();
	
	private InsertionSort(ArrayList<Integer> inputArray) {
		InsertionSort.inputArray = inputArray;
		InsertionSort.sortGivenArray();
	}
	
	public static synchronized InsertionSort getSingletonInsertionObject(ArrayList<Integer> inputArray) {
    	if (singletonInsertionObject == null) {
    		singletonInsertionObject = new InsertionSort(inputArray);
		}
		return singletonInsertionObject;
    }
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Singleton, cannot be clonned");
	}

	private static void sortGivenArray() {
		for (int i = 1; i < inputArray.size(); i++) {
			int key = inputArray.get(i);
			for (int j = i - 1; j >= 0; j--) {
				if (key < inputArray.get(j)) {
					inputArray.set(j + 1, inputArray.get(j));
					if (j == 0) {
						inputArray.set(0, key);
					}
				} else {
					inputArray.set(j + 1, key);
					break;
				}
			}
		}
	}
}