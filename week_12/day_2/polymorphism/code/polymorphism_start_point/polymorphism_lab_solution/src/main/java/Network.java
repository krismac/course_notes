import java.util.*;

public class Network {
    private String name;
    private int maxConnections;
    private ArrayList<IConnect> devices;

    public Network(String name, int maxConnections){
        this.devices = new ArrayList<IConnect>();
        this.name = name;
        this.maxConnections = maxConnections;
    }

    public String getName(){
        return name;
    }

    public int getMaxConnections() {
        return this.maxConnections;
    }

    public int deviceCount(){
        return devices.size();
    }

    public void connect(IConnect device){
        if (this.freeSlots() > 0) {
            devices.add(device);
        }
    }

    public void disconnectAll(){
        devices.clear();
    }

    public int freeSlots() {
        return this.maxConnections - this.deviceCount();
    }
}