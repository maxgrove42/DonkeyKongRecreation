/******************************************************************************
 *  Compilation:  javac Floor.java
 *  Execution:    java Floor (runs basic testing)
 *  Dependencies: image files
 *
 *  Creates a floor object for Donkey Kong Game. Floor can be drawn and
 * compared to mario or barrels for collision detection. Used in World.java
 * 
  * Authors: Ethan Terner, eterner, 206
  *          Max Grove, maxgrove, 205
 *
 ******************************************************************************/
public class Floor {
    
    //private fields for x/ycenter
    private double x;
    private double y;
    
    //static fields because every floor will be the same height
    private static double halfWidth = 0.4;
    private static double halfHeight = 0.01;
    
    /* Constructor: Floor with x and y
    * @param n/a
    * @return n/a
    */
    public Floor(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /* Descritpion: get x
    * @param n/a
    * @return double x
    */
    public double getX() {
        return x; 
    }
    
    /* Descritpion: get y
    * @param n/a
    * @return double y
    */
    public double getY() {
        return y; 
    }
    
    /* Descritpion: get width
    * @param n/a
    * @return double halfWidth
    */
    public static double getWidth() {
        return halfWidth; 
    }
      
    /* Descritpion: get height
    * @param n/a
    * @return double halfHeight
    */
    public static double getHeight() { 
        return halfHeight;
    }

    /* Descritpion: draw the floor at x, y
    * @param n/a
    * @return n/a
    */
    public void draw() {
        PennDraw.picture(x, y, "floor.png", 2 * halfWidth * 512,
                         2 * halfHeight * 512);
    }
    
    /* Descritpion: checks if the floor has collided with mario
    * @param n/a
    * @return boolean
    */
    public boolean collision(Mario mario) {
        return (mario.getY() - mario.getHalfHeight() <= y + halfHeight &&
                mario.getY() >= y && mario.getX() <= x + halfWidth &&
                mario.getX() >= x - halfWidth);
    }
    
    /* Descritpion: checks if the floor has collided with barrel
    * @param n/a
    * @return boolean
    */
    public boolean collision(Barrel barrel) {
        return (barrel.getY() - barrel.getRadius() <= y + halfHeight &&
                barrel.getY() >= y && barrel.getX() <= x + halfWidth &&
                barrel.getX() >= x - halfWidth);
    }
    
    //TESTING CODE
    public static void main(String[] args) {
        
        // implementing with array
        Floor[] floors = new Floor[4]; //6 floors
       
        //initialize the floors alternating which edge they touch and moving
        //down 0.15 for every floor
        for (int i = 0; i < floors.length; i++) {
            if (i % 2 == 0) {
                floors[i] = new Floor(0.4, 0.8 - i * 0.15);
            }
            else {
                floors[i] = new Floor(0.6, 0.65 - (i - 1) * 0.15);
            }
        }
        
        //print out the x/y floor center
        /*for (int i = 0; i < floors.length; i++) {
            System.out.println("i:" + i + " x:" + floors[i].getX() +
            " y:" + floors[i].getY());
        }*/
        
        //draw the floors
        for (int i = 0; i < floors.length; i++) {
            floors[i].draw();
        }

        /*implementing with LinkedList*****************************************
        LinkedList<Floor> floors = new LinkedList<Floor>();
        
        for (int i = 0; i < 6; i++) { //add 6 floora
           if (i % 2 == 0) {
                floors.add(new Floor(0.4, 0.8 - i * 0.15));
            }
            else {
                floors.add(new Floor(0.6, 0.65 - (i - 1) * 0.15));
            }
        }
        
        
        //draw the floors
        for (int i = 0; i < floors.size(); i++) {
            floors.get(i).draw();
        }
       ***********************************************************************/ 
        
    }
}