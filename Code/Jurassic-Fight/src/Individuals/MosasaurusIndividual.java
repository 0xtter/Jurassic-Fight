package Individuals;

import Map.Map;

public class MosasaurusIndividual extends Mosasaurus implements Individual, Interractions {

    public MosasaurusIndividual(boolean gender, int energyPoints, Map map) {
        super(gender, energyPoints, map);
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
    //     if (individual instanceof Mosasaurus){
    //         //Partage tous les messages.
    //         //System.out.println("this is " + this.getTypeOfDinosaur());

    //         // fonction de partage deja faites par Daniel, voir Dinausor.java
    //     }

    //     //Sinon
    //     else{

    //         //Si le dino est notre allié
    //         if (individual.getAlliance() == Race.Mosasaurus )){
    //             //Génère un nombre aléatoire et échange.
    //         }

    //         //Si c'est un ennemi.
    //         else{
    //             //Génère un nombre aléatoire et engage le combat.
    //         }
    //     }
    // }

}