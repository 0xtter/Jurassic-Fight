import org.apache.log4j.Logger;

import Individuals.DiplodocusIndividual;

public class Main {
    
    private static final Logger log = Logger.getLogger(Main.class.getName()); 
    public static void main(String[] args) throws Exception {
        DiplodocusIndividual div = new DiplodocusIndividual(false, 100);
    }
}