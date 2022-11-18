package map;

import individuals.Dinosaur;

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
        return !(Boolean.TRUE.equals(this.isObstacle) || Boolean.FALSE.equals(this.isAvailable));
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
    protected void placeDinausor(Dinosaur dinausor) throws Exception {
        if (isFree()) {
            this.dinausor = dinausor;
            this.symbol = dinausor.getSymbol();
            this.isAvailable = false;
        } else {
            throw new Exception("The point is already in use.");
        }
    }

    /**
     * Compute distance with another Point point
     * @param point
     * @return distance
     */
    public int dist(Point point) {
        int xQ = point.getX().intValue();
        int yQ = point.getY().intValue();
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
