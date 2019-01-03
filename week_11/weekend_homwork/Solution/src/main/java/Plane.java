import java.util.ArrayList;

public class Plane {

    private PlaneType type;
    private String airline;
    private ArrayList<Passenger> passengers;

    public Plane(PlaneType type, String airline){
        this.type = type;
        this.airline = airline;
        this.passengers = new ArrayList<Passenger>();
    }

    public PlaneType getType() {
        return type;
    }

    public String getAirline() {
        return airline;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public int getCapacity(){
        return this.type.getCapacity();
    }

    public int getAvailableSeats() {
        return getCapacity() - this.passengers.size();
    }

    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
    }

    public int getTicketsSold() {
        return this.passengers.size();
    }
}
