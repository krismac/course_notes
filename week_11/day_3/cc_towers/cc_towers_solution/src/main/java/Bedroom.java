import java.util.ArrayList;

public class Bedroom {
    private int number;
    private String type;
    private int capacity;
    private double pricePerNight;
    private ArrayList<Guest> guests;


    public Bedroom(int number, String type, int capacity, double pricePerNight) {
        this.type = type;
        this.number = number;
        this.capacity = capacity;
        this.guests = new ArrayList<>();
        this.pricePerNight = pricePerNight;
    }

    public int getNumber() {
        return this.number;
    }

    public String getType() {
        return this.type;
    }

    public int getCapacity() {
        return capacity;
    }

    public int numberOfGuests(){
        return this.guests.size();
    }

    public double getPricePerNight() {
        return this.pricePerNight;
    }

    public boolean isFull() {
        return this.numberOfGuests() == this.capacity;
    }

    public void checkIn(Guest guest) {
        if (!isFull()) {
            this.guests.add(guest);
        }
    }

    public void checkOut(){
        this.guests = new ArrayList<>();
    }
}
