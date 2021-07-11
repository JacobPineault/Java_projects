package ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import business.Server;
import business.ServerAssistant;
import util.Console;

public class TipPoolApp {
	private static List<Server> serverList;
	private static List<ServerAssistant> serverAssistantList;
	
	public static void main(String[] args) {
		String command = "";
//		int totalTipOut = 0;
//		double totalHoursWorked = 0;

		serverList = new ArrayList<Server>();
		Server s1 = new Server("Mo", "Moesiph", 78);
		Server s2 = new Server("Sean", "Burns", 111);
		Server s3 = new Server("Adam", "Brown", 92);
		Server s4 = new Server("Dan", "Jameson", 220);
		serverList.add(s1);
		serverList.add(s2);
		serverList.add(s3);
		serverList.add(s4);
		
		serverAssistantList = new ArrayList<ServerAssistant>();
		ServerAssistant sa1 = new ServerAssistant("Jake", "Pineault", 8.75, 0);
		ServerAssistant sa2 = new ServerAssistant("Robbie", "Finger", 4.5, 0);
		ServerAssistant sa3 = new ServerAssistant("William", "Black", 6, 0);
		serverAssistantList.add(sa1);
		serverAssistantList.add(sa2);
		serverAssistantList.add(sa3);
		
		System.out.println("Tip Pool Calculator App\n");
		commandMenu();
		
		command = Console.getString("Command:  ", true);
		System.out.println();
		
		while (!command.equalsIgnoreCase("exit")) {
			switch (command) {
			case "list s":
				for (Server servers : serverList) {
					System.out.println(getBorder().toString());
					System.out.println(servers.getFirstName() + " " + servers.getLastName() + " - Tip Out = $ " + servers.getTipOut());
					System.out.println(getBorder().toString());
				}
				break;
			case "add s":
				serverList.add(Server.addServer());
				break;
			case "add sa":
				serverAssistantList.add(ServerAssistant.addServerAssisstant());
				break;
			case "tipout":
				getTotalTipOut(serverList);
				break;
			case "thours":
				getTotalHoursWorked(serverAssistantList);
				break;
			case "calc":
				calculateTotalTipout(serverList, serverAssistantList);
				break;
			case "sa":
				getSATipoutPerShift(serverAssistantList);
				break;
			case "help":
				commandMenu();
				break;
			case "exit":
				break;
			default:
				System.out.println("Invalid Entry. PLease try again.");
				break;
			}
			command = Console.getString("Next Command? ", true);
			System.out.println();
		}
		System.out.println("Bye");
	}
	
	private static void commandMenu() {
		StringBuilder menu = new StringBuilder("========== COMMAND MENU ==========\n");
		menu.append("-list s-  List All Pets\n");
		menu.append("-add s-   Add a Server\n");
		menu.append("-add sa-  Add a Server Assistant\n");
		menu.append("-tipout-  Find the total Tip Out\n");
		menu.append("-thours-  Find the total SA Hours worked\n");
		menu.append("-calc-    Calculate SA tipout\n");
		menu.append("-sa-      SA tipout\n");
		menu.append("-help-    Display Command Menu\n");
		menu.append("-exit-    Exit Application\n");
		menu.append("==================================\n");
		System.out.println(menu);
	}
	
	//Adds borders to separate each layer in the console for method testing
	public static String getBorder() {
		StringBuilder sb = new StringBuilder (58);
		while (sb.length() < 58) {
			sb.append("-");
		}
		return sb.toString();
	}
	
	//Calculates total tips from servers for the tip pool
	public static int getTotalTipOut(List<Server> serverList) {
		int serverTipoutTotal = 0;
		for (Server server : serverList) {
			serverTipoutTotal += server.getTipOut();
		}
		System.out.println("Final TipOut = " + serverTipoutTotal);
		return serverTipoutTotal;
	}
	
	//Calculates total hours worked from SA's for the tip pool
	public static double getTotalHoursWorked(List<ServerAssistant> serverAssistantList) {
		double serverAssistantHoursTotal = 0;
		for (ServerAssistant sa : serverAssistantList) {
			serverAssistantHoursTotal += sa.getHoursWorked();
		}
			System.out.println("Final TotalHoursWorked = " + serverAssistantHoursTotal);
		return serverAssistantHoursTotal;
	}

	// Truncate a double to a specific decimal value determined by the user
	// Add to Enhanced console
	public static double truncateDouble(double value, int decimalPoint) {
		double newValue = 0;
		value = value * Math.pow(10, decimalPoint);
		value = Math.floor(value);
		newValue = value / Math.pow(10, decimalPoint);
		return newValue;
	}
	
	// Add into Enhanced console for easy double configuration
	public static double bigDecimalSetPoint(double input) {
		double newValue = 0;
		BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.FLOOR);
		newValue = bd.doubleValue();
		System.out.println("BigDecimal double = " + newValue);
		return newValue;
	}
	
	// TODO Combine function with getSATipoutPerShift Show tipout per SA/calc running total
	public static double findTipoutRemainder(List<ServerAssistant> serverAssistantList) {
		double runningTotal = 0;
		for (ServerAssistant sa : serverAssistantList) {
			runningTotal += sa.getTipPerShift();
		}
		System.out.println("Running Total = " + runningTotal);
		return runningTotal;
	}
	
	// Method adds remainder of Tip pool to the last SA on the list
	public static void takeCareOfClosers (List<ServerAssistant> serverAssistantList, double remainder) {
		double tipPerShift = 0;
		ServerAssistant sa = serverAssistantList.get(serverAssistantList.size() - 1);
		tipPerShift = sa.getTipPerShift() + remainder;
		sa.setTipPerShift(tipPerShift);
	}
	
	public static void calculateTotalTipout(List<Server> serverList, List<ServerAssistant> serverAssistantList) {
		int totalTipout = 0;
		double totalHoursWorked = 0;
		double saTipTotal = 0;
		double remainder = 0;
		double tipoutRateOfPay = 0;
		totalTipout = getTotalTipOut(serverList);
		totalHoursWorked = getTotalHoursWorked(serverAssistantList);
		tipoutRateOfPay = totalTipout / totalHoursWorked;
		//tipoutRateOfPay must be truncated as to not exceed the amount on the Tip pool
		tipoutRateOfPay = bigDecimalSetPoint(tipoutRateOfPay);
			for (ServerAssistant sa : serverAssistantList) {
				double tipsForCurrentShift = 0;
				double saHoursWorked = sa.getHoursWorked();
				tipsForCurrentShift = tipoutRateOfPay * saHoursWorked;
				tipsForCurrentShift = bigDecimalSetPoint(tipsForCurrentShift);
				sa.setTipPerShift(tipsForCurrentShift);
				System.out.println(sa.getFirstName() + " " + sa.getLastName()+ 
						"\nTipout >>> " + sa.getTipPerShift());
				tipsForCurrentShift = 0;
		}
			saTipTotal = findTipoutRemainder(serverAssistantList);
			remainder = bigDecimalSetPoint(totalTipout - saTipTotal);
			System.out.println("Remainder = " + remainder);
			takeCareOfClosers(serverAssistantList, remainder);
	}
	
	public static void getSATipoutPerShift(List<ServerAssistant> serverAssistantList) {
		for(ServerAssistant sa : serverAssistantList) {
			System.out.println(sa.getFirstName() + " " + sa.getLastName() + " >>> $" 
			+ sa.getTipPerShift());
		}
	}
	
}
