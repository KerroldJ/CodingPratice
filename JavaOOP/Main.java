class Car {

    String brand;

    void drive() {
        System.out.println(brand + " is driving.");
    }
}

public class Main {

    public static void main(String[] args) {
        Car car1 = new Car(); // In the OOP Concept, we can create an object of the class Car using the new keyword. This object will have its own state and behavior defined by the class.
        car1.brand = "Toyota";
        car1.drive();
    }
    
}
