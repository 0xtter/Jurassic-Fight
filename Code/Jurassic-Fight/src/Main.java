import java.util.ArrayList;

import org.apache.log4j.Logger;

import Individuals.DiplodocusIndividual;
import Individuals.MosasaurusIndividual;
import Map.Map;

public class Main {
    
    private static final Logger log = Logger.getLogger(Main.class.getName()); 
    public static void main(String[] args) throws Exception {
        DiplodocusIndividual diplo = new DiplodocusIndividual(false, 100);
        MosasaurusIndividual mosa = new MosasaurusIndividual(false, 1000);

        Map map = new Map(9,11);
        map.placeObstacle("X", 1, 1);
        map.place(mosa, 0, 0);
        map.place(diplo, 2, 3);
        map.move(mosa, 0, 1);
        map.display();

        ArrayList<Integer[]> moves = map.getAvailableMoves(0, 1);

        // for (int c=0; c < moves.size(); c++) {
        //     System.out.println("[ " + moves.get(c)[0].toString() + ", " + moves.get(c)[1].toString() + " ]");
        // }
    }
}