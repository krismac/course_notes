public class Sheep extends FarmAnimal{

    public Sheep() {
        this.species = "sheep";
    }


    @Override
    public String introduceYourself() {
        return super.introduceYourself() + ", " + makeANoise();
    }

    @Override
    public String makeANoise() {
        return "baa";
    }
}