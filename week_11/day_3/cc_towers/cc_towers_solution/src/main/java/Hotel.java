import java.util.ArrayList;

public class Hotel {
    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<DiningRoom> diningRooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

    public Hotel(String name) {
        this.name = name;
        bedrooms = new ArrayList<>();
        conferenceRooms = new ArrayList<>();
        diningRooms = new ArrayList<>();
    }

    public String getName() {
        return name;
    }


    public int bedroomCount() {
        return this.bedrooms.size();
    }

    public int conferenceRoomCount() {
        return this.conferenceRooms.size();
    }


    public int diningRoomCount() {
        return this.diningRooms.size();
    }

    public void addBedroom(Bedroom bedroom) {
        this.bedrooms.add(bedroom);
    }

    public void addDiningRoom(DiningRoom room) {
        this.diningRooms.add(room);
    }

    public void addConferenceRoom(ConferenceRoom room) {
        this.conferenceRooms.add(room);
    }

    public void checkInGuestsToBedroom(int roomNumber, ArrayList<Guest> guests) {
        Bedroom room = findBedroom(roomNumber);
        if (room != null) {
            for (Guest guest : guests) {
                room.checkIn(guest);
            }
        }
    }


    public void checkInGuestsToDiningRoom(ArrayList<Guest> guests, String name) {
        DiningRoom room = findDiningRoom(name);
        if (room != null) {
            for (Guest guest : guests) {
                room.checkIn(guest);
            }
        }
    }


    public void checkInGuestsToConferenceRoom(ArrayList<Guest> guests, String name) {
        ConferenceRoom room = findConferenceRoom(name);
        if (room != null) {
            for (Guest guest : guests) {
                room.checkIn(guest);
            }
        }

    }


    public void checkGuestsOutOfBedroom(int roomNumber) {
        Bedroom room = findBedroom(roomNumber);
        if (room != null) {
            room.checkOut();
        }
    }

    public void checkGuestsOutOfConferenceRoom(String name) {
        ConferenceRoom foundRoom = findConferenceRoom(name);
        if (foundRoom != null) {
            foundRoom.checkOut();
        }
    }

    public void checkGuestsOutOfDiningRoom(String name) {
        DiningRoom foundRoom = findDiningRoom(name);
        if (foundRoom != null) {
            foundRoom.checkOut();
        }
    }

    public Bedroom findBedroom(int roomNumber) {
        Bedroom foundRoom = null;
        for (Bedroom room : this.bedrooms) {
            if (room.getNumber() == roomNumber) {
                foundRoom = room;
            }
        }
        return foundRoom;
    }

    public ConferenceRoom findConferenceRoom(String name) {
        ConferenceRoom foundRoom = null;
        for (ConferenceRoom room : this.conferenceRooms) {
            if (room.getName() == name) {
                foundRoom = room;
            }
        }
        return foundRoom;
    }

    public DiningRoom findDiningRoom(String name) {
        DiningRoom foundRoom = null;
        for (DiningRoom room : this.diningRooms) {
            if (room.getName() == name) {
                foundRoom = room;
            }
        }
        return foundRoom;
    }


}
