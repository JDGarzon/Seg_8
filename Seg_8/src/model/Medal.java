package model;

public class Medal {
	private Type type;
	private Gender gender;
	public Medal(Type type,Gender gender) {
		this.type=type;
		this.gender=gender;
	}
	public Type getType() {
		return type;
	}
	public Gender getGender() {
		return gender;
	}
	public String toString() {
		String out="";	
		if(gender.equals(Gender.MALE)) {
			out ="Male";
		}else out="Female";
		return out;
	}
}
