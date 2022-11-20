package Mechanics;
//      Linear congruent generator program.
//      seed1 = (seed0 * multiplicator + increment ) % modulus

import java.util.concurrent.ThreadLocalRandom;

// Conditions to be met to obtain the maximum period of the generator:
//      -The increment and the modulus are relatively prime: PGCD(modulus, increment) = 1
//      -The number (multiplier - 1) is a multiple of each prime number p dividing the modulus.
//      -The number (multiplier - 1) is a multiple of 4 if the module is one.

public class Random {
    private static Integer seed = 12;
    private static Integer modulus = 256; // Or 2**8 which facilitates Euclidean division.
    private static Integer multiplicator = 137; //(137-1) = 136 is a multiple of 2, only prime number dividing the modulus and a multiple of 4.
    private static Integer increment = 187; // Prime with the modulus. PGCD(187, 256) = 1.

    // The number generator offers a maximized period of 256 numbers, we decide to divide these numbers by 32 to obtain numbers
    // between 0 and 7.

    private static Random uniqueDice;

    /**
     * Create the dice.
     */
    private Random(){
    }

    public static Random createUniqueDice() {
        if (uniqueDice == null) {
            uniqueDice = new Random();
        }
        return uniqueDice;
    }

    public static Random getInstance() {
        return uniqueDice;
    }

    /**
     * Roll the dice to obtain a pseudo random number between 0 and 7.
     * @return Number between 0 and 7.
     */
    public Integer rand(){
        seed = (seed * multiplicator + increment ) % modulus;
        return(seed/32); //Bring back over a range of 0 to 7.
    }

    /**
     * Roll the dice to obtain a pseudo random number between 0 to maxInteger - 1.
     * maxInteger must be between 0 and 256.
     * @param maxInteger Maximum.
     * @return Number between 0 and maxInteger.
     * @throws Exception
     */
    public Integer randRange(Integer maxInteger) throws Exception{
        if (maxInteger<0 || maxInteger>modulus){
            throw new Exception("Please, choose a number between 0 and 256.");
        }
        else{
            // Integer randomInt = ThreadLocalRandom.current().nextInt(0, maxInteger + 1);
            // return randomInt;
            maxInteger++;
            seed = (seed * multiplicator + increment ) % modulus;
            return(seed*maxInteger/256); //Bring back over a range of 0 to .
        }
    }

    /**
     * Function that permits to change the seed and having a new set of numbers.
     * @param newSeed The new seed to generate pseudo random numbers.
     * @throws Exception
     */
    public void newSeed(Integer newSeed) throws Exception{
        if (newSeed<0 || newSeed>modulus){
            throw new Exception("Please, choose a seed between 0 and 256.");
        }
        else{
            seed = newSeed;
        }
    }

}
