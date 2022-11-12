package Individuals;

public abstract class Tyrannosaurus extends Dinosaur {

    private static String allianceMadeWith;  // Type de dinosaure avec qui on fait l'alliance.
    private static String typeOfDinosaur = "Tyrannosaurus";

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

    public String getTypeOfDinosaur(){
        return typeOfDinosaur;
    }
}