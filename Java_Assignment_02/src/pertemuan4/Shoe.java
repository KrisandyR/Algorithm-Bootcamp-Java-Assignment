package pertemuan4;

import java.util.concurrent.ThreadLocalRandom;

public class Shoe {

	private String name;
	private String ID;
	private String category;
	private String releaseDate;
	private Integer price;
	
	//Encapsulation -> Hide Implementation

	public Shoe(String name, String category, String releaseDate, Integer price) {
		this.name = name;
		this.category = category;
		this.releaseDate = releaseDate;
		this.price = price;
		this.ID = generateID();
	}

	
	private String generateID() {
		// TODO Auto-generated method stub
		
		String ID = "SH";
		for(int i = 0; i<3; i++) {
			// ThreadLocalRandom is on of the better options in randoming number
			// Random 0-9
			Integer randomNumber = ThreadLocalRandom.current().nextInt(0, 10);
			ID += randomNumber.toString();
		}
		
		return ID;
	}

	public String toString() {
		
		String result = "";
		result += this.name + "-" + this.ID + "\n";
		result += "===============================\n";
		result += "Category : " + this.category + "\n";
		result += "Release date: " + this.releaseDate + "\n";
		result += "Price: " + this.price + "\n";
		return result;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	


}
