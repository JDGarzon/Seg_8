package model;

public class Country implements Comparable<Country>{
	private Medal[] mens;
	private Medal[] womens;
	private String name;
	private int goldM, silverM, bronzeM, goldF, silverF, bronzeF;
	
	public Country(String name,int goldM,int silverM,int bronzeM,int goldF,int silverF,int bronzeF) {
		this.goldM=goldM;
		this.goldF=goldF;
		this.silverF=silverF;
		this.silverM=silverM;
		this.bronzeF=bronzeF;
		this.bronzeM=bronzeM;
		this.name=name;
		mens=new Medal[goldM+silverM+bronzeM];
		createMedals(mens,2,goldM,silverM,bronzeM);
		womens=new Medal[goldF+silverF+bronzeF];
		createMedals(womens,1,goldF,silverF,bronzeF);
	}
	public Medal[] getMens() {
		return mens;
	}
	public Medal[] getWomens() {
		return womens;
	}
	public String getName() {
		return name;
	}
	public void createMedals(Medal[] arr,int indexGender,int gold,int silver,int bronze) {
		int i;
		Gender gender=null;
		Type type=null;
		switch(indexGender) {
		case 1:
			gender=Gender.FEMALE;
			break;
		case 2:
			gender=Gender.MALE;
			break;
		}
		silver+=gold;
		bronze+=silver;
		for(i=0;i<arr.length;i++) {
			if(i<gold) {
				type=Type.GOLD;
			}else if(i<silver) {
				type=Type.SILVER;
			}else if(i<bronze) {
				type=Type.BRONZE;
			}
			arr[i]=new Medal(type,gender);
		}
	}
	@Override
	public int compareTo(Country o) {
		int goldM=0;
		int goldF=0;
		int silverM=0;
		int silverF=0;
		int bronzeM=0;
		int bronzeF=0;
		int goldMO=0;
		int goldFO=0;
		int silverMO=0;
		int silverFO=0;
		int bronzeMO=0;
		int bronzeFO=0;
		for(int i=0;i<o.mens.length;i++) {
			switch(o.mens[i].getType()){
			case GOLD:
				goldMO++;
				break;
			case SILVER:
				silverMO++;
				break;
			case BRONZE:
				bronzeMO++;
				break;
			
			}
		}
		for(int i=0;i<mens.length;i++) {
			switch(mens[i].getType()){
			case GOLD:
				goldM++;
				break;
			case SILVER:
				silverM++;
				break;
			case BRONZE:
				bronzeM++;
				break;
			
			}
		}
		for(int i=0;i<o.womens.length;i++) {
			switch(o.womens[i].getType()){
			case GOLD:
				goldFO++;
				break;
			case SILVER:
				silverFO++;
				break;
			case BRONZE:
				bronzeFO++;
				break;
			
			}
		}
		for(int i=0;i<womens.length;i++) {
			switch(womens[i].getType()){
			case GOLD:
				goldF++;
				break;
			case SILVER:
				silverF++;
				break;
			case BRONZE:
				bronzeF++;
				break;
			
			}
		}
		int gold=goldF+goldM;
		int silver=silverM+silverF;
		int bronze=bronzeM+bronzeF;
		int goldO=goldFO+goldMO;
		int silverO=silverMO+silverFO;
		int bronzeO=bronzeMO+bronzeFO;
		if(gold<goldO||goldO<gold) {
			return goldO-gold;
		}else if(silver<silverO||silverO<silver) {
			return silverO-silver;
		}else if(bronze<bronzeO||bronzeO<bronze) {
			return bronzeO-bronze;
		}
		return 0;
	}
	public int getBronzeF() {
		return bronzeF;
	}
	public int getSilverF() {
		return silverF;
	}
	public int getGoldF() {
		return goldF;
	}
	public int getBronzeM() {
		return bronzeM;
	}
	public int getSilverM() {
		return silverM;
	}
	public int getGoldM() {
		return goldM;
	}

}
