package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ModelMain{
	
	private ArrayList<Country> countries;
	
	public ModelMain() {
		countries=new  ArrayList<>();
	}

	public ArrayList<Country> getCountries() {
		return countries;
	}
	
	public void add(String name,int goldM,int silverM,int bronzeM,int goldF,int silverF,int bronzeF) {
		Country newcountry=new Country(name, goldM, silverM, bronzeM, goldF, silverF, bronzeF);
		countries.add(newcountry);
	}


	
	public String compareMens() {
		String out="Hombres \n";
		Collections.sort(countries,new Comparator<Country>() {

			@Override
			public int compare(Country o1, Country o2) {
				
				return compareMedals(o1.getMens(),o2.getMens());
			}
			});
		for(int i=0;i<countries.size();i++) {
			out+=countries.get(i).getName()+" "+countries.get(i).getGoldM()+" "+countries.get(i).getSilverM()+" "
					+ countries.get(i).getBronzeM()+"\n";
		}
		out+="----------";
		return out;
	}
	
	public String compareWomens() {
		String out="Femenino \n";
		Collections.sort(countries,new Comparator<Country>() {

			@Override
			public int compare(Country o1, Country o2) {
				int out=compareMedals(o1.getWomens(),o2.getWomens())*-1;
				return out;
			}
			});
		
		for(int i=0;i<countries.size();i++) {
			out+=countries.get(i).getName()+" "+countries.get(i).getGoldF()+" "+countries.get(i).getSilverF()+" "
					+ countries.get(i).getBronzeF()+"\n";
		}
		out+="----------";
		return out;
		
	}

	
	public int compareMedals(Medal[] o1, Medal[] o2) {
		int goldO2=0;
		int silverO2=0;
		int bronzeO2=0;
		int goldO1=0;
		int silverO1=0;
		int bronzeO1=0;
		for(int i=0;i<o1.length;i++) {
			switch(o1[i].getType()){
			case GOLD:
				goldO1++;
				break;
			case SILVER:
				silverO1++;
				break;
			case BRONZE:
				bronzeO1++;
				break;
			
			}
		}
		for(int i=0;i<o2.length;i++) {
			switch(o2[i].getType()){
			case GOLD:
				goldO2++;
				break;
			case SILVER:
				silverO2++;
				break;
			case BRONZE:
				bronzeO2++;
				break;
			}
		}
		if(goldO1<goldO2||goldO2<goldO1) {
			return goldO2-goldO1;
		}else if(silverO2<silverO1||silverO1<silverO2) {
			return silverO2-silverO1;
		}else if(bronzeO2<bronzeO1||bronzeO2<bronzeO1) {
			return bronzeO2-bronzeO1;
		}
		return 0;
	}
	
	public String combined() {
		String out="Combinado \n";
		Collections.sort(countries);
		
		for(int i=0;i<countries.size();i++) {
			out+=countries.get(i).getName()+" "+(countries.get(i).getGoldF()+countries.get(i).getGoldM())+
					" "+(countries.get(i).getSilverF()+countries.get(i).getSilverM())+" "
					+ (countries.get(i).getBronzeF()+countries.get(i).getBronzeM())+"\n";
		}
		return out;
	}
	public void loadCountries(){
		try {
			File file = new File("Countries.txt");
			
			FileReader fr = new FileReader(file);
			
			BufferedReader input = new BufferedReader(fr);
			 input.readLine();
			while (input.ready()) {
				
				String[] splite = input.readLine().split(";");
				Country toAdd=new Country(splite[0],Integer.parseInt(splite[1]),
						Integer.parseInt(splite[2]),Integer.parseInt(splite[3]),
						Integer.parseInt(splite[4]),Integer.parseInt(splite[5]),
						Integer.parseInt(splite[6]));
				countries.add(toAdd);
			}
			
			input.close();
			fr.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
