package music_shop;

public abstract class Instrument {
    private String colour;
    private String type;

    public Instrument(String colour, String type) {
        this.colour = colour;
        this.type = type;
    }

    public String getColour() {
        return this.colour;
    }

    public String getType() {
        return this.type;
    }
}