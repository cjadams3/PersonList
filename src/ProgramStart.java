import java.util.List;
import java.util.Scanner;
import controller.PersonItemHelper;
import model.PersonItem;

public class ProgramStart {
	static Scanner in = new Scanner(System.in);
	static PersonItemHelper pih = new PersonItemHelper();
	
	private static void addAnItem() {
		System.out.println("Enter a name: ");
		String name = in.nextLine();
		System.out.println("Enter an age: ");
		int age = in.nextInt();
		in.nextLine();
		System.out.println("Enter a gender: ");
		String gender = in.nextLine();
		
		PersonItem toAdd = new PersonItem(name, age, gender);
		pih.InsertItem(toAdd);
	}
	
	private static void deleteAnItem() {
		System.out.println("Enter the name of the person you want to delete: ");
		String name = in.nextLine();
		
		pih.DeleteItem(name);
	}
	
	private static void editAnItem() {
		List<PersonItem> foundItems;
		System.out.println("Enter the name of the person you want to edit: ");
		String personName = in.nextLine();
		foundItems = pih.getItemsByName(personName);
		
		if(!foundItems.isEmpty()) {
			System.out.println("Items found.");
			for (PersonItem i : foundItems) {
				System.out.println(i.getId() + " : " + i.toString());
			}
			
			System.out.println("Which ID to edit: ");
			int editID = in.nextInt();
			
			PersonItem toEdit = pih.searchForItemById(editID);
			System.out.println("Current information: ");
			toEdit.printDetails();
			
			System.out.println("1. Update name");
			System.out.println("2. Update age");
			System.out.println("3. Update gender");
			int update = in.nextInt();
			in.nextLine();
			
			if (update == 1) {
				System.out.println("New name: ");
				String name = in.nextLine();
				toEdit.setName(name);
			}
			else if (update == 2) {
				System.out.println("New age: ");
				int age = in.nextInt();
				toEdit.setAge(age);
			}
			else if (update == 3) {
				System.out.println("New gender: ");
				String gender = in.nextLine();
				toEdit.setGender(gender);
			}
			pih.updateItem(toEdit);
			
		}
		else {
			System.out.println("No items found.");
		}
	}
	
	public static void main(String[] args) {
		runMainMenu();
	}
	
	public static void runMainMenu() {
		boolean continueProgram = true;
		System.out.println("Person database program");
		while (continueProgram) {
			System.out.println("Please make a selection");
			System.out.println("1. Add an Item");
			System.out.println("2. Edit an Item");
			System.out.println("3. Delete an Item");
			System.out.println("4. View all Items");
			System.out.println("5. Exit Program");
			
			int userSelection = in.nextInt();
			in.nextLine();
			
			if (userSelection == 1) {
				addAnItem();
			}
			else if (userSelection == 2) {
				editAnItem();
			}
			else if (userSelection == 3) {
				deleteAnItem();
			}
			else if (userSelection == 4) {
				viewAllItems();
			}
			else if (userSelection == 5) {
				continueProgram = false;
				pih.cleanUp();
				System.out.println("Now exiting!");
			}
			else {
				System.out.println("Invalid Input. Please try again.");
				in.nextLine();
			}
		}
	}
	
	private static void viewAllItems() {
		List<PersonItem> allItems = pih.showAllItems();
		for (PersonItem singleItem : allItems) {
			singleItem.printDetails();
		}
	}
}
