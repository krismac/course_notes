public enum PlaneType {
    CESSNA(4),
    LEARJET(25),
    AIRBUS_A320(150),
    BOEING_747(400);

    private final int capacity;

    PlaneType(int capacity){
        this.capacity = capacity;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
