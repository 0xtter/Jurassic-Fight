package Map;

import java.util.ArrayList;

import Individuals.Diplodocus;
import Individuals.DiplodocusIndividual;
import Individuals.DiplodocusMaster;
import Individuals.Mosasaurus;
import Individuals.MosasaurusIndividual;
import Individuals.MosasaurusMaster;
import Individuals.Pterodactylus;
import Individuals.PterodactylusIndividual;
import Individuals.PterodactylusMaster;
import Individuals.Tyrannosaurus;
import Individuals.TyrannosaurusIndividual;
import Individuals.TyrannosaurusMaster;

public class Map {

    private ArrayList<ArrayList<Point>> matrix;
    private Integer nbL;                            // nb of lines
    private Integer nbC;                            // nb of columns
    
    public Map(Integer nbLines, Integer nbCol) {
        this.nbL = nbLines;
        this.nbC = nbCol;
        initMatrix(nbLines, nbCol);
    }

    /**
     * Get the n*m size of the map
     * @return { n, m }
     */
    public Integer[] getShape() {
        Integer shape[] = { this.nbL, this.nbL };
        return shape;
    }
    
    /**
     * Declare matrix shape and fill it with default Point objects.
     * @param nbLines
     * @param nbCol
     */
    private void initMatrix(Integer nbLines, Integer nbCol) {
        this.matrix = new ArrayList<>();
        for (int i = 0; i < nbLines; i++) {
            ArrayList<Point> line = new ArrayList<>();
            for(int j=0; j < nbCol ;j++){
                Point p = new Point(i, j);
                line.add(p);
            }
            this.matrix.add(line);
        }
    }

    public Point getPoint(Integer x, Integer y) {
        return this.matrix.get(x).get(y);
    }

    /**
     * Localise a dinausor (individual or master) on the map.
     * The function returns a point with all the info relative
     * to this position. Please check Point.java.
     * 
     * @param dinausor
     * @return object OR null if not found.
     * @throws "Bad parameter, argument must be an individual or a master."
     */
    public Point getPoint(Object dinausor)  throws Exception {
        if( !(dinausor instanceof Diplodocus ||
              dinausor instanceof Mosasaurus ||
              dinausor instanceof Pterodactylus ||
              dinausor instanceof Tyrannosaurus) ) {

                throw new Exception("Bad parameter, argument must be an individual or a master.");
            }
        
        for (int i = 0; i < this.nbL; i++) {
            for(int j=0; j < this.nbC ;j++){
                if (dinausor.equals(getPoint(i, j).getDinausor()) ) {
                    return getPoint(i, j);
                }
            }
        }
        return null;
    }

    /**
     * Place an obstacle on the map
     * @param x
     * @param y
     * @param symbol charactère à afficher
     * @throws Exception
     */
    public void placeObstacle(String symbol, Integer x, Integer y) throws Exception {
        getPoint(x, y).placeObstacle(symbol);
    }

    /**
     * Place a DiplodocusIndividual on the map
     * @param dinausor
     * @param x
     * @param y
     * @throws Exception
     */
    public void place(DiplodocusIndividual dinausor, Integer x, Integer y) throws Exception {
        getPoint(x, y).placeDinausor(dinausor);
    }

    /**
     * Place a DiplodocusMaster on the map
     * @param dinausor
     * @param x
     * @param y
     * @throws Exception
     */
    public void place(DiplodocusMaster dinausor, Integer x, Integer y) throws Exception {
        getPoint(x, y).placeDinausor(dinausor);
    }

    /**
     * Place a MosasaurusIndividual on the map
     * @param dinausor
     * @param x
     * @param y
     * @throws Exception
     */
    public void place(MosasaurusIndividual dinausor, Integer x, Integer y) throws Exception {
        getPoint(x, y).placeDinausor(dinausor);
    }

    /**
     * Place a MosasaurusMaster on the map
     * @param dinausor
     * @param x
     * @param y
     * @throws Exception
     */
    public void place(MosasaurusMaster dinausor, Integer x, Integer y) throws Exception {
        getPoint(x, y).placeDinausor(dinausor);
    }

    /**
     * Place a PterodactylusIndividual on the map
     * @param dinausor
     * @param x
     * @param y
     * @throws Exception
     */
    public void place(PterodactylusIndividual dinausor, Integer x, Integer y) throws Exception {
        getPoint(x, y).placeDinausor(dinausor);
    }

    /**
     * Place a PterodactylusMaster on the map
     * @param dinausor
     * @param x
     * @param y
     * @throws Exception
     */
    public void place(PterodactylusMaster dinausor, Integer x, Integer y) throws Exception {
        getPoint(x, y).placeDinausor(dinausor);
    }

