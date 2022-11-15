import java.util.ArrayList;

import org.apache.log4j.Logger;

import Individuals.DiplodocusIndividual;
import Individuals.MosasaurusIndividual;
import Individuals.Tyrannosaurus;
import Individuals.TyrannosaurusIndividual;
import Map.Map;
import Map.Point;

public class Main {
    
    private static final Logger log = Logger.getLogger(Main.class.getName()); 
    public static void main(String[] args) throws Exception {

        final int maxSteps = 10000;
        
        Integer nbLines = Forms.askForInteger(5, 20, "Saisir le nombre de la lignes de la carte (min 5, max 20)");
        Integer nbCol = Forms.askForInteger(5, 20, "Saisir le nombre de la colonnes de la carte (min 5, max 20)");

        Map map = new Map(nbLines, nbCol);
        map.populate();
        map.generateObstacles(); // TO-DO Aleatoire obstacles !!!
        map.display();

        // affectation d'un message initial à tous les dinausores


        int step = 0;
        boolean pauseAtEndOfStep = true;
        String input = "";

        // rajouter en condition que la boucle s'arrete
        // quand un des master a collecté un nombre de messages
        // égal au nombre de dinaures générés.

        while (step<maxSteps) {

            // lancer les moves
            
            // point d'arret à la fin d'un step
            if (pauseAtEndOfStep) {
                input = Forms.promptEnterKey();
                // si "fin" on termine la simulation
                pauseAtEndOfStep = input.equals("fin") ? false : true;
            }
            step++;
        }
    }
}