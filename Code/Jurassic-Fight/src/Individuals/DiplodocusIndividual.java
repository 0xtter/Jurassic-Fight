package Individuals;
import Map.Map;

public class DiplodocusIndividual extends Diplodocus implements Individual {

    public DiplodocusIndividual(boolean gender, int energyPoints,Map map) {
        super(gender, energyPoints,map);
    }

    @Override
    public void introduiceMyself() {
        System.out.println("I am a Diplodocus Individual !");
    }

    // /**
    //  * If encounter a dinosaur of same population, make union of all the knowledge.
    //  */
    // public void meet(DiplodocusIndividual diplodocusI) throws Exception {
    //     diplodocusI.collectMessages(this.getCollectedMessages());
    //     this.collectMessages(diplodocusI.getCollectedMessages());
    // }

    // /**
    //  * If encounter a master of the same race, the individual gives all its knowledge to the master.
    //  * @param diplodocusM the master i meet in safezone.
    //  * @param dice The pseudo random generator number.
    //  * @throws Exception
    //  */


    
    // public void meet(PterodactylusIndividual pterodactylusI) throws Exception {
        

    //     //If encounter a dinosaur in the same alliance.
    //     if (Diplodocus.getAlliance().equals(Pterodactylus.getAlliance())){

    //         //Which number of messages to exchange ?
    //         Integer numberToExchangeBetweenAlly = 0;

    //         if (this.getCollectedMessages().size() >= pterodactylusI.getCollectedMessages().size()){
    //             numberToExchangeBetweenAlly = Random.getInstance().randRange(pterodactylusI.getCollectedMessages().size() + 1);
    //         }
    //         else{
    //             numberToExchangeBetweenAlly = Random.getInstance().randRange(this.getCollectedMessages().size() + 1);
    //         }
    //         //Exchange the messages between ally dinosaurs if they have something to exchange..
    //         pterodactylusI.collectMessages(this.getCollectedMessages(), numberToExchangeBetweenAlly);
    //         this.collectMessages(pterodactylusI.getCollectedMessages(), numberToExchangeBetweenAlly);
    //     }
        
    //     //If encounter an ennemy.
    //     else{
            
    //         //Get the messages in common between attacker and defender.
    //         Set<String> union = new HashSet<>();
    //         union.addAll(this.getCollectedMessages());
    //         Set<String> complement = new HashSet<>();
    //         union.retainAll(pterodactylusI.getCollectedMessages());

    //         //If the attacker wins.
    //         if (this.fight()){
    //             Integer numberOfMessagesEnnemyHaveNot = pterodactylusI.getCollectedMessages().size() - union.size();
    //             complement.addAll(pterodactylusI.getCollectedMessages());
    //             complement.removeAll(union);
    //             this.collectMessages(complement, Random.getInstance().randRange(numberOfMessagesEnnemyHaveNot + 1));
    //         }

    //         //If the defender wins.
    //         else{
    //             Integer numberOfMessagesEnnemyHaveNot = this.getCollectedMessages().size() - union.size();
    //             complement.addAll(this.getCollectedMessages());
    //             complement.removeAll(union);
    //             pterodactylusI.collectMessages(complement, Random.getInstance().randRange(numberOfMessagesEnnemyHaveNot + 1));
    //         }
    //     }
    // }

    // public void meet(MosasaurusIndividual mosasaurusI) throws Exception {
    //     //If encounter a dinosaur in the same alliance.
    //     if (Diplodocus.getAlliance().equals(Mosasaurus.getAlliance())){

    //         //Which number of messages to exchange ?
    //         Integer numberToExchangeBetweenAlly = 0;