    /**
     * Place a TyrannosaurusIndividual on the map
     * @param dinausor
     * @param x
     * @param y
     * @throws Exception
     */
    public void place(TyrannosaurusIndividual dinausor, Integer x, Integer y) throws Exception {
        getPoint(x, y).placeDinausor(dinausor);
    }

    /**
     * Place a TyrannosaurusMaster on the map
     * @param dinausor
     * @param x
     * @param y
     * @throws Exception
     */
    public void place(TyrannosaurusMaster dinausor, Integer x, Integer y) throws Exception {
        getPoint(x, y).placeDinausor(dinausor);
    }

    /**
     * Move a DiplodocusIndividual to another point
     * @param dinausor
     * @param x new X >= 0
     * @param y new Y >= 0
     * @throws Exception "Can't move a DiplodocusIndividual that is not on the map."
     */
    public void move(DiplodocusIndividual dinausor, Integer x, Integer y) throws Exception {
        Point actualPoint = getPoint(dinausor);
        Point nextPoint = getPoint(x, y);

        if (actualPoint == null) {
            throw new Exception("Can't move a MosasaurusIndividual that is not on the map.");
        }
        
        nextPoint.placeDinausor(dinausor);
        nextPoint.setSymbol(actualPoint.getSymbol());

        actualPoint.free();
    }

    /**
     * Move a MosasaurusIndividual to another point
     * @param dinausor
     * @param x new X >= 0
     * @param y new Y >= 0
     * @throws Exception "Can't move a MosasaurusIndividual that is not on the map."
     */
    public void move(MosasaurusIndividual dinausor, Integer x, Integer y) throws Exception {
        Point actualPoint = getPoint(dinausor);
        Point nextPoint = getPoint(x, y);

        if (actualPoint == null) {
            throw new Exception("Can't move a MosasaurusIndividual that is not on the map.");
        }
        
        nextPoint.placeDinausor(dinausor);
        nextPoint.setSymbol(actualPoint.getSymbol());

        actualPoint.free();
    }

    /**
     * Move a PterodactylusIndividual to another point
     * @param dinausor
     * @param x new X >= 0
     * @param y new Y >= 0
     * @throws Exception "Can't move a PterodactylusIndividual that is not on the map."
     */
    public void move(PterodactylusIndividual dinausor, Integer x, Integer y) throws Exception {
        Point actualPoint = getPoint(dinausor);
        Point nextPoint = getPoint(x, y);

        if (actualPoint == null) {
            throw new Exception("Can't move a PterodactylusIndividual that is not on the map.");
        }
        
        nextPoint.placeDinausor(dinausor);
        nextPoint.setSymbol(actualPoint.getSymbol());

        actualPoint.free();
    }

    /**
     * Move a TyrannosaurusIndividual to another point
     * @param dinausor
     * @param x new X >= 0
     * @param y new Y >= 0
     * @throws Exception "Can't move a TyrannosaurusIndividual that is not on the map."
     */
    public void move(TyrannosaurusIndividual dinausor, Integer x, Integer y) throws Exception {
        Point currentPoint = getPoint(dinausor);
        Point nextPoint = getPoint(x, y);

        if (currentPoint == null) {
            throw new Exception("Can't move a TyrannosaurusIndividual that is not on the map.");
        }
        
        nextPoint.placeDinausor(dinausor);
        nextPoint.setSymbol(currentPoint.getSymbol());

        currentPoint.free();
    }

    public ArrayList<Integer[]> getAvailableMoves(int x, int y) {
        ArrayList<Integer[]> moves = new ArrayList<>();
        
        Point currentPoint = getPoint(x, y);    // to be sure that the point exists.

        Point tmpP = null;
        // search available points next to current point
        for (Integer xi=x-1; xi<=x+1; xi++) {
            for (Integer yi=y-1; yi<=y+1; yi++) {
                try {
                    tmpP = getPoint(xi, yi);
                    if (tmpP.isFree() && !tmpP.equals(currentPoint)) { 
                        moves.add(tmpP.getCoord());
                    };
                } catch (Exception e) { }
            }
        }
        return moves;
    }

    public void display() {
        String firstline = "  ";
        for (int i = 0; i < this.nbC; i++) {
            firstline += Integer.toString(i) + " ";
        }
        firstline += "\n";

        String str = "";

        for (int i = 0; i < this.nbL; i++) {
            str += Integer.toString(i) + " ";
            for(int j=0; j < this.nbC ;j++){
                String symbol = getPoint(i, j).getSymbol();
                str += symbol + " ";
            }
            str += "\n";
        }

        System.out.println(firstline + str);
    }

}
