package Individuals;

import Map.Map;

public class LivingBeeing {
    /**
     * 0 if female, 1 if male
     */
    private final boolean gender;
    private Map map;
    
    public Map getMap() {
        return map;
    }

    public LivingBeeing(boolean gender, Map map) {
        this.gender = gender;
        this.map = map;
    }

    public boolean getGender() {
        return this.gender;
    }
}