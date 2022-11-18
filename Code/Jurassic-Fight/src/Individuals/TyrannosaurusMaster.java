package Individuals;

public class TyrannosaurusMaster extends Tyrannosaurus implements Master {

    private static final String SYMBOL = "#T";

    private static TyrannosaurusMaster lUnique;
    
    private TyrannosaurusMaster(boolean gender, int energyPoints) {
        super(gender, energyPoints,SYMBOL);
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