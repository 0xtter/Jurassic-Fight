import java.util.List;
import org.apache.log4j.Logger;

import individuals.*;
import map.*;
import mechanics.*;

public class Main {
    
    private static final Logger log = Logger.getLogger(Main.class.getName()); 
    public static void main(String[] args) throws Exception {
        DiplodocusIndividual diplo = new DiplodocusIndividual(100);
        MosasaurusIndividual mosa = new MosasaurusIndividual(100);
        TyrannosaurusIndividual tyra = new TyrannosaurusIndividual(100);
        PterodactylusIndividual ptero = new PterodactylusIndividual(100);
        diplo.setAlliance(Race.Mosasaurus);
        mosa.setAlliance(Race.Diplodocus);
        tyra.setAlliance(Race.Pterodactylus);
        ptero.setAlliance(Race.Tyrannosaurus);


        Map map = new Map(9,11);
        map.placeObstacle("X", 1, 1);
        map.place(mosa, 0, 0);
        map.place(diplo, 2, 3);
        map.place(tyra, 1, 4);
        map.move(mosa, 0, 1);
        map.display();

        /**
         * Get Dinousors around a point (utile pour savoir détecter un combat)
         */

        List<Point> dino = map.getDinausorsAround(2, 3);

        System.out.println("\nDino next to (2, 3) :");
        for (int c=0; c < dino.size(); c++) {
            System.out.println(dino.get(c).toString());
        }
        System.out.println("");

        /**
         * Get available Points next to a point
         */
        
        List<Integer[]> moves = map.getAvailableMoves(0, 1);

        System.out.println("Possible next moves from point (0, 1) :");
        for (int c=0; c < moves.size(); c++) {
            System.out.println("[ " + moves.get(c)[0].toString() + ", " + moves.get(c)[1].toString() + " ]");
        }
        System.out.println("");

        /**
         * get direction to safezone
         */

        Integer safezoneMove[] = map.getDirectionToSafeZone(diplo);

        Random de = new Random();
        System.out.println(de.rand());
        System.out.println(de.randRange(100));
        
        

        //System.out.println("[ " + safezoneMove[0].toString() + ", " + safezoneMove[1].toString() + " ]");
    }
    
}