package Individuals;

public class PterodactylusMaster extends Pterodactylus implements Master {

    private static PterodactylusMaster lUnique;
    
    private PterodactylusMaster(boolean gender, int energyPoints, String alliance) {
        super(gender, energyPoints, alliance);
    };

    public static PterodactylusMaster createUnique(boolean genre, int energyPoints, String alliance) {
        if (lUnique == null) {
            lUnique = new PterodactylusMaster(genre, energyPoints, alliance);
        }
        return lUnique;
    }
    
    public static PterodactylusMaster getInstance() {
        return lUnique;
    }

}