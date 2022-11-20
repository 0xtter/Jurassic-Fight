package Individuals;
import Map.Map;

public class TyrannosaurusIndividual extends Tyrannosaurus implements Individual {

    public TyrannosaurusIndividual(boolean gender, int energyPoints, Map map) {
        super(gender, energyPoints, map);
        super.setAllianceMadeWith(Alliance.PterodactylusTyrannosaurus);
    }




}