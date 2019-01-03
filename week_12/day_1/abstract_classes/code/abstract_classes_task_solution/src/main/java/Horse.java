public class Horse extends FarmAnimal{
    String breed;

    public Horse(String breed) {
        this.species = "horse";
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String introduceYourself() {
        return super.introduceYourself() +  " from " + breed +" family, " + makeANoise();
    }

    @Override
    public String makeANoise() {
        return "neigh";
    }
}
