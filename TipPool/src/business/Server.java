package business;

import util.Console;

public class Server {
	int id;
	static int idCounter = 1;
	String firstName = "";
	String lastName = "";
	int tipOut;
	
	public Server(String firstName, String lastName, int tipOut) {
		super();
		this.id = idCounter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.tipOut = tipOut;
	}

	public Server() {
		super();
	}
	
	public static Server addServer() {
		String fName = Console.getString("Server's first name? ", true);
		String lName = Console.getString("Server's lase name? ", true);
		int tip = Console.getInt("Tipout? $");
		Server s = new Server(fName, lName, tip);
		System.out.println(s.firstName + " " + s.lastName + " was added.\n");
		return s;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		Server.idCounter = idCounter;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTipOut() {
		return tipOut;
	}

	public void setTipOut(int tipOut) {
		this.tipOut = tipOut;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + ", tipOut= " + tipOut + "]";
	}
	
	
}
