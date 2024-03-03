package main;

/******************************************************************************
  *  Compilation:  javac Barrel.java
  *  Execution:    java Barrel (runs basic testing)
  *  Dependencies: image files
  *
  *  Creates a barrel object for Donkey Kong Game. Barrel can 
  * roll, fall, and stop depending on floors inputted. Used in World.java
  * 
  * Authors: 
  *          Max Grove, maxgrove, 205
  *	     Ethan Terner, eterner, 206
  ******************************************************************************/
public class Barrel {
    private double x; private double y;
    private double velX = 0.005;
    private double velY;
    private double fallVel = 0.01;
    private static final double radius = 0.025;
    private int floorLevel = 0;
    private int angle = 0;
    
    /* Constructor: Creates barrel with x,y coordinates.
     * 
     */
    public Barrel(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /* Description: Draws a barrel at it's x and y location with a
     * constantly changing angle.
     * @param n/a
     * @return n/a
     */
    public void draw() {
        double neg = Math.pow(-1, floorLevel + 1);
        PennDraw.picture(x, y, "/resources/graphics/barrel.png", 24, 24, angle * neg);
        angle += 5;
    }
    
    /* Description: Draws 4 barrels in the top corner
     * @param floors[] for getting height to draw them at
     * @return n/a
     */
    public static void draw4(Floor[] floors) {
        double yHeight = floors[0].getY() + floors[0].getHeight() + radius;
        PennDraw.picture(0.05, yHeight, "/resources/graphics/barrel.png", 24, 24);
        PennDraw.picture(0.05, yHeight + 2 * radius, "/resources/graphics/barrel.png", 24, 24);
        PennDraw.picture(0.10, yHeight, "/resources/graphics/barrel.png", 24, 24);
        PennDraw.picture(0.10, yHeight + 2 * radius, "/resources/graphics/barrel.png", 24, 24);
    }
    
    /* Description: changes the x position to the right
     * @param n/a
     * @return n/a
     */
    public void rollRight() {
        x += velX;
    }
    
    /* Description: changes the x position to the left
     * @param n/a
     * @return n/a
     */
    public void rollLeft() {
        x -= velX;
    }  
    
    /* Description: returns x position
     * @param n/a
     * @return n/a
     */
    public double getX() {
        return x;
    }
    
    /* Description: returns y position
     * @param n/a
     * @return n/a
     */
    public double getY() {
        return y;
    }
    
    /* Description: gets floor level of barrel
     * @param n/a
     * @return int floorLevel
     */
    public int getFloorLevel() {
        return floorLevel;
    }
    
    /* Description: sets floor level of barrel
     * @param int f - which floorLevel to set at
     * @return n/a
     */
    public void setFloorLevel(int floorLevel) {
        this.floorLevel = floorLevel;
    }
    
    /* Description: returns y velocity
     * @param n/a
     * @return n/a
     */
    public double getVelY() {
        return velY;
    }
    
    /* Description: returns radius of barrels
     * @param n/a
     * @return double radius
     */
    public double getRadius() {
        return radius;
    }
    
    /* Updates barrel's y position
     * @param n/a
     * @return n/a
     */
    public void updateY() {
        y += velY;
    }
    
    /* make the barrel fall by lowering y velocity
     * @param n/a
     * @return n/a
     */
    public void fall() {
        velY -= 0.001;
    }
    
    /* Stop the barrel from falling and put it at its floor level
     * @param n/a
     * @return n/a
     */
    public void stop(Floor[] f) {
        velY = 0.0;
        
        //safety checking code
        y = f[floorLevel].getHeight() + f[floorLevel].getY() + radius;
    }
    
    /* checks if barrel is connected to any of the floors
     * @param array of floors
     * @return boolean true or false
     */
    public boolean floorCollision(Floor[] f) {
        boolean floorCollide = false;
        
        for (int i = 0; i < f.length; i++) {
            if (f[i].collision(this)) {
                floorCollide = true;
            }
        }
        return floorCollide;
    }
    
    //TESTING
    public static void main(String[] args) {
        Barrel b = new Barrel(0.5, 0.5);
        PennDraw.enableAnimation(30);
        
        while(true) {
            PennDraw.clear(PennDraw.WHITE);
            b.draw();
            b.fall();
            b.updateY();
            PennDraw.advance();
        }
    }
}