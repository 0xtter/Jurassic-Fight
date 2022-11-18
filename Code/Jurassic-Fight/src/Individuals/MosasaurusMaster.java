package Individuals;

public class MosasaurusMaster extends Mosasaurus implements Master {

    private static final String SYMBOL = "#M";
    private static MosasaurusMaster lUnique;
    
    private MosasaurusMaster(boolean gender, int energyPoints) {
        super(gender, energyPoints,SYMBOL);
    };

    public static MosasaurusMaster createUnique(boolean genre, int energyPoints) {
        if (lUnique == null) {
            lUnique = new MosasaurusMaster(genre, energyPoints);
        }
        return lUnique;
    }
    
    public static MosasaurusMaster getInstance() {
        return lUnique;
    }

}