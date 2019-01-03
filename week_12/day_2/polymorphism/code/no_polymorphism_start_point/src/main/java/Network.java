import java.util.*;

public class Network {
    private String name;
    private ArrayList<Desktop> devices;

    public Network(String name){
        this.devices = new ArrayList<Desktop>();
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int deviceCount(){
        return devices.size();
    }

    public void connect(Desktop desktop){
        devices.add(desktop);
    }

    public void disconnectAll(){
        devices.clear();
    }
}