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
		
		ConfigThread temp = new ConfigThread(null, null); // MyThread s�n�f�ndan 1 defaya mahsus nesne t�retildi. Prototype Patern kullan�ld�.
		
		for (int i = 1; i <= 10; i++) {
			ConfigThread cthread = (ConfigThread) temp.clone(); // new operat�r� ile nesne t�retmenin �n�ne ge�ildi ve d�ng�yle i'nin her de�erinde klonlanan nesne set metotlar�yla yeniden yap�land�r�ld�.
			cthread.setFilename(filenames[i-1]);
			cthread.setNumberarray(functions.createArray());
			
			Thread thread = new Thread(cthread); // Prototype Patern ile d�ng� kullanarak klonlanan nesne i'nin her de�erinde yeniden 
			thread.start();						 // yap�land�r�l�p Thread olu�turuluyor.
		}
		
		Scanner input = new Scanner(System.in);
		System.out.println("S�ralama Algoritmas� Se�iniz"+"\n" + "Insertion Sort --> 1" + "\n" + "Merge Sort     --> 2" + "\n" + "Selection Sort --> 3");
		int inputkey = input.nextInt();
		
		mergearray = functions.XmlParser(mergearray);
		
		Algorithm incomingvalue = SelectAlgorithmFactory.getAlgorithm(inputkey, mergearray); //Factory Pattern kullan�ld�.
		
		if (incomingvalue == null) {
			System.out.println("L�tfen algoritma se�iminde 1,2,3 de�erlerinden birini giriniz");
		} else {
			Functions.XmlBuilder(mergearray, "sorted.xml");
			System.out.println("Array Size :" + mergearray.size());
			for (int k = 0; k < mergearray.size(); k++) {
				System.out.print(mergearray.get(k)+" - ");
			}
		}
	}
}