package Individuals;

public class DiplodocusMaster extends Diplodocus implements Master {

    private static DiplodocusMaster lUnique;
    private static final String SYMBOL = "#D";
    
    private DiplodocusMaster(boolean gender, int energyPoints) {
        super(gender, energyPoints,SYMBOL);
    };

    public static DiplodocusMaster createUnique(boolean genre, int energyPoints) {
        if (lUnique == null) {
            lUnique = new DiplodocusMaster(genre, energyPoints);
        }
        return lUnique;
    }
    
    public static DiplodocusMaster getInstance() {
        return lUnique;
    }
}