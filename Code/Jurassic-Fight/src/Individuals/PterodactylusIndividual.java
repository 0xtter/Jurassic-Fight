package Individuals;
import Map.Map;

public class PterodactylusIndividual extends Pterodactylus implements Individual {

    public PterodactylusIndividual(boolean gender, int energyPoints, Map map) {
        super(gender, energyPoints,map);
        super.setAllianceMadeWith(Alliance.PterodactylusTyrannosaurus);
    }



}