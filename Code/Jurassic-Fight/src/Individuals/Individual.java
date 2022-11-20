package Individuals;

import java.util.ArrayList;
import java.util.Random;

import Map.Point;

public interface Individual {

    public static int maxKnowledge = 10;
    public static int minEnergyBeforeTired = 30;
    public static int maxEnergyAfterRest = 80;
    public static int movementCost = 2;
    public static int restAmount = 10;

    private int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    static ArrayList<Integer[]> determinePath(Point initialPosition, Integer[] finalPosition) {
        System.out.println("Initial pos : " + "[ " + initialPosition.getX() + ", " + initialPosition.getY() + " ]"
                + " | final position : " + "[ " + finalPosition[0].toString() + ", " + finalPosition[1].toString()
                + " ]");
        Integer movesX = finalPosition[0] - initialPosition.getX();
        Integer movesY = finalPosition[1] - initialPosition.getY();
        Integer signX = movesX / Math.abs(movesX);
        Integer signY = movesY / Math.abs(movesY);

        System.out.println("diffX = " + movesX);
        System.out.println("diffY = " + movesY);

        ArrayList<Integer[]> path = new ArrayList<Integer[]>();
        if (Math.abs(movesX) > Math.abs(movesY)) {
            for (int x = 0; x < Math.abs(movesX); x++) {
                path.add(new Integer[] { signX, 0 });
            }
            for (int y = 0; y < Math.abs(movesY); y++) {
                path.add(new Integer[] { 0, signY });
            }
        } else {
            for (int y = 0; y < Math.abs(movesY); y++) {
                path.add(new Integer[] { 0, signY });
            }
            for (int x = 0; x < Math.abs(movesX); x++) {
                path.add(new Integer[] { signX, 0 });
            }
        }
        return path;
    }

    private Dinosaur step(Dinosaur dino, Integer[] nextPos) throws Exception {
        // Get position of dino
        Point initialPosition = new Point(0, 0);
        Point nextPoint = dino.getMap().getPoint(nextPos[0], nextPos[1]);

        try {
            initialPosition = dino.getMap().getPoint(dino);
        } catch (Exception e) {
            throw new Exception("Something went wrong stepping dinosaur");
        }

        if (nextPoint.isFree()) {
            try {
                if (dino instanceof MosasaurusIndividual) {nextPoint.placeDinausor((MosasaurusIndividual) dino);
                } else if (dino instanceof DiplodocusIndividual) {nextPoint.placeDinausor((DiplodocusIndividual) dino);
                } else if (dino instanceof PterodactylusIndividual) {nextPoint.placeDinausor((PterodactylusIndividual) dino);
                } else if (dino instanceof TyrannosaurusIndividual) {nextPoint.placeDinausor((TyrannosaurusIndividual) dino);}
            } catch (Exception e) {
                System.err.println("Error stepping dino");
            }
            nextPoint.setSymbol(initialPosition.getSymbol());
            initialPosition.free();

            if (dino.getMap().isPointInSafeZone(initialPosition)) {
                initialPosition.setSymbol("~~");
            }

            try {
                return dino.getMap().getPoint(nextPoint.getX(), nextPoint.getY()).getDinausor();
            } catch (Exception e) {
                System.err.println(e);
            }
        } else if (nextPoint.isAnObstacle())
            throw new Exception("Encountered a obstacle");
        else if (nextPoint.getDinausor() != null) {
            if (dino.getMap().isPointInSafeZone(initialPosition))
                throw new Exception("Encountered a dinosaur in safe zone");

            Dinosaur otherDino = nextPoint.getDinausor();

            // if(otherDino instanceof Master && otherDino.getClass()== )
            throw new Exception("Encountered a dinosaur");
        } else
            System.out.println("Unknown entity encoutered during movement...");
        return dino;
    }

    public default void move(Dinosaur dino) {

        Point initialPosition = new Point(0, 0);
        Integer[] finalPosition = new Integer[]{0,0};
        ArrayList<Integer[]> moves = new ArrayList<Integer[]>();

        try {
            initialPosition = dino.getMap().getPoint(dino);
        } catch (Exception e) {
            System.out.println("Cannot get dinosaur");
            return;
        }


        if (dino.getEnergyPoints() == 0) {
            System.out.println("Cannot move not enough EP");
            // DIE
            return;
        }else if(dino.getMap().isPointInSafeZone(initialPosition) & dino.getEnergyPoints()<Individual.maxEnergyAfterRest){
            dino.increaseEP(Individual.restAmount);
            return;
        }else if (dino.getCollectedMessages().size() >= Individual.maxKnowledge
                || dino.getEnergyPoints() <= Individual.minEnergyBeforeTired) {
                    try{
                        if (dino instanceof MosasaurusIndividual) {finalPosition = dino.getMap().getDirectionToSafeZone((MosasaurusIndividual)dino);
                        } else if (dino instanceof DiplodocusIndividual) {finalPosition = dino.getMap().getDirectionToSafeZone((DiplodocusIndividual)dino);
                        } else if (dino instanceof PterodactylusIndividual) {finalPosition = dino.getMap().getDirectionToSafeZone((PterodactylusIndividual)dino);
                        } else if (dino instanceof TyrannosaurusIndividual) {finalPosition = dino.getMap().getDirectionToSafeZone((TyrannosaurusIndividual)dino);}
                    }catch(Exception e){
                        System.out.println("Something went wrong");
                    }
                    if(finalPosition.length == 0){return;}
        } else {
            try {
                // Get possible moves for dino
                moves = dino.getMap().getAvailableMoves(initialPosition.getX(), initialPosition.getY());

                System.out.println("Possible next positions:");
                for (int c = 0; c < moves.size(); c++) {
                    System.out.println("[ " + moves.get(c)[0].toString() + ", " + moves.get(c)[1].toString() + " ]");
                }
            } catch (Exception e) {
                System.out.println("Error getting moves");
                // Something happenned
            }
            if (moves.size() == 0) return;

            finalPosition = moves.get(this.getRandomNumberInRange(0, moves.size() - 1));
            System.out.println("Choosed direction : " + "[ " + finalPosition[0].toString() + ", "
                    + finalPosition[1].toString() + " ]");
        }

        // Calculate the tiles the dino will step on
        ArrayList<Integer[]> path = determinePath(initialPosition, finalPosition);
        for (Integer[] step : path) {
            System.out.println("[ " + step[0] + " , " + step[1] + " ]");
        }

        // Step on each tile of the path checking if he encounters a dino
        for (Integer[] step : path) {
            System.out.println("Stepping by " + "[ " + step[0] + " , " + step[1] + " ]");
            Dinosaur oldDino = dino;
            try {
                dino = this.step(dino, new Integer[] { step[0] + dino.getMap().getPoint(dino).getX(),
                        step[1] + dino.getMap().getPoint(dino).getY() });
                dino.decreaseEP(Individual.movementCost);
            } catch (Exception e) {
                dino = oldDino;
                break;
            }
        }

    }

}