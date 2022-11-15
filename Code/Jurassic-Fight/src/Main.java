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
    }
}