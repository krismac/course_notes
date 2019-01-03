public class Flight {

    private Plane plane;
    private int number;
    private Airport destination;

    public Flight(Plane plane, int number, Airport destination){
        this.plane = plane;
        this.number = number;
        this.destination = destination;
    }

    public Plane getPlane() {
        return plane;
    }

    public int getNumber() {
        return number;
    }

    public Airport getDestination() {
        return destination;
    }

    public int getTicketsSold() {
        return this.plane.getTicketsSold();
    }

    public boolean checkSeatsAvailable() {
        if (this.plane.getAvailableSeats() > 0){
            return true;
        }
        return false;
    }

    public void addTicket(Passenger passenger) {
        this.plane.addPassenger(passenger);
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }
}
