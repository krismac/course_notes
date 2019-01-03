import java.util.ArrayList;

public class Airport {

    private ArrayList<Plane> hangar;
    private String code;

    public Airport(String code){
        this.code = code;
        this.hangar = new ArrayList<Plane>();
    }

    public String getCode() {
        return code;
    }

    public ArrayList<Plane> getHangar() {
        return hangar;
    }

    public boolean containsPlane() {
        if (this.hangar.size() > 0){
            return true;
        }
        return false;
    }

    public void addToHangar(Plane plane) {
        hangar.add(plane);
    }

    public void removeFromHangar(Plane plane) {
        int planeIndex = hangar.indexOf(plane);
        if (containsPlane() && planeIndex != -1) {
            hangar.remove(planeIndex);
        }
    }

    public Flight createFlight(Plane plane, int number, Airport airport) {
        removeFromHangar(plane);
        return new Flight(plane, number, airport);
    }

    public void sellTicket(Flight flight, Passenger passenger) {
        if (flight.getDestination() != this && flight.checkSeatsAvailable()) {
            flight.addTicket(passenger);
        }
    }

    public void replacePlane(Flight flight) {
        Plane replacementPlane = null;
        int ticketsSold = flight.getTicketsSold();

        for (Plane plane: this.hangar)
        {
            int planeCapacity = plane.getCapacity();

            if (planeCapacity >= ticketsSold) {
                if (replacementPlane == null){
                    replacementPlane = plane;
                } else if (planeCapacity < replacementPlane.getCapacity()) {
                    replacementPlane = plane;
                }

                flight.setPlane(replacementPlane);
            }
        }

    }
}
