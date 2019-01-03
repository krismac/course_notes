package people;


import people.Customer;
import vehicles.Vehicle;

import java.util.ArrayList;

public class Dealer extends Person{

    ArrayList<Vehicle> vehicles;

    public Dealer(String name, double money) {
        super(name, money);
        this.vehicles = new ArrayList<>();
    }

    public int vehicleCount(){
        return this.vehicles.size();
    }

    public void sellCar(Vehicle vehicle, Customer customer){

        if (vehicle.canBuy(customer) == true){
            money += vehicle.getPrice();
            customer.money -= vehicle.getPrice();
        }
    }

    public void buyCar(Vehicle vehicle){
        if (this.money >= vehicle.getPrice()){
            money -= vehicle.getPrice();
            this.vehicles.add(vehicle);
        }
    }

    public void repairVehicle(double cost, Vehicle vehicle){
        vehicle.repair(cost);
        this.money -= cost;
    }
}
