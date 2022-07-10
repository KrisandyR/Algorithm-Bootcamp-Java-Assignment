
public class Participant {
	
	String name;
	int shareNumber;
	
	
	public Participant(String name, int shareNumber) {
		this.name = name;
		this.shareNumber = shareNumber;
	}
	
	public void changeShareNumber(int newShareNumber) {
		this.shareNumber = newShareNumber;
	}
	
	public int getNumber() {
		return this.shareNumber;
	}

}
