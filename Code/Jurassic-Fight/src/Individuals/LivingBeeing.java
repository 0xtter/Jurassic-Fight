package Individuals;

public class LivingBeeing {
    /**
     * 0 if female, 1 if male
     */
    private final boolean gender;
    
    public LivingBeeing(boolean gender) {
        this.gender = gender;
    }

    public boolean getGender() {
        return this.gender;
    }
}