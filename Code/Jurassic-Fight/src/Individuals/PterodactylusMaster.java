package Individuals;

public class PterodactylusMaster extends Pterodactylus implements Master {

    private static PterodactylusMaster lUnique;

    private PterodactylusMaster(boolean gender, int energyPoints) {
        super(gender, energyPoints);
    };

    public static PterodactylusMaster createUnique(boolean genre, int energyPoints) {
        if (lUnique == null) {
            lUnique = new PterodactylusMaster(genre, energyPoints);
        }
        return lUnique;
    }

    public static PterodactylusMaster getInstance() {
        return lUnique;
    }

}