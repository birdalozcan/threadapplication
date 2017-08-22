package com.application.thread;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @param args
 * @author birdal
 * @throws CloneNotSupportedException 
 */
public class Main{

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Functions functions = new Functions();
		ArrayList<Integer> mergearray = new ArrayList<Integer>();
		
		String filenames[] = {"dosya1.xml","dosya2.xml","dosya3.xml","dosya4.xml","dosya5.xml","dosya6.xml","dosya7.xml","dosya8.xml","dosya9.xml","dosya10.xml"};
		
		ConfigThread temp = new ConfigThread(null, null); // MyThread sýnýfýndan 1 defaya mahsus nesne türetildi. Prototype Patern kullanýldý.
		
		for (int i = 1; i <= 10; i++) {
			ConfigThread cthread = (ConfigThread) temp.clone(); // new operatörü ile nesne türetmenin önüne geçildi ve döngüyle i'nin her deðerinde klonlanan nesne set metotlarýyla yeniden yapýlandýrýldý.
			cthread.setFilename(filenames[i-1]);
			cthread.setNumberarray(functions.createArray());
			
			Thread thread = new Thread(cthread); // Prototype Patern ile döngü kullanarak klonlanan nesne i'nin her deðerinde yeniden 
			thread.start();						 // yapýlandýrýlýp Thread oluþturuluyor.
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("Sýralama Algoritmasý Seçiniz"+"\n" + "Insertion Sort --> 1" + "\n" + "Merge Sort     --> 2" + "\n" + "Selection Sort --> 3");
		int inputkey = input.nextInt();
		
		mergearray = functions.XmlParser(mergearray);
		
		Algorithm incomingvalue = SelectAlgorithmFactory.getAlgorithm(inputkey, mergearray); //Factory Pattern kullanýldý.
		
		if (incomingvalue == null) {
			System.out.println("Lütfen algoritma seçiminde 1,2,3 deðerlerinden birini giriniz");
		} else {
			Functions.XmlBuilder(mergearray, "sorted.xml");
			System.out.println("Array Size :" + mergearray.size());
			for (int k = 0; k < mergearray.size(); k++) {
				System.out.print(mergearray.get(k)+" - ");
			}
		}
	}
}