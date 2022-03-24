package ui;

import java.util.Scanner;
import model.ModelMain;
public class Main {
	static Scanner sc;
	public static void main(String[]args) {
		ModelMain objP=new ModelMain();
		/*
		 * 
		 * sc=new Scanner(System.in);
		int numCountries=sc.nextInt();
		sc.nextLine();
		String [] countries=new String [numCountries];
		String[][] splite;
		for(int i=0;i<numCountries;i++) {
			countries[i]=sc.nextLine();
		}
		splite=new String[countries.length][];
		for(int i=0;i<numCountries;i++) {
			splite[i]=countries[i].split(";");
		}
		
		int goldM;
		int goldF;
		int silverM;
		int silverF;
		int bronzeM;
		int bronzeF;
		for(int i=0;i<numCountries;i++) {
			goldM=Integer.parseInt(splite[i][1]);
			silverM=Integer.parseInt(splite[i][2]);
			bronzeM=Integer.parseInt(splite[i][3]);
			goldF=Integer.parseInt(splite[i][4]);
			silverF=Integer.parseInt(splite[i][5]);
			bronzeF=Integer.parseInt(splite[i][6]);
			objP.add(splite[i][0], goldM, silverM, bronzeM, goldF, silverF, bronzeF);
		}
		*/
		objP.loadCountries();
		System.out.println(objP.compareMens());
		System.out.println(objP.compareWomens());
		System.out.println(objP.combined());
	} 
}
