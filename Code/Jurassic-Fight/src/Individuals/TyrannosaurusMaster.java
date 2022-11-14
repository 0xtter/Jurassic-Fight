package Individuals;

import Map.Map;

public class TyrannosaurusMaster extends Tyrannosaurus implements Master {

    private static TyrannosaurusMaster lUnique;
    
    private TyrannosaurusMaster(boolean gender, int energyPoints, Map map) {
        super(gender, energyPoints,map);
    };

    public static TyrannosaurusMaster createUnique(boolean genre, int energyPoints, Map map) {
        if (lUnique == null) {
            lUnique = new TyrannosaurusMaster(genre, energyPoints, map);
        }
        return lUnique;
    }
    
    public static TyrannosaurusMaster getInstance() {
        return lUnique;
    }

}