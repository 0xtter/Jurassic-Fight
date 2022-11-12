package Individuals;

public abstract class Tyrannosaurus extends Dinosaur {

    private static String allianceMadeWith;  // nom classe de la race alliée ?

    public Tyrannosaurus(boolean gender, int energyPoints, String alliance) {
        super(gender, energyPoints);
        allianceMadeWith = alliance;
    }

    public String getAlliance() {
        return allianceMadeWith;
    }

    public String setAlliance() {
        return allianceMadeWith;
    }
}