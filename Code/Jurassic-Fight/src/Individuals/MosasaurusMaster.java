package Individuals;

import Map.Map;

public class MosasaurusMaster extends Mosasaurus implements Master {

    private static MosasaurusMaster lUnique;
    
    private MosasaurusMaster(boolean gender, int energyPoints, Map map) {
        super(gender, energyPoints,map);
    };

    public static MosasaurusMaster createUnique(boolean genre, int energyPoints, Map map) {
        if (lUnique == null) {
            lUnique = new MosasaurusMaster(genre, energyPoints,map);
        }
        return lUnique;
    }
    
    public static MosasaurusMaster getInstance() {
        return lUnique;
    }

    @Override
    public void introduiceMyself() {
        System.out.println("I am a Mosasaurus Master !");
    }

}