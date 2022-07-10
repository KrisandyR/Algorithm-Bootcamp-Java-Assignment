import java.util.Scanner;

public class Main {
	
	Scanner s = new Scanner(System.in);
	
	public void printMenu() {
		System.out.println("\n\n\n\n\n");
		System.out.println("1. Start The Simulation");
		System.out.println("2. Close App");
		System.out.print("Choice >> ");
	}
	
	public Main() {
		// TODO Auto-generated constructor stub
		

		int choice = 0;
		do {
			printMenu();
			choice = s.nextInt();
			s.nextLine();
			if(choice == 1) {
				
				
				int first = getInt(1);
				int second = getInt(2);
				
				viewDataTypeTable(first, second);
				viewArithmeticTable(first, second);
				
				boolean p1 = getBool(1);
				boolean p2 = getBool(2);
				
				viewLogicTable(p1, p2);
				System.out.println();
				System.out.println("Press enter to continue");
				s.nextLine();
			}
		} while (choice != 2);
		
		
	}

	private boolean getBool(int order) {
		
		System.out.println();
		String order_string = null;
		if(order == 1) {
			order_string = " p1 ";
		} else if (order == 2){
			order_string = " p2 ";
		}
		
		String input = " ";
		do {
			System.out.print("Give me value for" + order_string + "[true | false] : ");

			input = s.next();
			s.nextLine();
			if(input.contentEquals("true")) {
				break;
			} else if (input.contentEquals("false")) {
				break;
			}
		} while(true);
		
		if(input.contentEquals("true")) {
			return true;
		}
		
		return false;
	}

	private int getInt(int order) {
		
		System.out.println();
		String order_string = null;
		if(order == 1) {
			order_string = " first ";
		} else if (order == 2){
			order_string = " second ";
		}
		
		int input = 0;
		do {
			System.out.print("Input the" + order_string + "number [1-100](inclusive) : ");
			input = s.nextInt();
			s.nextLine();
		} while(input < 1 || input > 100);
		
		return input;
	}

	private void viewLogicTable(boolean p1, boolean p2) {
		
		System.out.println();
		System.out.println("Logical Table");
		String desc = "P1 = ";
		desc = desc.concat(String.valueOf(p1));
		desc = desc.concat(" P2 = ");
		desc = desc.concat(String.valueOf(p2));
		System.out.println("+=================================================+");
		System.out.printf("+ %-47s +\n", desc);
		System.out.println("+=================================================+");
		System.out.println("+    !P1    |    !P2    |     &&     |     ||     +");
		System.out.println("+=================================================+");
		
		String notP1 = String.valueOf(!p1);
		String notP2 = String.valueOf(!p2);
		String p1_and_p2 = String.valueOf(p1 && p2);
		String p1_or_p2 = String.valueOf(p1 || p2);
		
		System.out.printf("+ %-9s | %-9s | %-10s | %-10s +\n", notP1, notP2, p1_and_p2, p1_or_p2);
		
		System.out.println("+=================================================+");
		
	}

	private void viewArithmeticTable(int first, int second) {
		
		System.out.println();
		System.out.println("Arithmetic Operation Table");
		System.out.println("+===========================================================+");
		System.out.println("+     +     |     -     |     *     |     /     |     %     +");
		System.out.println("+===========================================================+");
		System.out.printf("+ %-9d | %-9d | %-9d | %-9d | %-9d +\n", (first+second), (first-second), (first*second), (first/second), (first%second));
		System.out.println("+===========================================================+");
	}

	private void viewDataTypeTable(int first, int second) {
		
		System.out.println();
		System.out.println("Java Data Type Table ");
		System.out.println("+=========================================================================================================================+");
		System.out.println("+  + (String type)  |  (Character Type)  |  * (Integer type)  |  / (Floating Type)  |  input 1 == input 2 (Boolean Type)  +");
		System.out.println("+=========================================================================================================================+");
		
		String s1 = String.valueOf(first);
		String s2 = String.valueOf(second);
		System.out.printf("+  %-15s  |", s1 + " +  " + s2);
		
		char c1 = (char) first;
		char c2 = (char) second;
		String sc1 = String.valueOf(c1);
		String sc2 = String.valueOf(c2);
		
		System.out.printf("  %-16s  |", sc1 + "   " + sc2);
		
		System.out.printf("  %-16d  |", first * second);
		
		float f1 = (float) first;
		float f2 = (float) second;
		System.out.printf("  %-17f  |", (f1/f2));
		
		boolean b = (first == second);
		System.out.printf("  %-33s  +\n", String.valueOf(b));
		
		System.out.println("+=========================================================================================================================+");
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
		
	}

}
