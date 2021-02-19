package ui;

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
		int totalTipOut = 0;
		double totalHoursWorked = 0;

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
		ServerAssistant sa1 = new ServerAssistant("Jake", "Pineault", 8.75);
		ServerAssistant sa2 = new ServerAssistant("Robbie", "Finger", 4.5);
		ServerAssistant sa3 = new ServerAssistant("William", "Black", 6);
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
			case "help":
				commandMenu();
				break;
			case "exit":
				break;
			default:
				System.out.println("Invalid Entry. PLease try again.");
				break;
			}
			
		}
		
	}
	
	private static void commandMenu() {
		StringBuilder menu = new StringBuilder("========== COMMAND MENU ==========\n");
		menu.append("-list s-  List All Pets\n");
		menu.append("-add s- Add a Server\n");
		menu.append("-add sa-   Add a Server Assistant\n");
		menu.append("-help-  Display Command Menu\n");
		menu.append("-exit-  Exit Application\n");
		menu.append("==================================\n");
		System.out.println(menu);
	}
	
	public static String getBorder () {
		StringBuilder sb = new StringBuilder (58);
		while (sb.length() < 58) {
			sb.append("-");
		}
		return sb.toString();
	}
	
	public static int getTotalTipOut() {
		int to = 0;
		return to;
	}
	
	public static double getTotalHoursWorked() {
		double tow = 0;
		
		return tow;
	}

}
