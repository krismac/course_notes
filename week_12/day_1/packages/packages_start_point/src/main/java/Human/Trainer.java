package Human;

import Animal.Dog;

public class Trainer {
    public void teach(Dog dog) {
        dog.name = "Pet";
        dog.bark();
    }
}
