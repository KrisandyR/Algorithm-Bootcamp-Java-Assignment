package pertemuan4;

import java.text.SimpleDateFormat;

public class Validation {

	public Validation() {
		// TODO Auto-generated constructor stub
	}
	
	boolean shoeName(String name) {
		return name.endsWith("shoe")?true:false;
	}
	
	boolean shoeCategory(String category) {
		return (category.contentEquals("Sneaker") || 
				category.contentEquals("Running") ||
				category.contentEquals("Boot")) ? true : false;
	}
	
	boolean shoeReleaseDate(String date) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
			sdf.setLenient(false); // Reject invalid dates
			sdf.parse(date); // IF fail, catch the ParseException
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	boolean shoePrice(Integer price) {
		return (price >= 5000) ? true : false;
	}
	
	boolean indexToDelete(Integer index, Integer size) {
		if(index < 1 || index > size) {
			return false;
		}
		return true;
	}

}
