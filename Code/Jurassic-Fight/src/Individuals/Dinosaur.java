package Individuals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public abstract class Dinosaur extends LivingBeeing {

    private int energyPoints;
    private ArrayList<String> receivedMessages;
    /**
     * Sét of all messages received and given from
     * other individuals of the same race.
     * No duplicates.
     */
    private Set<String> collectedMessages = new HashSet<>(receivedMessages);

    public Dinosaur(boolean gender, int EP) {
        super(gender);
        this.energyPoints = EP;
    }

    public int getEnergyPoints() {
        return this.energyPoints;
    }

    public abstract String getTypeOfDinosaur();

    public abstract String getAlliance();

    public void increaseEP(int value) {
        this.energyPoints += value;
    }

    public void decreaseEP(int value) {
        this.energyPoints -= value;
    }

    public ArrayList<String> getReceivedMessages() {
        return this.receivedMessages;
    }

    /**
     * Sauvegarde un message recu dans une liste
     * de messages personnellement recus, et à un ensemble
     * de tous les messages connus de l'individu.
     * @param msg
     */
    public void storeReceivedMsg(String msg) {
        this.receivedMessages.add(msg);
        this.collectedMessages.add(msg);
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
