package map;

import java.util.ArrayList;
import java.util.List;

import individuals.Dinosaur;
import individuals.Diplodocus;
import individuals.Mosasaurus;
import individuals.Pterodactylus;
import individuals.Tyrannosaurus;

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
                this.safezoneDiplo.add(getPoint(xi,this.nbC-1-yi));
                getPoint(xi, this.nbC-1-yi).setSymbol("~");
                this.safezoneMosa.add(getPoint(this.nbL-1-xi,yi));
                getPoint(this.nbL-1-xi, yi).setSymbol("~");
                this.safezoneTyra.add(getPoint(this.nbL-1-xi,this.nbC-1-yi));
                getPoint(this.nbL-1-xi, this.nbC-1-yi).setSymbol("~");
            }
        }
    }

    /**
     * Get the n*m size of the map
     * @return { n, m }
     */
    public Integer[] getShape() {
        Integer[]  shape = { this.nbL, this.nbL };
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
     * Place a Dinosaur on the map
     * @param dinausor
     * @param x
     * @param y
     * @throws Exception
     */
    public void place(Dinosaur dinausor, Integer x, Integer y) throws Exception {
        getPoint(x, y).placeDinausor(dinausor);
    }    

    /**
     * Move a DiplodocusIndividual to another point
     * @param dinausor
     * @param x new X >= 0
     * @param y new Y >= 0
     * @throws Exception "Can't move a dinausor that is not on the map."
     */
    public void move(Dinosaur dinausor, Integer x, Integer y) throws Exception {
        Point currentPoint = getPoint(dinausor);
        Point nextPoint = getPoint(x, y);

        if (currentPoint == null) {
            throw new Exception("Can't move a dinausor that is not on the map.");
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
    public List<Integer[]> getAvailableMoves(int x, int y) {
        ArrayList<Integer[]> moves = new ArrayList<>();
        
        Point currentPoint = getPoint(x, y);    // to be sure that the point exists.

        Point tmpP = null;

        
        Integer[][] movesAvailable = {
            { -1, 2 },
            { 1, 2 },
            { 2, -1 },
            { 2, 1 },
            { 1, -2 },
            { -1, -2 },
            { -2, -1 },
            { -2, 1 }
        }; // Movements of a knight (chess) : see https://en.wikipedia.org/wiki/Knight_(chess)#Movement
        
        // search available points next to current point
        for (Integer[] currenMove : movesAvailable) {
            try{
                tmpP = getPoint(x + currenMove[0], y + currenMove[1]);
                if (tmpP.isFree() && !tmpP.equals(currentPoint)) { 
                    moves.add(tmpP.getCoord());
                }
            } catch (Exception e) {}
        }
        return moves;
    }

    /**
     * Search for dinausors of all races next to a current point (x, y)
     * @param x >= 0
     * @param y >= 0
     * @return list of coordinates to points where there is a dino next to (x,y)
     */
    public List<Point> getDinausorsAround(int x, int y) {
        ArrayList<Point> dino = new ArrayList<>();
        
        Point currentP = getPoint(x, y);

        Point tmpP = null;
        // search available points next to current point
        for (Integer xi=x-1; xi<=x+1; xi++) {
            for (Integer yi=y-1; yi<=y+1; yi++) {
                try {
                    tmpP = getPoint(xi, yi);
                    if (!tmpP.isFree() && tmpP.getDinausor() instanceof Dinosaur && !tmpP.equals(currentP)) { 
                        dino.add(tmpP);
                    };
                } catch (Exception e) {}
            }
        }
        return dino;
    }

    /**
     * In the set of available points near an actual point,
     * find the point that is the closest to the targetPoint.
     * @param actualPoint
     * @param targetPoint
     * @return { x, y }
     */
    public Integer[] findNextMoveToReachPoint(Point actualPoint, Point targetPoint) {
        Integer[] nextMove = {};

        // get moves options
        ArrayList<Integer[]> possibleMoves = (ArrayList<Integer[]>) getAvailableMoves(actualPoint.getX(), actualPoint.getY());
        if (possibleMoves.isEmpty()) { return nextMove; }

        // find the closest next point from the first SafeZone Point

        double min = Math.max(this.nbC, this.nbL);
        for (int c=0; c<possibleMoves.size(); c++) {
            Integer[] coord = possibleMoves.get(c);
            Point point = getPoint(coord[0], coord[1]);
            // check if it's the nearest point to target in safezone
            int distQ = point.dist(targetPoint);
            if (distQ == Math.min(min, distQ)) {
                min = distQ;
                nextMove = coord;
            }
        }
        return nextMove;
    }

    /**
     * Find the next position in order to reach the safezone
     * @param dinausor
     * @return { x, y }
     * @throws Exception
     */
    public Integer[] getDirectionToSafeZone(Dinosaur dinosaur) throws Exception {
        Integer[] nextMove = {};

        // looking for dinausor in map
        Point point = getPoint(dinosaur);
        if (point == null) { return nextMove; }

        if (dinosaur instanceof Diplodocus){
            // Check if point is already in safezone
            if (this.safezoneDiplo.isEmpty()) { 
                throw new Exception("SafeZoneDiplo was not initialized.");
            }
            else if (this.safezoneDiplo.contains(point)) { return nextMove; }

            // set as reference the first point of SafeZone
            Point safezonePoint = this.safezoneDiplo.get(0);
            nextMove = findNextMoveToReachPoint(point, safezonePoint);

            return nextMove;
        }
        else if (dinosaur instanceof Mosasaurus){
            // Check if point is already in safezone
            if (this.safezoneMosa.isEmpty()) { 
                throw new Exception("SafeZoneMosa was not initialized.");
            }
            else if (this.safezoneMosa.contains(point)) { return nextMove; }

            // set as reference the first point of SafeZone
            Point safezonePoint = this.safezoneMosa.get(0);
            nextMove = findNextMoveToReachPoint(point, safezonePoint);

            return nextMove;
        }
        else if (dinosaur instanceof Pterodactylus){
            // Check if point is already in safezone
            if (this.safezonePtero.isEmpty()) { 
                throw new Exception("SafeZonePtero was not initialized.");
            }
            else if (this.safezonePtero.contains(point)) { return nextMove; }

            // set as reference the first point of SafeZone
            Point safezonePoint = this.safezonePtero.get(0);
            nextMove = findNextMoveToReachPoint(point, safezonePoint);

            return nextMove;
        }
        else if (dinosaur instanceof Tyrannosaurus){
            // Check if point is already in safezone
            if (this.safezoneTyra.isEmpty()) { 
                throw new Exception("SafeZoneTyra was not initialized.");
            }
            else if (this.safezoneTyra.contains(point)) { return nextMove; }

            // set as reference the first point of SafeZone
            Point safezonePoint = this.safezoneTyra.get(0);
            nextMove = findNextMoveToReachPoint(point, safezonePoint);

            return nextMove;
        }
        else{
            return nextMove;
        }
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
