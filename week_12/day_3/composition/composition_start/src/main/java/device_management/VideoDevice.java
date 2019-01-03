package device_management;

public abstract class VideoDevice {
    private int screenSize;
    private int pixels;

    public VideoDevice(int screenSize, int pixels) {
        this.screenSize = screenSize;
        this.pixels = pixels;
    }

    public int getScreenSize() {
        return this.screenSize;
    }

    public int getPixels() {
        return this.pixels;
    }

    public String display(String data) {
        return data + " is now on screen";
    }
}
