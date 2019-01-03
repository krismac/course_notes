package device_management;

public abstract class PrintingDevice {
    private String make;
    private String model;

    public PrintingDevice(String make, String model) {
        this.make = make;
        this.model = model;
    }

    public String getMake() {
        return this.make;
    }

    public String getModel() {
        return this.model;
    }

    public String display(String data) {
        return "now displaying: " + data;
    }
}
