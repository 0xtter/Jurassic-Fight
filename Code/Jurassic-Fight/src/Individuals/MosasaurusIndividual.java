package individuals;

public class MosasaurusIndividual extends Mosasaurus implements Individual, Interractions {

    private static final String SYMBOL = "M";

    public MosasaurusIndividual(int energyPoints) {
        super(energyPoints,SYMBOL);
    }

    public void move(int x, int y) {
        // TO-DO
    }

    public void meet(DiplodocusIndividual diplodocusI) {
        // TO-DO
    }

    public void meet(DiplodocusMaster diplodocusM) {
        // TO-DO
    }

    public void meet(PterodactylusIndividual pterodactylusI) {
        // TO-DO
    }

    public void meet(PterodactylusMaster pterodactylusM) {
        // TO-DO
    }

    public void meet(MosasaurusIndividual mosasaurusI) {
        // TO-DO
    }

    public void meet(MosasaurusMaster mosasaurusM) {
        // TO-DO
    }

}