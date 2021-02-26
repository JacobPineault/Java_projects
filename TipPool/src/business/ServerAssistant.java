package business;

import util.Console;

public class ServerAssistant {
	int id;
	static int idCounter = 1;
	String firstName = "";
	String lastName = "";
	double hoursWorked;
	double tipPerShift;
	// boolean closer;
	
	public ServerAssistant(String firstName, String lastName, double hoursWorked, double tipPerShift) {
		super();
		this.id = idCounter++;
		this.firstName = firstName;
		this.lastName = lastName;
		this.hoursWorked = hoursWorked;
		this.tipPerShift = tipPerShift;
//		this.closer = closer;
	}

	public ServerAssistant() {
		super();
	}
	
	public static ServerAssistant addServerAssisstant() {
		String fName = Console.getString("First Name? ", true);
		String lName = Console.getString("Last Name? ", true);
		double hrs = Console.getDouble("Hours worked? ");
		double tipPerShift = 0;
		ServerAssistant sa = new ServerAssistant(fName, lName, hrs, tipPerShift);
		System.out.println(sa.firstName + " " + sa.lastName + " was added!\n");
		return sa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public double getHoursWorked() {
		return hoursWorked;
	}

	public void setHoursWorked(double hoursWorked) {
		this.hoursWorked = hoursWorked;
	}

//	public boolean isCloser() {
//		return closer;
//	}
//
//	public void setCloser(boolean closer) {
//		this.closer = closer;
//	}

	public double getTipPerShift() {
		return tipPerShift;
	}

	public void setTipPerShift(double tipPerShift) {
		this.tipPerShift = tipPerShift;
	}

	@Override
	public String toString() {
		return firstName + " " + lastName + ", hoursWorked= "
				+ hoursWorked + "TipoutPerShift = " + tipPerShift;
	}
	
	
}
