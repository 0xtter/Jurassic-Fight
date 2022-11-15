package Individuals;

import java.util.ArrayList;
import java.util.Random;

import Map.Map;
import Map.Point;

public interface Individual {

    static int maxKnowledge = 10;
    

    private int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

    static ArrayList<Integer[]> determinePath(Point initialPosition, Integer[] finalPosition){
        System.out.println("Initial pos : " + "[ " + initialPosition.getX() + ", " + initialPosition.getY() + " ]" + " | final position : " + "[ " + finalPosition[0].toString() + ", " + finalPosition[1].toString() + " ]");
        Integer movesX = finalPosition[1]-initialPosition.getX();
        Integer movesY = finalPosition[0]-initialPosition.getY();
        Integer signX = movesX/Math.abs(movesX);
        Integer signY = movesY/Math.abs(movesY);

        
        System.out.println("diffX = " + movesX);
        System.out.println("diffY = " + movesY);
        
        ArrayList<Integer[]> path = new ArrayList<Integer[]>();
        if(Math.abs(movesX) > Math.abs(movesY)){
            for(int x = 0; x < Math.abs(movesX);x++){
                path.add( new Integer[]{signX,0} );
            }
            for(int y = 0; y < Math.abs(movesY);y++){
                path.add( new Integer[]{0,signY} );
            }
        }else{
            for(int y = 0; y < Math.abs(movesY);y++){
                path.add( new Integer[]{0,signY} );
            }
            for(int x = 0; x < Math.abs(movesX);x++){
                path.add( new Integer[]{signX,0} );
            }
        }
        return path;
    }
    
    public default void move(Dinosaur dino) {

        if (dino.getEnergyPoints() <= 40){
            System.out.println("Cannot move not enough EP");
            //DIE
        }else if(dino.getCollectedMessages().size() >= Individual.maxKnowledge){
            System.out.println("All the knowledge has been acquired, moving to base");
            //MOVE TO BASE
        }else{
            try{
                //Get position of dino
                Point initialPosition =  dino.getMap().getPoint(dino);
                //Get possible moves for dino
                ArrayList<Integer[]> moves = dino.getMap().getAvailableMoves(initialPosition.getX(),initialPosition.getY());
                
                System.out.println("Possible next positions:");
                for (int c=0; c < moves.size(); c++) {
                    System.out.println("[ " + moves.get(c)[0].toString() + ", " + moves.get(c)[1].toString() + " ]");
                }
                
                //Choose a random final position
                Integer[] finalPosition = moves.get(this.getRandomNumberInRange(0, moves.size()-1));
                System.out.println("Choosed direction : " + "[ " + finalPosition[0].toString() + ", " + finalPosition[1].toString() + " ]");

                //Calculate the tiles the dino will step on
                ArrayList<Integer[]> path = determinePath(initialPosition, finalPosition);
                for(Integer[] step : path){
                    System.out.println("[ " + step[0] + " , " +  step[1] + " ]");
                }


            }catch(Exception e){
                new Exception("Something went wrong");
            }
        }

    }

}