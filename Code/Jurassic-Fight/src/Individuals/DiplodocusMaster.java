package Individuals;
import Map.Map;

public class DiplodocusMaster extends Diplodocus implements Master {

    private static DiplodocusMaster lUnique;
    
    private DiplodocusMaster(boolean gender, int energyPoints, Map map) {
        super(gender, energyPoints, map);
    };

    public static DiplodocusMaster createUnique(boolean genre, int energyPoints, Map map) {
        if (lUnique == null) {
            lUnique = new DiplodocusMaster(genre, energyPoints, map);
        }
        return lUnique;
    }
    
    public static DiplodocusMaster getInstance() {
        return lUnique;
    }
}