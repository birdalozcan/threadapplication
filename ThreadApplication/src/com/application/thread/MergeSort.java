package com.application.thread;

import java.util.ArrayList;

public class MergeSort extends Algorithm {
	
	private static MergeSort singletonMergeObject;	//Singleton Patern kullanýldý.
	private static ArrayList<Integer> inputArray = new ArrayList<Integer>();
	
	private MergeSort(ArrayList<Integer> inputArray) {
		MergeSort.inputArray = inputArray;
		MergeSort.sortGivenArray();
	}
	
	public static synchronized MergeSort getSingletonMergeObject(ArrayList<Integer> inputArray) {
    	if (singletonMergeObject == null) {
    		singletonMergeObject = new MergeSort(inputArray);
		}
		return singletonMergeObject;
    }
	
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("Singleton, cannot be clonned");
	}

	private static void sortGivenArray() {
		divide(0, inputArray.size() - 1);
	}

	private static void divide(int startIndex, int endIndex) {
		if (startIndex < endIndex && (endIndex - startIndex) >= 1) {
			int mid = (endIndex + startIndex) / 2;
			divide(startIndex, mid);
			divide(mid + 1, endIndex);
			merger(startIndex, mid, endIndex);
		}
	}

	private static void merger(int startIndex, int midIndex, int endIndex) {
		ArrayList<Integer> mergedSortedArray = new ArrayList<Integer>();

		int leftIndex = startIndex;
		int rightIndex = midIndex + 1;

		while (leftIndex <= midIndex && rightIndex <= endIndex) {
			if (inputArray.get(leftIndex) <= inputArray.get(rightIndex)) {
				mergedSortedArray.add(inputArray.get(leftIndex));
				leftIndex++;
			} else {
				mergedSortedArray.add(inputArray.get(rightIndex));
				rightIndex++;
			}
		}

		while (leftIndex <= midIndex) {
			mergedSortedArray.add(inputArray.get(leftIndex));
			leftIndex++;
		}

		while (rightIndex <= endIndex) {
			mergedSortedArray.add(inputArray.get(rightIndex));
			rightIndex++;
		}

		int i = 0;
		int j = startIndex;
		while (i < mergedSortedArray.size()) {
			inputArray.set(j, mergedSortedArray.get(i++));
			j++;
		}
	}
}