package Individuals;

import Map.Map;

public class DiplodocusIndividual extends Diplodocus implements Individual, Interractions {

    public DiplodocusIndividual(boolean gender, int energyPoints, Map map) {
        super(gender, energyPoints,map);
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