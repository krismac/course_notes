import java.lang.reflect.Array;
import java.util.ArrayList;

public class ConferenceRoom {
    private double pricePerDay;
    private String name;
    private int capacity;
    private ArrayList<Guest> guests;

    public ConferenceRoom(String name, int capacity, double pricePerDay) {
        this.name = name;
        this.capacity = capacity;
        this.pricePerDay = pricePerDay;
        this.guests = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getPricePerDay() {
        return this.pricePerDay;
    }

    public int numberOfGuests() {
        return this.guests.size();
    }


    public boolean isFull() {
        return this.guests.size() == this.capacity;
    }

    public void checkIn(Guest guest) {
        if (!isFull()) {
            this.guests.add(guest);
        }
    }

    public void checkOut() {
        this.guests.clear();
    }


}
