package Individuals;

public class MosasaurusMaster extends Mosasaurus implements Master {

    private static MosasaurusMaster lUnique;
    
    private MosasaurusMaster(boolean gender, int energyPoints, String alliance) {
        super(gender, energyPoints, alliance);
    };

    public static MosasaurusMaster createUnique(boolean genre, int energyPoints, String alliance) {
        if (lUnique == null) {
            lUnique = new MosasaurusMaster(genre, energyPoints, alliance);
        }
        return lUnique;
    }
    
    public static MosasaurusMaster getInstance() {
        return lUnique;
    }

}