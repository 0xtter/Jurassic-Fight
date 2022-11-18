package individuals;

public class PterodactylusMaster extends Pterodactylus implements Master {

    private static final String SYMBOL = "#P";
    private static PterodactylusMaster lUnique;

    private PterodactylusMaster(int energyPoints) {
        super(energyPoints,SYMBOL);
    }

    public static PterodactylusMaster createUnique(int energyPoints) {
        if (lUnique == null) {
            lUnique = new PterodactylusMaster(energyPoints);
        }
        return lUnique;
    }

    public static PterodactylusMaster getInstance() {
        return lUnique;
    }

}