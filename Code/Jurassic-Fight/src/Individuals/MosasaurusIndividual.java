package Individuals;

public class MosasaurusIndividual extends Mosasaurus implements Individual, Interractions {

    private static final String SYMBOL = "M";

    public MosasaurusIndividual(boolean gender, int energyPoints) {
        super(gender, energyPoints,SYMBOL);
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