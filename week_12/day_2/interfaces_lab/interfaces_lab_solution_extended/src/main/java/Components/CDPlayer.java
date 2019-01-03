package Components;

import Components.Component;
import Components.IPlay;

public class CDPlayer extends Component implements IPlay {
    private int numberOfCDs;

    public CDPlayer(String make, String model, int numberOfCDs) {
        super(make, model);
        this.numberOfCDs = numberOfCDs;
    }

    public int getNumberOfCDs() {
        return numberOfCDs;
    }

    public String play(String title) {
        return "CD - Playing: " + title;
    }
}
