import org.apache.log4j.Logger;

import Individuals.Dinosaur;
import Individuals.DiplodocusIndividual;
import Individuals.TyrannosaurusIndividual;
import Map.Map;

public class Main {
    
    private static final Logger log = Logger.getLogger(Main.class.getName()); 
    public static void main(String[] args) throws Exception {

        final int maxSteps = 10000;
        
        Integer nbLines = 10;//Forms.askForInteger(5, 20, "Saisir le nombre de la lignes de la carte (min 5, max 20)");
        Integer nbCol = 10;//Forms.askForInteger(5, 20, "Saisir le nombre de la colonnes de la carte (min 5, max 20)");

        // Pterodactylus.setAlliance(Alliance.DiplodocusMosasaurus);
        // Diplodocus.setAlliance(Alliance.PterodactylusTyrannosaurus);
        // Tyrannosaurus.setAlliance(Alliance.DiplodocusMosasaurus);
        // Mosasaurus.setAlliance(Alliance.PterodactylusTyrannosaurus);


        
        Map map = new Map(nbLines, nbCol);
        //map.populate();
        map.place(new DiplodocusIndividual(false, 100, map), 3, 4);
        map.place(new TyrannosaurusIndividual(false, 100, map), 3, 3);
        map.generateObstacles(); // TO-DO Aleatoire obstacles !!!
        map.display();


        
        Dinosaur dino1 = map.getPoint(3, 4).getDinausor();
        Dinosaur dino2 = map.getPoint(3, 3).getDinausor();

        //Set<String> messages= new HashSet<>();
        for(int i = 0; i<5;i++){
            dino1.getCollectedMessages().add(Integer.toString(i));
        }
        for(int i = 20; i<30;i++){
            dino2.getCollectedMessages().add(Integer.toString(i));
        }

        System.out.println(dino1.getCollectedMessages());
        System.out.println(dino2.getCollectedMessages());
        DiplodocusIndividual dinoCast = (DiplodocusIndividual)dino1;
        dinoCast.move(dinoCast);
        //Dinosaur.meet(dino1,dino2);

        System.out.println(dino1.getCollectedMessages() + " " +dino1.getCollectedMessages().size());
        System.out.println(dino2.getCollectedMessages() + " " +dino2.getCollectedMessages().size());

        map.display();
        

    }
}