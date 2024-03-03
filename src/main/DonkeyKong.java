package main;

/******************************************************************************
  *  Compilation:  javac DonkeyKong.java
  *  Execution:    java DonkeyKong
  *  Dependencies: image files
  *
  *  Creates a DonkeyKong object for Donkey Kong Game. Donkey can 
  * be drawn in various positions. Used in World.java
  * 
  * Authors: 
  *          Max Grove, maxgrove, 205
  *	     Ethan Terner, eterner, 206
  ******************************************************************************/
public class DonkeyKong {
    private double x;
    private double y;
    
    /** Constructor: donkey kong at x, y
     */
    public DonkeyKong(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /** Descritpion: get x
     * @param n/a
     * @return double x
     */
    public double getX() {
        return x;
    }
    
    /** Descritpion: get y
     * @param n/a
     * @return double y
     */
    public double getY() {
        return y;
    }
    
    /** Descritpion: draws donkeykong facing left
     * @param n/a
     * @return n/a
     */
    public void drawLeft() {
        PennDraw.picture(x, y, "/resources/graphics/donkeyLeft.png", 60, 47);
    }
    
    /** Descritpion: draws donkey kong facing center with a barrel
     * @param n/a
     * @return n/a
     */
    public void drawCenter() {
        PennDraw.picture(x, y, "/resources/graphics/donkey.png", 60, 47);
    }
    
    /** Descritpion: draws donkey kong facing right
     * @param n/a
     * @return n/a
     */
    public void drawRight() {
        PennDraw.picture(x, y, "/resources/graphics/donkeyRight.png", 60, 47);
    }
    
    /** Descritpion: draws donkey kong standing normally
     * @param n/a
     * @return n/a
     */
    public void drawOriginal() {
        PennDraw.picture(x, y, "/resources/graphics/donkeyCenter.png", 60, 47);
    }
    
    public static void main(String[] args) {
        DonkeyKong d = new DonkeyKong(0.5, 0.5);
        d.drawLeft();
        d.drawCenter();
        d.drawRight();
    }
}