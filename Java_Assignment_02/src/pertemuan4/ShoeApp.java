package pertemuan4;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class ShoeApp {
	
	Scanner scan = new Scanner(System.in);
	ArrayList<Shoe> shoes = new ArrayList<>();
	Validation validate = new Validation();
	
	private void clearScr() {
		for(int i = 0; i<5; i++) {
			System.out.println("");
		}
	}
	
	private void printMenu() {
		clearScr();
		System.out.println("Shoe Shop");
		System.out.println("===========");
		System.out.println("1. View Shoes");
		System.out.println("2. Add Shoe");
		System.out.println("3. Delete Shoe");
		System.out.println("4. Exit");
	}
	
	public ShoeApp(boolean onApp) {
		
		while(onApp) {
			
			printMenu();
			int choice = -1;
			boolean isValidChoice = true;
			
			do {
				System.out.print(">> ");
				choice = scan.nextInt(); scan.nextLine();
				if(choice < 1 || choice > 4) {
					isValidChoice = false;
				}
			} while(!isValidChoice);
			
			switch (choice) {
			case 1:
				viewShoes();
				break;
			case 2:
				addShoe();
				break;
			case 3:
				deleteShoe();
				break;
			case 4:
				System.out.println("Thanks for using this App");
				onApp = false;
				break;
			}
			
		}
		
	}

	private void addShoe() {
		
		String name, category, releaseDate;
		Integer price;
		
		do {
			System.out.print("Input name [name ends with shoe, example 'Air Jordan shoe'] : ");
			name = scan.nextLine();
		} while (!validate.shoeName(name));
		
		do {
			System.out.print("Input category [Sneaker | Running | Boot] (case sensitive) : ");
			category = scan.nextLine();
		} while (!validate.shoeCategory(category));
		
		do {
			
			System.out.print("Input release date [dd-mm-yyyy] : ");
			releaseDate = scan.nextLine();
		} while (!validate.shoeReleaseDate(releaseDate));
		
		do {
			System.out.print("Input price [more than or equals to 5000] : ");
			price = scan.nextInt(); scan.nextLine();
		} while(!validate.shoePrice(price));
		
		shoes.add(new Shoe(name, category, releaseDate, price));
		
	}

	private void viewShoes() {
		
		if(shoes.isEmpty()) {
			System.out.println("No shoes available");
			System.out.println("\nPress enter to continue...");
			scan.nextLine();
			return;
		}
		
		System.out.println("");
		
		for(int i = 1; i<=shoes.size(); i++) {
			System.out.println(i + ". " + shoes.get(i-1).toString());
		}
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	private void deleteShoe() {
		
		if(shoes.isEmpty()) {
			System.out.println("No shoes available");
			System.out.println("\nPress enter to continue...");
			scan.nextLine();
			return;
		}
		
		System.out.println("");
		
		for(int i = 1; i<=shoes.size(); i++) {
			System.out.println(i + ". " + shoes.get(i-1).toString());
		}
		
		int size = shoes.size();
		int index;
		
		do {
			System.out.println("Choose shoe index to delete[1..2] : ");
			index = scan.nextInt(); scan.nextLine();
		} while (!validate.indexToDelete(index, size));
		
		shoes.remove(index-1);
		System.out.println("Shoes removed!");
		
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}

	public static void main(String[] args) {
		new ShoeApp(true);
	}

}
