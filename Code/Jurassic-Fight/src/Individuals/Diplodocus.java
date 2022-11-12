package Individuals;

public abstract class Diplodocus extends Dinosaur {

    public static Race allianceMadeWith;  // nom classe de la race alliée ?

    public Diplodocus(boolean gender, int energyPoints) {
        super(gender, energyPoints);
    }

    public static Race getAlliance() {
        return allianceMadeWith;
    }

    public static void setAlliance(Race race) {
        allianceMadeWith = race;
    }

}