package BusinessClass;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

import DatabaseClass.*;

public class BigBoxApp {
	public static void main(String[] args) throws IOException {
		System.out.println("Welcome to the Big Box application");
		System.out.println();

		String message = "COMMAND MENU" + "\n" + "list" + " " + "-List all stores" + "\n" + "div" + " "
				+ "-List all stores for a division" + "\n" + "add" + " " + "-Add a store" + "\n" + "Update" + " "
				+ "-Update a store" + "\n" + "list divs" + " " + "-List all Divisions" + "\n" + "new Div" + " "
				+ "-Add a Division" + "\n" + "Del str" + " " + "-Delete a store" + "\n" + "Del div" + " "
				+ "-Delete a Division" + "\n" + "sales" + " " + "-Sales summary" + "\n" + "divSales" + " "
				+ "-Sales summary by Division" + "\n" + "help" + " " + "-Show this menu" + "\n" + "exit" + " "
				+ "-Exit this application";

		System.out.println(message);
		Scanner sc = new Scanner(System.in);
		String choice = " ";
		NumberFormat c = NumberFormat.getCurrencyInstance();
		while (!choice.equalsIgnoreCase("exit")) {
			System.out.println();
			System.out.println("Enter a command: ");
			String userinput = sc.nextLine();
			BigBoxDAO dao = BigBoxFactory.getBigBoxDAO();

			if (userinput.equalsIgnoreCase("list")) {

				ArrayList<Store> stores = dao.listAllStores();
				String printStr = "";
				for (Store s : stores) {
					printStr += s.toString() + "\n";
				}
				System.out.println(printStr);
			} else if (userinput.equalsIgnoreCase("list Divs")) {

				ArrayList<Division> divisions = dao.listAllDivisions();
				String printStr = "";
				for (Division d : divisions) {
					printStr += d.toString() + "\n";

				}
				System.out.println(printStr);
			} else if (userinput.equalsIgnoreCase("div")) {
				System.out.println("Enter division Number: ");
				String divNum = sc.nextLine();

				System.out.println(new BigBoxDB().listAllStores(divNum));

			} else if (userinput.equalsIgnoreCase("add")) {
				System.out.println("Enter store divisionID:");
				String divisionID = sc.nextLine();
				System.out.println("Enter StoreNumber:");
				String StoreNumber = sc.nextLine();
				System.out.println("Enter store name:");
				String name = sc.nextLine();
				System.out.println("Enter store Address:");
				String address = sc.nextLine();
				System.out.println("Enter City:");
				String city = sc.nextLine();
				System.out.println("Enter state:");
				String state = sc.nextLine();
				System.out.println("Enter zip code:");
				String zip = sc.nextLine();
				System.out.println("Enter total sales:");
				double sales = sc.nextDouble();
				Store store = new Store(divisionID, StoreNumber, sales, name, address, city, state, zip);
				dao.addStore(store);

			} else if (userinput.equalsIgnoreCase("Update")) {
				System.out.println("Enter Store Number for the store to be updated: ");
				String StoreNumber = sc.nextLine();
				Store s = new Store();
				System.out.println("Enter store divisionID:");
				String divisionID = sc.nextLine();
				s.setStoreNum(StoreNumber);
				System.out.println("Enter store name:");
				String name = sc.nextLine();
				System.out.println("Enter store Address:");
				String address = sc.nextLine();
				System.out.println("Enter City:");
				String city = sc.nextLine();
				System.out.println("Enter state:");
				String state = sc.nextLine();
				System.out.println("Enter zip code:");
				String zip = sc.nextLine();
				System.out.println("Enter total sales:");
				double sales = sc.nextDouble();
				s = new Store(divisionID, StoreNumber, sales, name, address, city, state, zip);
				dao.updateStore(s);

			} else if (userinput.equalsIgnoreCase("new Div")) {
				System.out.println("Enter division number:");
				String divNum = sc.nextLine();
				System.out.println("Enter division name:");
				String name = sc.nextLine();
				System.out.println("Enter  Address:");
				String address = sc.nextLine();
				System.out.println("Enter City:");
				String city = sc.nextLine();
				System.out.println("Enter state:");
				String state = sc.nextLine();
				System.out.println("Enter zip code:");
				String zip = sc.nextLine();
				System.out.println("Enter division ID:");
				int ID = sc.nextInt();
				Division division = new Division(ID, divNum, name, address, city, state, zip);
				dao.addDivision(division);

			} else if (userinput.equalsIgnoreCase("Del str")) {
				// get division # from user
				// lookup the division object for that division # [if you have a Division
				// HashMap that would be sweet!]
				System.out.println("Enter  Store Number: ");
				String storeNum = sc.nextLine();
				Store s = new Store();
				s.setStoreNum(storeNum);
				dao.deleteStore(s);

				// get the store # from user
				// System.out.println("Enter store Number: ");
				// String storeNumber = sc.nextLine();
				// Store s = dao.getStoreForDivisionAndStoreNumber(d, storeNumber);
				// s.setStoreNumber(storeNumber);
				// dao.deleteStore(s);

			} else if (userinput.equalsIgnoreCase("Del Div")) {
				System.out.println("Enter Division Number: ");
				String DivNum = sc.nextLine();
				Division d = new Division();
				d.setDivNum(DivNum);
				dao.deleteDivision(d);

			} else if (userinput.equalsIgnoreCase("sales")) {
				String formattedSales = c.format(dao.getSalesSummary());
				System.out.println("Sales summary:  " + formattedSales);

			} else if (userinput.equalsIgnoreCase("DivSales")) {
				System.out.println("Enter division Number: ");
				String divNum = sc.next();
				String salesByDiv = c.format(dao.getSalesSummary(divNum));
				System.out.println("Sales of division " + divNum + " " + salesByDiv);

			} else if (userinput.equals("help")) {
				System.out.println(message);
				continue;
			} else if (userinput.equalsIgnoreCase("exit")) {
				break;

			}
			System.out.println();
			System.out.print("Type EXIT to end or any key to continue: ");
			choice = sc.next();
			sc.nextLine();
			System.out.println();

		}
		System.out.println("Thanks for using the Big Box app, Goodbye!");
		sc.close();
		System.exit(0);
	}

}
