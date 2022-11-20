package Individuals;
import Map.Map;

public class MosasaurusIndividual extends Mosasaurus implements Individual {

    public MosasaurusIndividual(boolean gender, int energyPoints, Map map) {
        super(gender, energyPoints,map);
        super.setAllianceMadeWith(Alliance.DiplodocusMosasaurus);
    }

    @Override
    public void introduiceMyself() {
        System.out.println("I am a Mosasaurus Individual !");
    }

}