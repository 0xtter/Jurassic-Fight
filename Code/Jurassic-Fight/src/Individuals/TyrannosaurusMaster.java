package Individuals;

public class TyrannosaurusMaster extends Tyrannosaurus implements Master {

    private static TyrannosaurusMaster lUnique;
    
    private TyrannosaurusMaster(boolean gender, int energyPoints, String alliance) {
        super(gender, energyPoints, alliance);
    };

    public static TyrannosaurusMaster createUnique(boolean genre, int energyPoints, String alliance) {
        if (lUnique == null) {
            lUnique = new TyrannosaurusMaster(genre, energyPoints, alliance);
        }
        return lUnique;
    }
    
    public static TyrannosaurusMaster getInstance() {
        return lUnique;
    }

}