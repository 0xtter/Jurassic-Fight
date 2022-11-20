import java.util.ArrayList;

import org.apache.log4j.Logger;

import Individuals.Dinosaur;
import Individuals.DiplodocusIndividual;
import Individuals.DiplodocusMaster;
import Individuals.MosasaurusIndividual;
import Individuals.MosasaurusMaster;
import Individuals.PterodactylusIndividual;
import Individuals.PterodactylusMaster;
import Individuals.Tyrannosaurus;
import Individuals.TyrannosaurusIndividual;
import Individuals.TyrannosaurusMaster;
import Map.Map;
import Map.Point;

public class Main {
    
    private static final Logger log = Logger.getLogger(Main.class.getName()); 
    public static void main(String[] args) throws Exception {

        final int MAX_STEPS = 10000;
        boolean isGameOver = false;
        
        Integer nbLines = Forms.askForInteger(5, 30, "Saisir le nombre de la lignes de la carte (min 5, max 30)");
        Integer nbCol = Forms.askForInteger(5, 30, "Saisir le nombre de la colonnes de la carte (min 5, max 30)");

        Map map = new Map(nbLines, nbCol);
        map.populate();          // populate and attribute init knowledge (except masters)
        map.generateObstacles(); // TO-DO Aleatoire obstacles !!!
        map.display();

        // safezones have the same size & masters don't have init knowledge
        final int TOTAL_NB_OF_MSG = 4 * (map.getDiploSafeSone().size() - 1);

        int step = 0;
        boolean pauseAtEndOfStep = true;
        String input = "";

        while (step<MAX_STEPS && !isGameOver) {

            // Begin of step
            String statestr = "";

            for(int x = 0;x<map.getShape()[0];x++){
                for(int y = 0;y<map.getShape()[1];y++){

                    Dinosaur dino = map.getPoint(x, y).getDinausor();

                    // If there is a Dinausor on this point, do one move and 
                    // act according to the situation (figth, share knowledge, etc...)
                    try{
                        if(dino instanceof MosasaurusIndividual){
                            System.out.println(map.getPoint(x, y).toString());
                            MosasaurusIndividual dinoCast = (MosasaurusIndividual) dino;
                            dinoCast.move((MosasaurusIndividual)dino);
                            statestr += String.format(
                                "%s : (%d) %s \n",
                                map.getPoint(x, y).getSymbol(),
                                dinoCast.getCollectedMessages().size(),
                                dinoCast.getCollectedMessages().toString());

                        }else if(dino instanceof DiplodocusIndividual){
                            System.out.println(map.getPoint(x, y).toString());
                            DiplodocusIndividual dinoCast = (DiplodocusIndividual) dino;
                            dinoCast.move((DiplodocusIndividual)dino);
                            statestr += String.format(
                                "%s : (%d) %s \n",
                                map.getPoint(x, y).getSymbol(),
                                dinoCast.getCollectedMessages().size(),
                                dinoCast.getCollectedMessages().toString());

                        }else if(dino instanceof PterodactylusIndividual){
                            System.out.println(map.getPoint(x, y).toString());
                            PterodactylusIndividual dinoCast = (PterodactylusIndividual) dino;
                            dinoCast.move((PterodactylusIndividual)dino);
                            statestr += String.format(
                                "%s : (%d) %s \n",
                                map.getPoint(x, y).getSymbol(),
                                dinoCast.getCollectedMessages().size(),
                                dinoCast.getCollectedMessages().toString());
    
                        }else if(dino instanceof TyrannosaurusIndividual){
                            System.out.println(map.getPoint(x, y).toString());
                            TyrannosaurusIndividual dinoCast = (TyrannosaurusIndividual) dino;
                            dinoCast.move((TyrannosaurusIndividual)dino);
                            statestr += String.format(
                                "%s : (%d) %s \n",
                                map.getPoint(x, y).getSymbol(),
                                dinoCast.getCollectedMessages().size(),
                                dinoCast.getCollectedMessages().toString());

                        }
                    }catch(Exception e){
                        System.err.println("Error stepping dino");
                    }
                }
            }
            
            // --> End of step

            // display map and state of all dinausor

            map.display();
            System.out.println(statestr);
            statestr = "";

            // Check if game is over

            int masterDknowall = Integer.compare(TOTAL_NB_OF_MSG, DiplodocusMaster.getInstance().getCollectedMessages().size());
            int masterTknowall = Integer.compare(TOTAL_NB_OF_MSG, TyrannosaurusMaster.getInstance().getCollectedMessages().size());
            int masterMknowall = Integer.compare(TOTAL_NB_OF_MSG, MosasaurusMaster.getInstance().getCollectedMessages().size());
            int masterPknowall = Integer.compare(TOTAL_NB_OF_MSG, PterodactylusMaster.getInstance().getCollectedMessages().size());

            if (masterDknowall == 0) {
                isGameOver = true;
                System.out.println("Gagnants : Diplodocus");
                System.exit(0);
            } else if (masterTknowall == 0) {
                isGameOver = true;
                System.out.println("Gagnants : Tyrannosaurus");
                System.exit(0);
            } else if (masterMknowall == 0) {
                isGameOver = true;
                System.out.println("Gagnants : Mosasaurus");
                System.exit(0);
            } else if (masterPknowall == 0) {
                isGameOver = true;
                System.out.println("Gagnants : Pterodactylus");
                System.exit(0);
            }

            // Press Enter to continue or type "finir" to continue without breaks

            if (pauseAtEndOfStep) {
                input = Forms.promptEnterKey();
                // si "finir" on termine la simulation
                pauseAtEndOfStep = input.equals("finir") ? false : true;
            }
            step++;
        }
    }
}