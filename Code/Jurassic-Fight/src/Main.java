import java.util.ArrayList;

import org.apache.log4j.Logger;

import Individuals.Dinosaur;
import Individuals.DiplodocusIndividual;
import Individuals.DiplodocusMaster;
import Individuals.MosasaurusIndividual;
import Individuals.MosasaurusMaster;
import Individuals.PterodactylusIndividual;
import Individuals.PterodactylusMaster;
import Individuals.TyrannosaurusIndividual;
import Individuals.TyrannosaurusMaster;
import Map.Map;

public class Main {
    public static void main(String[] args) throws Exception {

        final int MAX_STEPS = 10000;
        boolean isGameOver = false;
        
        Integer nbLines = Forms.askForInteger(5, 30, "Saisir le nombre de la lignes de la carte (min 5, max 30)");
        Integer nbCol = Forms.askForInteger(5, 30, "Saisir le nombre de la colonnes de la carte (min 5, max 30)");

        // Pterodactylus.setAlliance(Alliance.DiplodocusMosasaurus);
        // Diplodocus.setAlliance(Alliance.PterodactylusTyrannosaurus);
        // Tyrannosaurus.setAlliance(Alliance.DiplodocusMosasaurus);
        // Mosasaurus.setAlliance(Alliance.PterodactylusTyrannosaurus);


        
        Map map = new Map(nbLines, nbCol);
        map.populate();          // populate and attribute init knowledge (except masters)
        map.generateObstacles(); // TO-DO Aleatoire obstacles !!!
        map.display();

        // safezones have the same size & masters don't have init knowledge
        final int TOTAL_NB_OF_MSG = 4 * ((int)Math.floor(map.getDiploSafeSone().size() / 2) - 1);

        int step = 0;
        boolean pauseAtEndOfStep = true;
        String input = "";
        ArrayList<Dinosaur> dinoSeen = new ArrayList<Dinosaur>();

        while (step<MAX_STEPS && !isGameOver) {

            // Begin of step
            String statestr = "";


            for(int x = 0;x<map.getShape()[0];x++){
                for(int y = 0;y<map.getShape()[1];y++){
                    Dinosaur dino = map.getPoint(x, y).getDinausor();
                    
                    if(dinoSeen.contains(dino))continue;
                    dinoSeen.add(dino);

                    // If there is a Dinausor on this point, do one move and 
                    // act according to the situation (figth, share knowledge, etc...)
                    try{
                        if(dino instanceof MosasaurusIndividual){
                            MosasaurusIndividual dinoCast = (MosasaurusIndividual) dino;
                            dinoCast.move((MosasaurusIndividual)dino);
                            statestr += String.format(
                                "%s : (%d) %s \n",
                                map.getPoint(dino).getSymbol(),
                                dinoCast.getCollectedMessages().size(),
                                dinoCast.getCollectedMessages().toString());

                        }else if(dino instanceof DiplodocusIndividual){
                            DiplodocusIndividual dinoCast = (DiplodocusIndividual) dino;
                            dinoCast.move((DiplodocusIndividual)dino);
                            statestr += String.format(
                                "%s : (%d) %s \n",
                                map.getPoint(dino).getSymbol(),
                                dinoCast.getCollectedMessages().size(),
                                dinoCast.getCollectedMessages().toString());

                        }else if(dino instanceof PterodactylusIndividual){
                            PterodactylusIndividual dinoCast = (PterodactylusIndividual) dino;
                            dinoCast.move((PterodactylusIndividual)dino);
                            statestr += String.format(
                                "%s : (%d) %s \n",
                                map.getPoint(dino).getSymbol(),
                                dinoCast.getCollectedMessages().size(),
                                dinoCast.getCollectedMessages().toString());
    
                        }else if(dino instanceof TyrannosaurusIndividual){
                            TyrannosaurusIndividual dinoCast = (TyrannosaurusIndividual) dino;
                            dinoCast.move((TyrannosaurusIndividual)dino);
                            statestr += String.format(
                                "%s : (%d) %s \n",
                                map.getPoint(dino).getSymbol(),
                                dinoCast.getCollectedMessages().size(),
                                dinoCast.getCollectedMessages().toString());

                        }
                    }catch(Exception e){
                        System.err.println("Error stepping : [ " + x+ " , " +y + " ]");
                    }
                }
            }
            
            // --> End of step
            
            // display map and state of all dinausor
            
            map.display();
            System.out.println(statestr);
            statestr = "";
            System.out.println("Master DiplodocusMaster has (knowledge):" + "[ " + DiplodocusMaster.getInstance().getCollectedMessages().size() +  " ]" + DiplodocusMaster.getInstance().getCollectedMessages().toString());
            System.out.println("Master MosasaurusMaster has (knowledge):" + "[ " + MosasaurusMaster.getInstance().getCollectedMessages().size() +  " ]" + MosasaurusMaster.getInstance().getCollectedMessages().toString());
            System.out.println("Master PterodactylusMaster has (knowledge):" + "[ " + PterodactylusMaster.getInstance().getCollectedMessages().size() +  " ]" + PterodactylusMaster.getInstance().getCollectedMessages().toString());
            System.out.println("Master TyrannosaurusMaster has (knowledge):" + "[ " + TyrannosaurusMaster.getInstance().getCollectedMessages().size() +  " ]" + TyrannosaurusMaster.getInstance().getCollectedMessages().toString());

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
            dinoSeen.removeAll(dinoSeen);
        }
    }
}