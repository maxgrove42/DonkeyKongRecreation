/******************************************************************************
  *  Compilation:  javac Ladder.java
  *  Execution:    java Ladder (runs basic testing)
  *  Dependencies: image files
  *
  *  Creates a Ladder object for Donkey Kong Game. Ladder can 
  *  be drawn. Used in World.java
  * 
  * Authors: Ethan Terner, eterner, 206
  *          Max Grove, maxgrove, 205
  ******************************************************************************/
public class Ladder { 
    private double x;
    private double y;
    private double halfHeight = 0.075;
    private double halfWidth = 0.015;
    
    /* Constructor: ladder at x, y
     * @param double x, double y
     * @return n/a
     */
    public Ladder(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /* Description: draws ladder
     * @param n/a
     * @return n/a
     */
    public void draw() {
        PennDraw.picture(x, y, "ladder1.png", 0.09 * 256, 70);
    }
    
    /* Description: returns y
     * @param n/a
     * @return double y
     */
    public double getY() { 
        return y; 
    }
    
    /* Description: returns x
     * @param n/a
     * @return double x
     */
    public double getX() { 
        return x; 
    }
    
    //testing
    public static void main(String[] args) {
        Ladder[] ladders = new Ladder[5];
        ladders[0] = new Ladder(0.4, 0.125);
        ladders[1] = new Ladder(0.6, 0.275);
        ladders[2] = new Ladder(0.6, 0.275);
        ladders[3] = new Ladder(0.6, 0.275);
        ladders[4] = new Ladder(0.6, 0.275);
        for (int i = 0; i < ladders.length; i++) {
            ladders[i].draw();
        }
    }
}