package Outputs;

public class Headphones implements IOutput {
    private String make;
    private String model;

    public Headphones(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String blastSound(String sound) {
        return "Playing " + sound + " in your ears.";
    }
}
