package Individuals;

public abstract class Diplodocus extends Dinosaur {

    private static String allianceMadeWith;  // emum

    public Diplodocus(boolean gender, int energyPoints) {
        super(gender, energyPoints);
    }

    public String getAlliance() {
        return allianceMadeWith;
    }

    public String setAlliance() {
        return allianceMadeWith;
    }
}