package com.application.thread;

import java.util.ArrayList;

public class SelectionSort extends Algorithm {
	
	private static SelectionSort singletonSelectionObject;	//Singleton Patern kullanýldý.
	private static ArrayList<Integer> inputArray = new ArrayList<Integer>();
	
	private SelectionSort(ArrayList<Integer> inputArray) {
		SelectionSort.inputArray = inputArray;
		SelectionSort.sortGivenArray();
	}
	
	public static synchronized SelectionSort getSingletonSelectionObject(ArrayList<Integer> inputArray) {
    	if (singletonSelectionObject == null) {
    		singletonSelectionObject = new SelectionSort(inputArray);
		}
		return singletonSelectionObject;
    }
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Singleton, cannot be clonned");
	}

	private static void sortGivenArray() {
		int smallInt = 0;
		int j = 0;
		int smallIntIndex = 0;
		for (int i = 1; i < inputArray.size(); i++) {
			smallInt = inputArray.get(i - 1);
			smallIntIndex = i - 1;
			for (j = i; j < inputArray.size(); j++) {
				if (inputArray.get(j) < smallInt) {
					smallInt = inputArray.get(j);
					smallIntIndex = j;
				}
			}
			swap(i - 1, smallIntIndex);
		}
	}

	private static void swap(int sourceIndex, int destIndex) {
		int temp = inputArray.get(destIndex);
		inputArray.set(destIndex, inputArray.get(sourceIndex));
		inputArray.set(sourceIndex, temp);
	}

}