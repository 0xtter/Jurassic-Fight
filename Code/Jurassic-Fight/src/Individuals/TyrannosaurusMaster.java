package individuals;

public class TyrannosaurusMaster extends Tyrannosaurus implements Master {

    private static final String SYMBOL = "#T";

    private static TyrannosaurusMaster lUnique;
    
    private TyrannosaurusMaster(int energyPoints) {
        super(energyPoints,SYMBOL);
    }

    public static TyrannosaurusMaster createUnique(int energyPoints) {
        if (lUnique == null) {
            lUnique = new TyrannosaurusMaster(energyPoints);
        }
        return lUnique;
    }
    
    public static TyrannosaurusMaster getInstance() {
        return lUnique;
    }

}