package Individuals;

public class PterodactylusIndividual extends Pterodactylus implements Individual {

    public PterodactylusIndividual(boolean gender, int energyPoints, String alliance) {
        super(gender, energyPoints, alliance);
    }

    public void move(int x, int y) {
        // TO-DO
    }

    public void meet(Dinosaur individual){

        //Si on rencontre un dinosaure du même type.
        if (individual.getTypeOfDinosaur().equals(this.getTypeOfDinosaur())){
            //Partage tous les messages.
            //System.out.println("this is " + this.getTypeOfDinosaur());
        }

        //Sinon
        else{

            //Si on rencontre un dinosaure de la même alliance.
            if (individual.getAlliance().equals(this.getTypeOfDinosaur())){
                //Génère un nombre aléatoire et échange.
            }

            //Si c'est un ennemi.
            else{
                //Génère un nombre aléatoire et engage le combat.
            }
        }
    }
}