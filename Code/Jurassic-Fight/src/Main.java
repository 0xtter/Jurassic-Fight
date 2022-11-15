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
        Map map = new Map(9,11);

        DiplodocusIndividual diplo = new DiplodocusIndividual(false, 100,map);
        MosasaurusIndividual mosa = new MosasaurusIndividual(false, 100,map);
        TyrannosaurusIndividual tyra = new TyrannosaurusIndividual(false, 100, map);

        map.placeObstacle("X", 1, 1);
        map.place(mosa, 0, 0);
        map.place(diplo, 2, 3);
        map.place(tyra, 1, 4);
        map.move(mosa, 5, 5);
        map.display();

        /**
         * Get Dinousors around a point (utile pour savoir détecter un combat)
         */

        ArrayList<Point> dino = map.getDinausorsAround(2, 3);

        System.out.println("\nDino next to (2, 3) :");
        for (int c=0; c < dino.size(); c++) {
            System.out.println(dino.get(c).toString());
        }
        System.out.println("");

        mosa.move(mosa);
        /**
         * get direction to safezone
         */

        Integer safezoneMove[] = map.getDirectionToSafeZone(diplo);

        //System.out.println("[ " + safezoneMove[0].toString() + ", " + safezoneMove[1].toString() + " ]");
    }
}