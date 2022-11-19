package Map;

import Individuals.DiplodocusIndividual;
import Individuals.DiplodocusMaster;
import Individuals.MosasaurusIndividual;
import Individuals.MosasaurusMaster;
import Individuals.PterodactylusIndividual;
import Individuals.PterodactylusMaster;
import Individuals.TyrannosaurusIndividual;
import Individuals.TyrannosaurusMaster;

public class Point {
    
    private Integer xCoord;
    private Integer yCoord;
    private String symbol;
    private Boolean isAvailable;
    private Boolean isObstacle;
    private Object dinausor;


    /**
     * Initialize a point.
     * By default point is available and not an obstacle.
     * To change point information, use the availables methods.
     * @param xCoord
     * @param yCoord
     */
    public Point(Integer xCoord, Integer yCoord) {
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.symbol = "·";
        this.isAvailable = true;
        this.isObstacle = false;
        this.dinausor = new Object();
    }

    public Integer getX() {
        return this.xCoord;
    }

    public Integer getY() {
        return this.yCoord;
    }

    public Integer[] getCoord() {
        Integer[] coord = { this.xCoord, this.yCoord };
        return coord;
    }

    public Object getDinausor() {
        return this.dinausor;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Boolean isAnObstacle() {
        return isObstacle;
    }

    /**
     * Remove Dinausor or Obstacle from the point.
     * Sets symbol to "·"
     */
    public void free() {
        this.symbol = "·";
        this.isAvailable = true;
        this.isObstacle = false;
        this.dinausor = new Object();
    }

    public boolean isFree() {
        if (this.isObstacle.equals(true)) {
            // System.out.println("Can't place a dinausor an on obstacle.");
            return false;
        }
        if (this.isAvailable.equals(false)) {
            // System.out.println("There is already a dinosaur on this point.");
            return false;
        }
        return true;
    }

    public void placeObstacle(String symbol) {
        this.symbol = symbol;
        this.isAvailable = false;
        this.isObstacle = true;
        this.dinausor = new Object();
    }

    /**
     * 
     * @param dinausor
     * @throws Exception if the point is already in use (obstacle or another Dinausor)
     */
    protected void placeDinausor(DiplodocusIndividual dinausor) throws Exception {
        if (isFree()) {
            this.dinausor = dinausor;
            this.symbol = "D";
            this.isAvailable = false;
        } else {
            throw new Exception("The point is already in use.");
        }
    }

    /**
     * 
     * @param dinausor
     * @throws Exception "The point is already in use." (obstacle or another Dinausor using this point)
     */
    protected void placeDinausor(DiplodocusMaster dinausor) throws Exception {
        if (isFree()) {
            this.dinausor = dinausor;
            this.symbol ="#D";
            this.isAvailable = false;
        } else {
            throw new Exception("The point is already in use.");
        }
    }

    /**
     * 
     * @param dinausor
     * @throws Exception if the point is already in use (obstacle or another Dinausor)
     */
    protected void placeDinausor(MosasaurusIndividual dinausor) throws Exception {
        if (isFree()) {
            this.dinausor = dinausor;
            this.symbol = "M";
            this.isAvailable = false;
        } else {
            throw new Exception("The point is already in use.");
        }
    }

    /**
     * 
     * @param dinausor
     * @throws Exception if the point is already in use (obstacle or another Dinausor)
     */
    protected void placeDinausor(MosasaurusMaster dinausor) throws Exception {
        if (isFree()) {
            this.dinausor = dinausor;
            this.symbol = "#M";
            this.isAvailable = false;
        } else {
            throw new Exception("The point is already in use.");
        }
    }

    /**
     * 
     * @param dinausor
     * @throws Exception if the point is already in use (obstacle or another Dinausor)
     */
    protected void placeDinausor(PterodactylusIndividual dinausor) throws Exception {
        if (isFree()) {
            this.dinausor = dinausor;
            this.symbol = "P";
            this.isAvailable = false;
        } else {
            throw new Exception("The point is already in use.");
        }
    }

    /**
     * 
     * @param dinausor
     * @throws Exception if the point is already in use (obstacle or another Dinausor)
     */
    protected void placeDinausor(PterodactylusMaster dinausor) throws Exception {
        if (isFree()) {
            this.dinausor = dinausor;
            this.symbol = "#P";
            this.isAvailable = false;
        } else {
            throw new Exception("The point is already in use.");
        }
    }

    /**
     * 
     * @param dinausor
     * @throws Exception if the point is already in use (obstacle or another Dinausor)
     */
    protected void placeDinausor(TyrannosaurusIndividual dinausor) throws Exception {
        if (isFree()) {
            this.dinausor = dinausor;
            this.symbol = "T";
            this.isAvailable = false;
        } else {
            throw new Exception("The point is already in use.");
        }
    }

    /**
     * 
     * @param dinausor
     * @throws Exception if the point is already in use (obstacle or another Dinausor)
     */
    protected void placeDinausor(TyrannosaurusMaster dinausor) throws Exception {
        if (isFree()) {
            this.dinausor = dinausor;
            this.symbol = "#T";
            this.isAvailable = false;
        } else {
            throw new Exception("The point is already in use.");
        }
    }

    /**
     * Compute distance with another Point Q
     * @param Q
     * @return distance
     */
    public int dist(Point Q) {
        int xQ = Q.getX().intValue();
        int yQ = Q.getY().intValue();
        int x = this.xCoord.intValue();
        int y = this.yCoord.intValue();

        int distX;
        if (x <= xQ) { distX = xQ - x; }
        else { distX = x - xQ; }

        int distY;
        if (y <= yQ) { distY = yQ - y; }
        else { distY = y - yQ; }

        return distX + distY;
    }


    @Override
    public String toString() {
        return "{" +
            " Coord='" + "[ " + this.xCoord.toString() +", " + this.yCoord.toString() + " ]" + "'" +
            ", symbol='" + getSymbol() + "'" +
            ", isAvailable='" + isAvailable + "'" +
            ", isObstacle='" + this.isObstacle + "'" +
            ", dinausor='" + getDinausor().toString() + "'" +
            "}";
    }


}
