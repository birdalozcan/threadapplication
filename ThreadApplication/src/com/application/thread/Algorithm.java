package com.application.thread;

import java.util.ArrayList;

public class Algorithm {

	public static InsertionSort insertionSort(ArrayList<Integer> inputArray) {
		InsertionSort insort = InsertionSort.getSingletonInsertionObject(inputArray);
		return insort;
	}

	public static MergeSort mergeSort(ArrayList<Integer> inputArray) {
		MergeSort msort = MergeSort.getSingletonMergeObject(inputArray);
		return msort;
	}

	public static SelectionSort selectionSort(ArrayList<Integer> inputArray) {
		SelectionSort ssort = SelectionSort.getSingletonSelectionObject(inputArray);
		return ssort;
	}
}
