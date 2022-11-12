package Mechanics;
import java.util.Random ;

public class Random {
    public  int randomMove() # random number from 0 to 7 to deterine the destination
    {    
        Random random = new Random();
        int i = random.nextInt(7); 
        return i ;
    }

    

    
}
