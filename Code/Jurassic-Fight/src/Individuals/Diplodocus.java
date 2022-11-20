package Individuals;

import Map.Map;

public abstract class Diplodocus extends Dinosaur {


    public Diplodocus(boolean gender, int energyPoints,Map map) {
        super(gender, energyPoints,map);
        super.setAllianceMadeWith(Alliance.DiplodocusMosasaurus);
    }

}