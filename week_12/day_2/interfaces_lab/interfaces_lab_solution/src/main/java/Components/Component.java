package Components;

public abstract class Component {
    private String make;
    private String model;

    public Component(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }
}
