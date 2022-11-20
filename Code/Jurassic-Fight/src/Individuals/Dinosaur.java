package Individuals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Map.Map;
import Mechanics.Random;

public abstract class Dinosaur extends LivingBeeing {

    private int energyPoints;
    private Alliance allianceMadeWith;

    public abstract void introduiceMyself();

    public Alliance getAllianceMadeWith() {
        return allianceMadeWith;
    }

    public void setAllianceMadeWith(Alliance allianceMadeWith) {
        this.allianceMadeWith = allianceMadeWith;
    }

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

    /**
     * Lors d'une rencontre d'individus d'une même race,
     * partage des connaissances.
     * @param collectedMessagesFromAnotherIndividual
     */
    public void collectMessages(Set<String> collectedMessagesFromAnotherIndividual, Integer number) {
        System.out.println("Exchanging " + number + " messages.");
        List<String> stringsList = new ArrayList<>(collectedMessagesFromAnotherIndividual);
        for(int i=0;i<number;i++){
            this.getCollectedMessages().add(stringsList.get(i));
        }
    }

    /**
     * 
     * @param dice The pseudo random number generator.
     * @return A boolean for the win or teh loose.
     * @throws Exception
     */
    public Boolean fight() throws Exception{

        if (Random.getInstance().randRange(100) > Random.getInstance().randRange(100)){
            return(true);
        }
        else{
            return(false);
        }
    }

    public static void meet(Dinosaur that, Dinosaur other) throws Exception {
        //If encounter a dinosaur in the same alliance.
        if (that.getAllianceMadeWith().equals(other.getAllianceMadeWith())){
            if(that.getClass() == other.getClass()){//Same dino class
                other.collectMessages(that.getCollectedMessages());
                that.collectMessages(other.getCollectedMessages());
                return;
            }
            //Which number of messages to exchange ?
            Integer numberToExchangeBetweenAlly = 0;

            if (that.getCollectedMessages().size() >= other.getCollectedMessages().size()){
                numberToExchangeBetweenAlly = Random.getInstance().randRange(other.getCollectedMessages().size() + 1);
            }
            else{
                numberToExchangeBetweenAlly = Random.getInstance().randRange(that.getCollectedMessages().size() + 1);
            }
            //Exchange the messages between ally dinosaurs if they have something to exchange..
            other.collectMessages(that.getCollectedMessages(), numberToExchangeBetweenAlly);
            that.collectMessages(other.getCollectedMessages(), numberToExchangeBetweenAlly);
        }
        
        //If encounter an ennemy.
        else{
            
            //Get the messages in common between attacker and defender.
            Set<String> union = new HashSet<>();
            union.addAll(that.getCollectedMessages());
            Set<String> complement = new HashSet<>();
            union.retainAll(other.getCollectedMessages());

            //If the attacker wins.
            if (that.fight()){
                Integer numberOfMessagesEnnemyHaveNot = other.getCollectedMessages().size() - union.size();
                complement.addAll(other.getCollectedMessages());
                complement.removeAll(union);
                that.collectMessages(complement, Random.getInstance().randRange(numberOfMessagesEnnemyHaveNot + 1));
            }

            //If the defender wins.
            else{
                Integer numberOfMessagesEnnemyHaveNot = that.getCollectedMessages().size() - union.size();
                complement.addAll(that.getCollectedMessages());
                complement.removeAll(union);
                other.collectMessages(complement, Random.getInstance().randRange(numberOfMessagesEnnemyHaveNot + 1));
            }
        }
    }

    public static void meet(Dinosaur that, DiplodocusMaster diplodocusM) throws Exception {
        diplodocusM.collectMessages(that.getCollectedMessages());
        that.getCollectedMessages().clear(); // Delete the messages of the individual to not share it
        // with ennemies when exit from safezone.
    }

    /**
     * If encounter a master of the same race, the individual gives all its knowledge to the master.
     * @param pterodactylusM the master i meet in safezone.
     * @param Random.getInstance() The pseudo random generator number.
     * @throws Exception
     */
    public static void meet(Dinosaur that, PterodactylusMaster pterodactylusM) throws Exception {
        pterodactylusM.collectMessages(that.getCollectedMessages());
        that.getCollectedMessages().clear(); // Delete the messages of the individual to not share it with ennemies in the future.
    }

    /**
     * If encounter a master of the same race, the individual gives all its knowledge to the master.
     * @param tyrannosaurusM the master i meet in safezone.
     * @param Random.getInstance() The pseudo random generator number.
     * @throws Exception
     */
    public static void meet(Dinosaur that,TyrannosaurusMaster tyrannosaurusM) throws Exception {
        tyrannosaurusM.collectMessages(that.getCollectedMessages());
        that.getCollectedMessages().clear(); // Delete the messages of the individual to not share it with ennemies in the future.
    }
    /**
     * If encounter a master of the same race, the individual gives all its knowledge to the master.
     * @param mosasaurusM the master i meet in safezone.
     * @param Random.getInstance() The pseudo random generator number.
     * @throws Exception
     */
    public static void meet(Dinosaur that, MosasaurusMaster mosasaurusM) throws Exception {
        mosasaurusM.collectMessages(that.getCollectedMessages());
        that.getCollectedMessages().clear(); // Delete the messages of the individual to not share it with ennemies in the future.
    }

}