    //         if (this.getCollectedMessages().size() >= mosasaurusI.getCollectedMessages().size()){
    //             numberToExchangeBetweenAlly = Random.getInstance().randRange(mosasaurusI.getCollectedMessages().size() + 1);
    //         }
    //         else{
    //             numberToExchangeBetweenAlly = Random.getInstance().randRange(this.getCollectedMessages().size() + 1);
    //         }
    //         //Exchange the messages between ally dinosaurs.
    //         mosasaurusI.collectMessages(this.getCollectedMessages(), numberToExchangeBetweenAlly);
    //         this.collectMessages(mosasaurusI.getCollectedMessages(), numberToExchangeBetweenAlly);
    //     }
        
    //     //If encounter an ennemy.
    //     else{
            
    //         //Get the messages in common between attacker and defender.
    //         Set<String> union = new HashSet<>();
    //         union.addAll(this.getCollectedMessages());
    //         Set<String> complement = new HashSet<>();
    //         union.retainAll(mosasaurusI.getCollectedMessages());

    //         //If the attacker wins.
    //         if (this.fight()){
    //             Integer numberOfMessagesEnnemyHaveNot = mosasaurusI.getCollectedMessages().size() - union.size();
    //             complement.addAll(mosasaurusI.getCollectedMessages());
    //             complement.removeAll(union);
    //             this.collectMessages(complement, Random.getInstance().randRange(numberOfMessagesEnnemyHaveNot + 1));
    //         }

    //         //If the defender wins.
    //         else{
    //             Integer numberOfMessagesEnnemyHaveNot = this.getCollectedMessages().size() - union.size();
    //             complement.addAll(this.getCollectedMessages());
    //             complement.removeAll(union);
    //             mosasaurusI.collectMessages(complement, Random.getInstance().randRange(numberOfMessagesEnnemyHaveNot + 1));
    //         }
    //     }
    // }

    // public void meet(TyrannosaurusIndividual tyranosaurusI) throws Exception{
    //     //If encounter a dinosaur in the same alliance.
    //     if (Diplodocus.getAlliance().equals(Tyrannosaurus.getAlliance())){

    //         //Which number of messages to exchange ?
    //         Integer numberToExchangeBetweenAlly = 0;

    //         if (this.getCollectedMessages().size() >= tyranosaurusI.getCollectedMessages().size()){
    //             numberToExchangeBetweenAlly = Random.getInstance().randRange(tyranosaurusI.getCollectedMessages().size() + 1);
    //         }
    //         else{
    //             numberToExchangeBetweenAlly = Random.getInstance().randRange(this.getCollectedMessages().size() + 1);
    //         }

    //         //Exchange the messages between ally dinosaurs.
    //         tyranosaurusI.collectMessages(this.getCollectedMessages(), numberToExchangeBetweenAlly);
    //         this.collectMessages(tyranosaurusI.getCollectedMessages(), numberToExchangeBetweenAlly);
    //     }
        
    //     //If encounter an ennemy.
    //     else{
            
    //         //Get the messages in common between attacker and defender.
    //         Set<String> union = new HashSet<>();
    //         union.addAll(this.getCollectedMessages());
    //         Set<String> complement = new HashSet<>();
    //         union.retainAll(tyranosaurusI.getCollectedMessages());

    //         //If the attacker wins.
    //         if (this.fight()){
    //             Integer numberOfMessagesEnnemyHaveNot = tyranosaurusI.getCollectedMessages().size() - union.size();
    //             complement.addAll(tyranosaurusI.getCollectedMessages());
    //             complement.removeAll(union);
    //             this.collectMessages(complement, Random.getInstance().randRange(numberOfMessagesEnnemyHaveNot + 1));
    //         }

    //         //If the defender wins.
    //         else{
    //             Integer numberOfMessagesEnnemyHaveNot = this.getCollectedMessages().size() - union.size();
    //             complement.addAll(this.getCollectedMessages());
    //             complement.removeAll(union);
    //             tyranosaurusI.collectMessages(complement, Random.getInstance().randRange(numberOfMessagesEnnemyHaveNot + 1));
    //         }
    //     }
    // }
    
}