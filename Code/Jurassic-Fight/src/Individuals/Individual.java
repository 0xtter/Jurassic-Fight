package Individuals;

public interface Individual {

    public void move(int x, int y);

    // public default void move(int x, int y) {
    //     // TO-DO
    // }
    
    public void meet(Dinosaur individual);
}