public abstract class FarmAnimal {
    String species;

    public String getSpecies() {
        return species;
    }

    public String introduceYourself(){
        return "Hi, I am a "+ species;
    }

    public abstract String makeANoise();
}
