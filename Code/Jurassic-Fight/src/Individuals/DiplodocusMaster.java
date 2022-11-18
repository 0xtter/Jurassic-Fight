package individuals;

public class DiplodocusMaster extends Diplodocus implements Master {

    private static DiplodocusMaster lUnique;
    private static final String SYMBOL = "#D";
    
    private DiplodocusMaster(int energyPoints) {
        super(energyPoints,SYMBOL);
    }

    public static DiplodocusMaster createUnique(int energyPoints) {
        if (lUnique == null) {
            lUnique = new DiplodocusMaster( energyPoints);
        }
        return lUnique;
    }
    
    public static DiplodocusMaster getInstance() {
        return lUnique;
    }
}