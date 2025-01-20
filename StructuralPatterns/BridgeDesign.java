/* Structural patterns
 * 
 * Bridge Design Pattern allows you to separate abstraction from implementation. This program simulates 
 * different mechanic shop where cars, motorcycles, boats get repaired. This is a simple program that simply out 
 * puts a couple of strings. This pattern helps to separate the abstraction from the implementation and has a 
 * driver layer that interacts with the implementation layer. Since this pattern uses composition you can also 
 * further separate objects like a vehicle object and repair shop object as oppose to being from one class. 
 * */
package structuralPatterns;

// abstract layer of the design pattern that become the blue prints to the next layer.
abstract class Vehicle {
	protected RepairShop repairShopA;
	protected RepairShop repairShopB;
	
	// constructor that that takes in two repair shop objects.
	Vehicle (RepairShop repairShopA, RepairShop repairShopB){// this block of code promotes the idea of composition.
		this.repairShopA = repairShopA;
		this.repairShopB = repairShopB;
	}
	
	abstract void repair();
}

//implementation layer for Vehicle class car object
class Car extends Vehicle {// sends repair objects to abstract class constructor
	Car (RepairShop repairShopA, RepairShop repairShopB){
		super(repairShopA, repairShopB);
	}
	
	// a method that calls repairShop objects and falls into the use
		// of composition.
	public void repair() {
		System.out.print("Car ");
		repairShopA.fixed();
		repairShopB.fixed();
	}
}

// implementation layer for Vehicle class motorcycle object
class Motorcycle extends Vehicle {
	Motorcycle (RepairShop repairShopA, RepairShop repairShopB){
		super(repairShopA, repairShopB);
	}
	
	// a method that calls repairShop objects and falls into the use
	// of composition.
	public void repair() {// sends repair objects to abstract class constructor
		System.out.print("Motorcycle ");
		repairShopA.fixed();
		repairShopB.fixed();
	}
}

class Boat extends Vehicle {
	Boat (RepairShop repairShopA, RepairShop repairShopB){
		super(repairShopA, repairShopB);
	}
	
	// a method that calls repairShop objects and falls into the use
		// of composition.
	public void repair() {
		System.out.print("Boat ");
		repairShopA.fixed();
		repairShopB.fixed();
	}
}

// abstraction layer for the RepairShop class
interface RepairShop {
	abstract void fixed();// method used to print strings in objects with the RepairShop interface
}

// implementation layer for the RepairShop interface
class Fixing implements RepairShop {
	public void fixed () {
		System.out.print("fixed and ");
	}
}

class Fixed implements RepairShop {
	public void fixed() {
		System.out.print("ready to be ");
		System.out.println("picked up.");
	}
}

// main program
public class BridgeDesign {

	public static void main(String[] args) {
		Vehicle car = new Car(new Fixing(), new Fixed()); // instantiating car object
		car.repair(); // calling repair method
		Vehicle motorcycle = new Motorcycle(new Fixing(), new Fixed());
		motorcycle.repair();
		Vehicle boat = new Boat(new Fixing(), new Fixed());
		boat.repair(); 
	}
}
