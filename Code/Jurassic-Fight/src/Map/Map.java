package Map;

import java.util.concurrent.ThreadLocalRandom;

import java.util.ArrayList;

import Individuals.Dinosaur;
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

        // left top corner / PTERO Dino
        for (int xi=0; xi<side; xi++) {
            for (int yi=0; yi<side; yi++) {
                this.safezonePtero.add(getPoint(xi, yi));
                getPoint(xi, yi).setSymbol("~~");
            }
        }
        
        // right top corner / DIPLO Dino
        for (int xi=0; xi<side; xi++) {
            for (int yi=this.nbC-side; yi<this.nbC; yi++) {
                this.safezoneDiplo.add(getPoint(xi, yi));
                getPoint(xi, yi).setSymbol("~~");
            }
        }

        // left bottom corner / MOSA Dino
        for (int xi=this.nbL-side; xi<this.nbL; xi++) {
            for (int yi=0; yi<side; yi++) {
                this.safezoneMosa.add(getPoint(xi, yi));
                getPoint(xi, yi).setSymbol("~~");
            }
        }

        // right bottom corner / TYRA Dino
        for (int xi=this.nbL-side; xi<this.nbL; xi++) {
            for (int yi=this.nbC-side; yi<this.nbC; yi++) {
                this.safezoneTyra.add(getPoint(xi, yi));
                getPoint(xi, yi).setSymbol("~~");
            }
        }
        
    }

    public void populate() throws Exception {
        // PTERO
        PterodactylusMaster pteroMaster = PterodactylusMaster.createUnique(false, 100, this);
        this.safezonePtero.get(0).placeDinausor(pteroMaster);
        for (int i=1; i<this.safezonePtero.size(); i++) {
            PterodactylusIndividual dino = new PterodactylusIndividual(false, 100, this);
            this.safezonePtero.get(i).placeDinausor(dino);
            this.safezonePtero.get(i).setSymbol(String.format("T%d", i));
        }

        // DIPLO
        DiplodocusMaster diploMaster = DiplodocusMaster.createUnique(false, 100, this);
        this.safezoneDiplo.get(0).placeDinausor(diploMaster);
        for (int i=1; i<this.safezoneDiplo.size(); i++) {
            DiplodocusIndividual dino = new DiplodocusIndividual(false, 100, this);
            this.safezoneDiplo.get(i).placeDinausor(dino);
            this.safezoneDiplo.get(i).setSymbol(String.format("D%d", i));
        }

        // MOSA
        MosasaurusMaster mosaMaster = MosasaurusMaster.createUnique(false, 100, this);
        this.safezoneMosa.get(0).placeDinausor(mosaMaster);
        for (int i=1; i<this.safezoneMosa.size(); i++) {
            MosasaurusIndividual dino = new MosasaurusIndividual(false, 100, this);
            this.safezoneMosa.get(i).placeDinausor(dino);
            this.safezoneMosa.get(i).setSymbol(String.format("M%d", i));
        }

        // TYRA
        TyrannosaurusMaster tyraMaster = TyrannosaurusMaster.createUnique(false, 100, this);
        this.safezoneTyra.get(0).placeDinausor(tyraMaster);
        for (int i=1; i<this.safezoneTyra.size(); i++) {
            TyrannosaurusIndividual dino = new TyrannosaurusIndividual(false, 100, this);
            this.safezoneTyra.get(i).placeDinausor(dino);
            this.safezoneTyra.get(i).setSymbol(String.format("T%d", i));
        }
    }

    public void generateObstacles() {
        // on selectionne arbitrairement 1 dixieme de la map pour etre
        // des obstacles
        int nbObst = (int) Math.floor((this.nbC * this.nbL) / 10);
        int count = 0;
        while (count < nbObst) {
            int yRand = ThreadLocalRandom.current().nextInt(0, this.nbC);
            int xRand = ThreadLocalRandom.current().nextInt(0, this.nbL);
            try {
                placeObstacle("OB", xRand, yRand);
                count++;
            } catch (Exception err) { }
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
     * Search for availables points next to a current point (x, y)
     * @param x >= 0
     * @param y >= 0
     * @return list of coordinates to move to
     */
    public ArrayList<Integer[]> getAvailableMoves(int x, int y) {
        ArrayList<Integer[]> moves = new ArrayList<>();
        
        Point currentPoint = getPoint(x, y);    // to be sure that the point exists.

        Point tmpP = null;

        
        Integer movesAvailable[][] = {
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
        for (Integer currenMove[] : movesAvailable) {
            try{
                tmpP = getPoint(x + currenMove[0], y + currenMove[1]);
                if (tmpP.isFree() && !tmpP.equals(currentPoint)) { 
                    moves.add(tmpP.getCoord());
                };
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
    public ArrayList<Point> getDinausorsAround(int x, int y) {
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
                } catch (Exception e) { }
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
        Integer nextMove[] = {};

        // get moves options
        ArrayList<Integer[]> possibleMoves = getAvailableMoves(actualPoint.getX(), actualPoint.getY());
        if (possibleMoves.size() == 0) { return nextMove; }

        // find the closest next point from the first SafeZone Point

        double min = Math.max(this.nbC, this.nbL);
        for (int c=0; c<possibleMoves.size(); c++) {
            Integer[] coord = possibleMoves.get(c);
            Point Q = getPoint(coord[0], coord[1]);
            // check if it's the nearest point to target in safezone
            int distQ = Q.dist(targetPoint);
            if (distQ == Math.min(min, distQ)) {
                min = distQ;
                nextMove = coord;
            }
        }
        return nextMove;
    }

    /**
     * Find the next position in order to reach the safezone
     * @param diplodocus
     * @return { x, y }
     * @throws Exception
     */
    public Integer[] getDirectionToSafeZone(DiplodocusIndividual diplodocus) throws Exception {
        Integer nextMove[] = {};

        // looking for dinausor in map
        Point point = getPoint(diplodocus);
        if (point == null) { return nextMove; }

        // Check if point is already in safezone
        if (this.safezoneDiplo.size() == 0) { 
            throw new Exception("SafeZoneDiplo was not initialized.");
        }
        else if (this.safezoneDiplo.contains(point)) { return nextMove; }

        // set as reference the first point of SafeZone
        Point safezonePoint = this.safezoneDiplo.get(0);
        nextMove = findNextMoveToReachPoint(point, safezonePoint);

        return nextMove;
    }

    /**
     * Find the next position in order to reach the safezone
     * @param diplodocus
     * @return { x, y }
     * @throws Exception
     */
    public Integer[] getDirectionToSafeZone(MosasaurusIndividual mosasaurus) throws Exception {
        Integer nextMove[] = {};

        // looking for dinausor in map
        Point point = getPoint(mosasaurus);
        if (point == null) { return nextMove; }

        // Check if point is already in safezone
        if (this.safezoneMosa.size() == 0) { 
            throw new Exception("SafeZoneDiplo was not initialized.");
         }
        else if (this.safezoneMosa.contains(point)) { return nextMove; }

        // set as reference the first point of SafeZone
        Point safezonePoint = this.safezoneMosa.get(0);
        nextMove = findNextMoveToReachPoint(point, safezonePoint);

        return nextMove;
    }

    /**
     * Find the next position in order to reach the safezone
     * @param diplodocus
     * @return { x, y }
     * @throws Exception
     */
    public Integer[] getDirectionToSafeZone(PterodactylusIndividual pterodactylus) throws Exception {
        Integer nextMove[] = {};

        // looking for dinausor in map
        Point point = getPoint(pterodactylus);
        if (point == null) { return nextMove; }

        // Check if point is already in safezone
        if (this.safezonePtero.size() == 0) { 
            throw new Exception("SafeZoneDiplo was not initialized.");
         }
        else if (this.safezonePtero.contains(point)) { return nextMove; }

        // set as reference the first point of SafeZone
        Point safezonePoint = this.safezonePtero.get(0);
        nextMove = findNextMoveToReachPoint(point, safezonePoint);

        return nextMove;
    }

    /**
     * Find the next position in order to reach the safezone
     * @param diplodocus
     * @return { x, y }
     * @throws Exception
     */
    public Integer[] getDirectionToSafeZone(TyrannosaurusIndividual tyrannosaurus) throws Exception {
        Integer nextMove[] = {};

        // looking for dinausor in map
        Point point = getPoint(tyrannosaurus);
        if (point == null) { return nextMove; }

        // Check if point is already in safezone
        if (this.safezoneTyra.size() == 0) { 
            throw new Exception("SafeZoneDiplo was not initialized.");
        }
        else if (this.safezoneTyra.contains(point)) { return nextMove; }

        // set as reference the first point of SafeZone
        Point safezonePoint = this.safezoneTyra.get(0);
        nextMove = findNextMoveToReachPoint(point, safezonePoint);

        return nextMove;
    }


    /**
     * Kill a dinausor on the map, ie replace it by an obstacle
     * @param dinosaur
     * @param symbolObstacle char to display instead of the Dinausor
     * @throws Exception
     */
    public void killDinausor(Dinosaur dinosaur, String symbolObstacle) throws Exception {
        Point point = getPoint(dinosaur);
        point.free();
        point.placeObstacle(symbolObstacle);
    }


    public ArrayList<Point> getMosaSafeZone() {
        return this.safezoneMosa;
    }

    public ArrayList<Point> getPteroSafeZone() {
        return this.safezonePtero;
    }

    public ArrayList<Point> getTyraSafeZone() {
        return this.safezoneTyra;
    }

    public ArrayList<Point> getDiploSafeSone() {
        return this.safezoneTyra;
    }


    public void display() {

        ArrayList<Integer> maxSymbolLengthByCol = new ArrayList<>();

        // get max length by column
        for (int j=0; j < this.nbC; j++) {
            int maxSymbolLengthCol = 0;
            for(int i=0; i < this.nbL ;i++) {
                maxSymbolLengthCol = Math.max(maxSymbolLengthCol, getPoint(i, j).getSymbol().length());
            }
            maxSymbolLengthByCol.add(maxSymbolLengthCol);
        }

        String indexLine = this.nbL > 9 ? "   " : "   ";
        for (int j=0; j < this.nbC; j++) {
            indexLine += Integer.toString(j) + new String(new char[maxSymbolLengthByCol.get(j) - String.format("%d", j).length() + 1]).replace("\0", " ");
        }
        indexLine += "\n";

        String mapstr = indexLine;

        for (int i = 0; i < this.nbL; i++) {
            String spaceBtwIndexAndMap = i > 9 ? " " : "  ";
            mapstr += Integer.toString(i) + spaceBtwIndexAndMap;

            for(int j=0; j < this.nbC ;j++) {
                String symbol = getPoint(i, j).getSymbol();

                // alignement des cases si des points avec des noms de longueur différentes
                String align = new String(new char[maxSymbolLengthByCol.get(j)-symbol.length()]).replace("\0", " ");

                align = symbol.length() == 1 ? align.replace(" ", symbol) : align;

                mapstr += symbol + align + " ";
            }
            mapstr += "\n";
        }

        System.out.println(mapstr);
    }

}
