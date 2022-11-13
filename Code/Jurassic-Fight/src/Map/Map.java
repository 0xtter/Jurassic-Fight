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

    private Integer nbL;                            // nb of lines
    private Integer nbC;                            // nb of columns
    private ArrayList<ArrayList<Point>> matrix;
    private ArrayList<Point> safezoneDiplo = new ArrayList<>();
    private ArrayList<Point> safezoneMosa = new ArrayList<>();
    private ArrayList<Point> safezonePtero = new ArrayList<>();
    private ArrayList<Point> safezoneTyra = new ArrayList<>();
    
    /**
     * 
     * @param nbLines >= 4
     * @param nbCol >= 4
     * @throws Exception "Map shape must be at least (3, 3)."
     */
    public Map(Integer nbLines, Integer nbCol) throws Exception {
        if (!( nbLines > 3 && nbCol > 3)) {
            throw new Exception("Map shape must be at least (3, 3).");
        }
        this.nbL = nbLines;
        this.nbC = nbCol;
        initMatrix(nbLines, nbCol);
        initSafezones();
    }
    
    /**
     * Declare matrix shape and fill it with default Point objects.
     * @param nbLines
     * @param nbCol
     */
    private void initMatrix(Integer nbLines, Integer nbCol) throws Exception {
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

    /**
     * Create safeZones.
     * Change symbol of points in SafeZones.
     * 
     * L'attribution des coins à une race n'est pas (encore) aléatoire
     */
    private void initSafezones() {
        int area = this.nbC.intValue() * this.nbL.intValue();
        if (area%2 == 1) { area -= 1; }

        // sum of area of all SZ must be <= area of half of the map
        int areaOfSZ = area / (2*4);

        // we want SZ to be squares, compute length of square sides
        double sideSZ = Math.floor(Math.sqrt(areaOfSZ));
        int side = (int) sideSZ;

        // add points to safeZones

        // right top corner / PTERA Dino
        for (int xi=0; xi<side; xi++) {
            for (int yi=0; yi<side; yi++) {
                this.safezonePtero.add(getPoint(xi, yi));
                getPoint(xi, yi).setSymbol("~");
            }
        }
        
        // right top corner / DIPLO Dino
        for (int xi=0; xi<side; xi++) {
            for (int yi=this.nbC-side; yi<this.nbC; yi++) {
                this.safezoneDiplo.add(getPoint(xi, yi));
                getPoint(xi, yi).setSymbol("~");
            }
        }

        // left bottom corner / MOSA Dino
        for (int xi=this.nbL-side; xi<this.nbL; xi++) {
            for (int yi=0; yi<side; yi++) {
                this.safezoneMosa.add(getPoint(xi, yi));
                getPoint(xi, yi).setSymbol("~");
            }
        }

        // right bottom corner / TYRA Dino
        for (int xi=this.nbL-side; xi<this.nbL; xi++) {
            for (int yi=this.nbC-side; yi<this.nbC; yi++) {
                this.safezoneTyra.add(getPoint(xi, yi));
                getPoint(xi, yi).setSymbol("~");
            }
        }
        
    }

    /**
     * Get the n*m size of the map
     * @return { n, m }
     */
    public Integer[] getShape() {
        Integer shape[] = { this.nbL, this.nbL };
        return shape;
    }

    public Point getPoint(Integer x, Integer y) {
        return this.matrix.get(x).get(y);
    }

    public boolean isPointInSafeZone(Point point) {
        return this.safezoneDiplo.contains(point) || 
                this.safezoneMosa.contains(point) ||
                this.safezonePtero.contains(point) ||
                this.safezoneTyra.contains(point);
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
        Point currentPoint = getPoint(dinausor);
        Point nextPoint = getPoint(x, y);

        if (currentPoint == null) {
            throw new Exception("Can't move a MosasaurusIndividual that is not on the map.");
        }
        
        nextPoint.placeDinausor(dinausor);
        nextPoint.setSymbol(currentPoint.getSymbol());

        currentPoint.free();
        if (isPointInSafeZone(currentPoint)) {
            currentPoint.setSymbol("~");
        }
    }

    /**
     * Move a MosasaurusIndividual to another point
     * @param dinausor
     * @param x new X >= 0
     * @param y new Y >= 0
     * @throws Exception "Can't move a MosasaurusIndividual that is not on the map."
     */
    public void move(MosasaurusIndividual dinausor, Integer x, Integer y) throws Exception {
        Point currentPoint = getPoint(dinausor);
        Point nextPoint = getPoint(x, y);

        if (currentPoint == null) {
            throw new Exception("Can't move a MosasaurusIndividual that is not on the map.");
        }
        
        nextPoint.placeDinausor(dinausor);
        nextPoint.setSymbol(currentPoint.getSymbol());

        currentPoint.free();
        if (isPointInSafeZone(currentPoint)) {
            currentPoint.setSymbol("~");
        }
    }

    /**
     * Move a PterodactylusIndividual to another point
     * @param dinausor
     * @param x new X >= 0
     * @param y new Y >= 0
     * @throws Exception "Can't move a PterodactylusIndividual that is not on the map."
     */
    public void move(PterodactylusIndividual dinausor, Integer x, Integer y) throws Exception {
        Point currentPoint = getPoint(dinausor);
        Point nextPoint = getPoint(x, y);

        if (currentPoint == null) {
            throw new Exception("Can't move a PterodactylusIndividual that is not on the map.");
        }
        
        nextPoint.placeDinausor(dinausor);
        nextPoint.setSymbol(currentPoint.getSymbol());

        currentPoint.free();
        if (isPointInSafeZone(currentPoint)) {
            currentPoint.setSymbol("~");
        }
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
        if (isPointInSafeZone(currentPoint)) {
            currentPoint.setSymbol("~");
        }
    }

    /**
     * Search for availables points next to a current point (x, y)
     * @param x >= 0
     * @param y >= 0
     * @return list of coordinates to move to
     */
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
