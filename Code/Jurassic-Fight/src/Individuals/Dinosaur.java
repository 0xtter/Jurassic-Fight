package Individuals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Dinosaur extends LivingBeeing {

    private int energyPoints;
    private String symbol;
    private ArrayList<String> receivedMessages = new ArrayList<>();
    /**
     * Sét of all messages received and given from
     * other individuals of the same race.
     * No duplicates.
     */
    private Set<String> collectedMessages = new HashSet<>(receivedMessages);

    protected Dinosaur(boolean gender, int energyPoints,String symbol) {
        super(gender);
        this.energyPoints = energyPoints;
        this.symbol = symbol;
    }

    public int getEnergyPoints() {
        return this.energyPoints;
    }

    public String getSymbol(){
        return this.symbol;
    }

    public void increaseEP(int value) {
        this.energyPoints += value;
    }

    public void decreaseEP(int value) {
        this.energyPoints -= value;
    }

    public List<String> getReceivedMessages() {
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
