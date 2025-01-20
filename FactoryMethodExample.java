/*Creational Pattern.
 * 
 * The program simulates a bike factory. This is a simple example of what a factory method does.
 * with the product side we use a abstract method to allow for different versions of bikes which is 
 * the concrete classes inherited from the abstract class, then for the creators side we use.
 * The pattern requires a product class to 
 * build the different objects.
 * */

package creationalPatterns;

// Base class for all bike builds
abstract class Bike {
	abstract void printBike();
}

// First product: Mountain Bikes
class MountainBike extends Bike{
	public void printBike() {
		System.out.print("I'm a mountain bike.");
	}
}

// Second product: Road Bikes
class RoadBike extends Bike {
	public void printBike() {
		System.out.println("I'm a road bike");
	}
}

// interface to control the build of the bike
interface BikeBuilder {
	public Bike buildBike();
}


// class is used to create the bike object.
class MountainBikeBuild implements BikeBuilder {
	public Bike buildBike() {
		return new MountainBike();
	}
} 

// class is used to build the Road Bike object
class RoadBikeBuild implements BikeBuilder {
	public Bike buildBike() {
		return new RoadBike();
	}
}

// class to call the buildBike methods for and subclass
class BikeMaker {
	private Bike bike;
	
	public BikeMaker(BikeBuilder bikeParts) {
		bike = bikeParts.buildBike();
	}
	
	public Bike getMadeBike() {
		return bike;
	}
}

// Main Class
public class FactoryMethodExample {
		
	public static void main(String[] args) {
		BikeBuilder roadBikeMaterial = new RoadBikeBuild();
		BikeMaker roadBikeMaker = new BikeMaker(roadBikeMaterial);
		Bike roadBike = roadBikeMaker.getMadeBike();
		roadBike.printBike();
		
		BikeBuilder mountainBikeMaterials = new MountainBikeBuild();
		BikeMaker mountainBikeMaker = new BikeMaker(mountainBikeMaterials);
		Bike mountainBike = mountainBikeMaker.getMadeBike();
		mountainBike.printBike();
	}

}
