package Individuals;

public class DiplodocusMaster extends Diplodocus implements Master {

    private static DiplodocusMaster lUnique;
    
    private DiplodocusMaster(boolean gender, int energyPoints, String alliance) {
        super(gender, energyPoints, alliance);
    };

    public static DiplodocusMaster createUnique(boolean genre, int energyPoints, String alliance) {
        if (lUnique == null) {
            lUnique = new DiplodocusMaster(genre, energyPoints, alliance);
        }
        return lUnique;
    }
    
    public static DiplodocusMaster getInstance() {
        return lUnique;
    }
}