public class Booking {

    private Bedroom room;
    private int numberOfNights;

    public Booking(Bedroom room, int numberOfNights) {
        this.room = room;
        this.numberOfNights = numberOfNights;
    }

    public double getTotalBill(){
        return this.numberOfNights * room.getPricePerNight();
    }


}
