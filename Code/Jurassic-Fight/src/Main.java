import java.util.ArrayList;

import org.apache.log4j.Logger;

import Individuals.Dinosaur;
import Individuals.DiplodocusIndividual;
import Individuals.MosasaurusIndividual;
import Individuals.PterodactylusIndividual;
import Individuals.Tyrannosaurus;
import Individuals.TyrannosaurusIndividual;
import Map.Map;
import Map.Point;

public class Main {
    
    private static final Logger log = Logger.getLogger(Main.class.getName()); 
    public static void main(String[] args) throws Exception {

        final int maxSteps = 10000;
        
        Integer nbLines = 10;//Forms.askForInteger(5, 20, "Saisir le nombre de la lignes de la carte (min 5, max 20)");
        Integer nbCol = 10;//Forms.askForInteger(5, 20, "Saisir le nombre de la colonnes de la carte (min 5, max 20)");

        Map map = new Map(nbLines, nbCol);
        //map.populate();
        map.place(new PterodactylusIndividual(false, 80, map), 2, 2);
        map.generateObstacles(); // TO-DO Aleatoire obstacles !!!
        map.display();
        
        Dinosaur dino = map.getPoint(2, 2).getDinausor();
        try{            
            if(dino instanceof MosasaurusIndividual){
                MosasaurusIndividual dinoCast = (MosasaurusIndividual) dino;
                dinoCast.move((MosasaurusIndividual)dino);
            }else if(dino instanceof DiplodocusIndividual){
                DiplodocusIndividual dinoCast = (DiplodocusIndividual) dino;
                dinoCast.move((DiplodocusIndividual)dino);
            }else if(dino instanceof PterodactylusIndividual){
                PterodactylusIndividual dinoCast = (PterodactylusIndividual) dino;
                dinoCast.move((PterodactylusIndividual)dino);
            }else if(dino instanceof TyrannosaurusIndividual){
                TyrannosaurusIndividual dinoCast = (TyrannosaurusIndividual) dino;
                dinoCast.move((TyrannosaurusIndividual)dino);
            }else{
                System.out.println("Error");
            }
        }catch(Exception e){
            System.err.println("Error stepping dino");
        }
        for(int x = 0;x<map.getShape()[0];x++){
            for(int y = 0;y<map.getShape()[0];y++){
            }
        }

        map.display();
        System.out.println(dino.getEnergyPoints());
        

    }
}