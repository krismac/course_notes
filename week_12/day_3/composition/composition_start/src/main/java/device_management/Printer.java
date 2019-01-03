package device_management;

public class Printer extends PrintingDevice {
    private int dpi;
    private int printSpeed;

    public Printer(String make, String model, int dpi, int printSpeed) {
        super(make, model);
        this.dpi = dpi;
        this.printSpeed = printSpeed;
    }

    public int getDpi() {
        return this.dpi;
    }

    public int getPrintSpeed() {
        return this.printSpeed;
    }

    private String print(String data) {
        return "printing: " + data;
    }

    public String outputData(String data) {
        return this.print(data);
    }
}
