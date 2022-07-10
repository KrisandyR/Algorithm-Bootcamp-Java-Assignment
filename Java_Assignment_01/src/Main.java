import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Main {
	
	Scanner s = new Scanner(System.in);
	Vector<Participant> participants = new Vector<>();
	
	
	private void clearScr() {
		int i = 0;
		while (i <= 10) {
			System.out.println();
			i++;
		}
	}
	
	
	private void printMainMenu() {
		
		clearScr();
		System.out.println("1. Start Sharing");
		System.out.println("2. Update Participant");
		System.out.println("3. Delete Participant");
		System.out.println("4. Close App");
		System.out.println("============================");
		System.out.print("Choice >> ");
	}
	
	
	public Main() {
		
		boolean onMainMenu = true;
		
		do {
			printMainMenu();
			int input = s.nextInt();
			s.nextLine();
			switch (input) {
				case 1:
					startSharingMenu();
					break;
				case 2:
					updateParticipantMenu();
					break;
				case 3:
					deleteParticipantMenu();
					break;
				case 4:
					onMainMenu = false;
					break;
			}
		} while(onMainMenu == true);
		
		printExitTable();
		s.close();
		
	}
	
	
	private void startSharingMenu() {
	
		int number = -1;
		String username = null;
		
		do {
			System.out.print("Input a number[0 - 100] : ");
			try {
				number = s.nextInt(); s.nextLine();
			} catch (Exception e) {
				System.out.println("Input must be numeric");
				s.reset();
				s.nextLine();
			}
		} while (number < 0 || number > 100);
		
		do {
			System.out.print("Could you give me your username [5-20 Characters]? ");
			try {
				username = s.nextLine();
			} catch (Exception e) {
				System.out.println("Please input with the correct format");
			} 
			
		} while((username.length() < 5 || username.length() > 20) || !usernameIsUnique(username));
		
		Participant newParticipant = new Participant(username, number);
		participants.add(newParticipant);
		
		System.out.println("You are the " + (participants.size()) + " that joins the game");
		System.out.println();
		System.out.println("Press enter to continue . . . ");
		s.nextLine();
		
	}
	
	private boolean usernameIsUnique(String username) {
		
		for(Participant s: participants) {
			if(s.name.contentEquals(username)) {
				System.out.println("Username has already been taken!!");
				return false;
			}
		}
		return true;
		
	}
	
	private boolean viewParticipantTable() {
		
		System.out.println("");
		System.out.println("");
		
		if(participants.isEmpty()) {
			System.out.println("There is no data");
			System.out.println();
			System.out.println("Press enter to continue . . . ");
			return false;
		}
		
		System.out.println("Share List");
		System.out.println("====================================");
		
		int idx = 1;
		for(Participant s: participants) {
			System.out.printf("| %3d | %-20s | %-3d |\n", idx, s.name, s.shareNumber);
			idx++;
		}
		
		System.out.println("====================================");
		
		return true;
	}
	
	private void updateParticipantMenu() {
		
		if(!viewParticipantTable()) {
			return;
		}
		
		int input = -1;
		do {
			System.out.printf("Which participant would you like to update [%d - %d][0 to exit] : ", 1, participants.size());
			try {
				input = s.nextInt(); s.nextLine();
			} catch (Exception e) {
				s.nextLine();
				System.out.println("Input must be numeric");
			}
		} while(input < 0 || input > participants.size());
		
		if(input == 0) return;
		
		int newShareNumber = -1;
		do {
			System.out.print("Input a number[0 - 100] : ");
			try {
				newShareNumber = s.nextInt(); s.nextLine();
			} catch (Exception e) {
				System.out.println("Input must be numeric");
				s.reset();
				s.nextLine();
			}
		} while (newShareNumber < 0 || newShareNumber > 100);
		
		participants.get(input-1).changeShareNumber(newShareNumber);
		
		System.out.println("Update Succesfull");
		System.out.printf("\nPress enter to continue");
		s.nextLine();
	}
	
	private void deleteParticipantMenu() {
		
		if(!viewParticipantTable()) {
			return;
		}
		
		int input = -1;
		do {
			System.out.printf("Which participant would you like to delete [%d - %d][0 to exit] : ", 1, participants.size());
			try {
				input = s.nextInt(); s.nextLine();
			} catch (Exception e) {
				s.nextLine();
				System.out.println("Input must be numeric");
			}
		} while(input < 0 || input > participants.size());
		
		if(input == 0) return;
		
		participants.remove(input-1);
		
		System.out.println("Delete Succesfull");
		System.out.printf("\nPress enter to continue");
		s.nextLine();
		
	}

	private void printExitTable() {

		sortUsername(participants);
		
		Vector<Integer> oldValues = new Vector<>();
		for(Participant p: participants) {
			oldValues.add(Integer.valueOf(p.shareNumber));
		}
		
		shuffleNumber(participants);
		
		System.out.println("================================================");
		System.out.println("| No. | Username              | Before | After |");
		System.out.println("================================================");
		for(int i = 0; i<participants.size(); i++) {

			
			
			System.out.printf("| %-3d | %-21s | %6d | %5d |\n", i+1, participants.get(i).name, oldValues.get(i), participants.get(i).shareNumber);
		}
		System.out.println("================================================");
		
	}
	
	private void sortUsername(List<Participant> participantList) {
		Collections.sort(participantList, new Comparator<Participant>() {
			@Override
			public int compare(Participant o1, Participant o2) {
				return o1.name.compareTo(o2.name);
			}
		});
	}
	
	private void shuffleNumber(List<Participant> participantList) {
		
		Vector<Integer> values = new Vector<>();
		for(Participant p: participantList) {
			values.add(Integer.valueOf(p.shareNumber));
		}
		
		Collections.shuffle(values);
		Collections.reverse(values);
		
		for(int i = 0; i <  participantList.size(); i++) {
			participantList.get(i).changeShareNumber(values.get(i));
		}
	}
	
	
	public static void main(String[] args) {
		new Main();
	}

}
