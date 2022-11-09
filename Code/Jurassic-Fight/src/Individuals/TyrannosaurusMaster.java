package Individuals;

public class TyrannosaurusMaster extends Dinosaur implements Master {

    private static TyrannosaurusMaster lUnique;
    
    private TyrannosaurusMaster(boolean gender, int energyPoints) {
        super(gender, energyPoints);
    };

    public static TyrannosaurusMaster createUnique(boolean genre, int energyPoints) {
        if (lUnique == null) {
            lUnique = new TyrannosaurusMaster(genre, energyPoints);
        }
        return lUnique;
    }
    
    public static TyrannosaurusMaster getInstance() {
        return lUnique;
    }

}