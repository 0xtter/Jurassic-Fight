package Individuals;

public class TyrannosaurusIndividual extends Tyrannosaurus implements Individual, Interractions {

    public TyrannosaurusIndividual(boolean gender, int energyPoints) {
        super(gender, energyPoints);
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

    // public void meet(Dinosaur individual){

    //     //Si on rencontre un dinosaure du même type.
    //     if (individual.getTypeOfDinosaur().equals(this.getTypeOfDinosaur())){
    //         //Partage tous les messages.
    //         //System.out.println("this is " + this.getTypeOfDinosaur());
    //     }

    //     //Sinon
    //     else{

    //         //Si on rencontre un dinosaure de la même alliance.
    //         if (individual.getAlliance().equals(this.getTypeOfDinosaur())){
    //             //Génère un nombre aléatoire et échange.
    //         }

    //         //Si c'est un ennemi.
    //         else{
    //             //Génère un nombre aléatoire et engage le combat.
    //         }
    //     }
    // }

}