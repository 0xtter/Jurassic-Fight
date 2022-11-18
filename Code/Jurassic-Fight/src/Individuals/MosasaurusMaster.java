package individuals;

public class MosasaurusMaster extends Mosasaurus implements Master {

    private static final String SYMBOL = "#M";
    private static MosasaurusMaster lUnique;
    
    private MosasaurusMaster(int energyPoints) {
        super(energyPoints,SYMBOL);
    };

    public static MosasaurusMaster createUnique(int energyPoints) {
        if (lUnique == null) {
            lUnique = new MosasaurusMaster(energyPoints);
        }
        return lUnique;
    }
    
    public static MosasaurusMaster getInstance() {
        return lUnique;
    }

}