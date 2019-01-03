package Components;
import Components.Component;

public class Radio extends Component {

    public Radio(String make, String model) {
        super(make, model);
    }

    public String tune(String station) {
        return "Tuning to: " + station;
    }
}
