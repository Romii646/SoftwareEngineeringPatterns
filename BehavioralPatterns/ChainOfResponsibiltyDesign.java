/*Chain of Responsibility design
 * 
 *This program continues with the mechanic shop concept except structuring it
 *as a chain of responsibility pattern. The program simply outputs statements 
 *within its called methods to demonstrate the blue print of this pattern. the way
 *this pattern uses a interface or abstract class as the super class and subclasses
 *are the different behaviors while using a client class to manipulate the different states
 *in behavior
 *
 *This is a mechanic shop that employs three mechanics. Each specializing in a different
 *vehicle. The first mechanic specializes in repairing cars, second repairs motorcycles,
 *and third repairs boats.*/

package behavioralPatterns;

// enum structure to hold constants
enum Specialty{
	CAR, MOTORCYCLE, BOAT
}

// abstraction layer to create different behavior classes
interface Mechanic {
	void sendToNextMechanic(Mechanic nextMechanic);
	void vehicleToRepair(Clerk nextVehicle);
	
}

class CarMechanic implements Mechanic {
	Mechanic nextMechanic;
	
	public void sendToNextMechanic(Mechanic nextMechanic) {
		this.nextMechanic = nextMechanic;
	}
	
	public void vehicleToRepair(Clerk nextVehicle) {
		if(nextVehicle.getVehicle() == Specialty.CAR) {
			System.out.println("Fixing car!");
		}
		else if(nextMechanic != null) {
			nextMechanic.vehicleToRepair(nextVehicle);
		}
	}
}

class MotorcycleMechanic implements Mechanic {
Mechanic nextMechanic;
	
	public void sendToNextMechanic(Mechanic nextMechanic) {
		this.nextMechanic = nextMechanic;
	}
	
	public void vehicleToRepair(Clerk nextVehicle) {
		if(nextVehicle.getVehicle() == Specialty.MOTORCYCLE) {
			System.out.println("Fixing motorcycle!");
		}
		else if(nextMechanic != null) {
			nextMechanic.vehicleToRepair(nextVehicle);
		}
	}
}

class BoatMechanic implements Mechanic {
Mechanic nextMechanic;
	
	public void sendToNextMechanic(Mechanic nextMechanic) {/* Empty because there isn't another mechanic to pass a vehicle off to.*/}
	
	public void vehicleToRepair(Clerk nextVehicle) {
		if(nextVehicle.getVehicle() == Specialty.BOAT) {
			System.out.println("Fixing Boat!");
		}
		else if(nextMechanic != null) {
			System.out.println("Unless you have a car, motorcycle, or boat we cant help you here.");
		}
	}
}

// client class to 
class Clerk {
	private Specialty nextVehicle;
	
	public Clerk(Specialty nextVehicle) {
		this.nextVehicle = nextVehicle;
	}
	
	public Specialty getVehicle() {
		return nextVehicle;
	}
}

// main program
public class ChainOfResponsibiltyDesign {
	public static void main(String[] args) {
		Mechanic carMechanic = new CarMechanic();
		Mechanic motorcycleMechanic = new MotorcycleMechanic();
		Mechanic boatMechanic = new BoatMechanic();
		
		Clerk ticketOne = new Clerk(Specialty.CAR);
		Clerk ticketTwo = new Clerk(Specialty.MOTORCYCLE);
		Clerk ticketThree = new Clerk(Specialty.BOAT);
		
		carMechanic.sendToNextMechanic(motorcycleMechanic);
		motorcycleMechanic.sendToNextMechanic(boatMechanic);
		
		carMechanic.vehicleToRepair(ticketOne);
		carMechanic.vehicleToRepair(ticketTwo);
		carMechanic.vehicleToRepair(ticketThree);
	}
}
