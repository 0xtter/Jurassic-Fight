package Individuals;

import java.util.HashSet;
import java.util.Set;

import Map.Map;

public abstract class Dinosaur extends LivingBeeing {

    private int energyPoints;
    

    /**
     * Set of all messages received and given from
     * other individuals of the same race.
     * No duplicates.
     */
    private Set<String> collectedMessages = new HashSet<>();

    public Set<String> getCollectedMessages() {
        return collectedMessages;
    }

    public Dinosaur(boolean gender, int EP, Map map) {
        super(gender,map);
        this.energyPoints = EP;
    }

    public int getEnergyPoints() {
        return this.energyPoints;
    }

    public void increaseEP(int value) {
        this.energyPoints += value;
    }

    public void decreaseEP(int value) {
        this.energyPoints -= value;
    }

    /**
     * Lors d'une rencontre d'individus d'une même race,
     * partage des connaissances.
     * @param collectedMessagesFromAnotherIndividual
     */
    public void collectMessages(Set<String> collectedMessagesFromAnotherIndividual) {
        this.collectedMessages.addAll(collectedMessagesFromAnotherIndividual);
    }

}
