public class InternetRadio implements IConnect{
    public String connect(String network) {
        return "connecting to network: " + network + ". Ready to Rock'n'Roll";
    }

    public String tune(String station) {
        return "tuning to " + station;
    }
}
