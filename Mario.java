/******************************************************************************
  *  Compilation:  javac Mario.java
  *  Execution:    java Mario (runs basic testing
  *  Dependencies: image files
  *
  *  Creates a Mario object for Donkey Kong Game. Mario can 
  * move, fall, and stop depending on floors inputted. Mario can be checked
  * compared to ladders and floors and barrels objects. Used in World.java
  * 
  * Authors: Ethan Terner, eterner, 206
  *          Max Grove, maxgrove, 205
  *
  ******************************************************************************/
public class Mario {
    private double x;
    private double y;
    private double velX = 0.02;
    private double velY;
    private double jumpVel = 0.012;
    private double accelG = 0.01;
    private static final double halfHeight = 0.025;
    private static final double halfWidth = 0.01;
    private boolean isAlive = true;
    private double floorLevel;
    
    /** Constructor: sets Mario's x and y location
      * 
      */
    public Mario(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    /** Description: returns x location
      * @param n/a
      * @return double x
      */
    public double getX() {
        return x;
    }
    
    /** Description: returns y location
      * @param n/a
      * @return double y
      */
    public double getY() {
        return y;
    }
    
    /** Description: returns y vel
      * @param n/a
      * @return double yVel
      */
    public double getVelY() {
        return velY;
    }
    
    /** Description: returns halfHeight
      * @param n/a
      * @return n/a
      */
    public double getHalfHeight() {
        return halfHeight;
    }
    
    /** Description: returns isAlive
      * @param n/a
      * @return boolean isAlive
      */
    public boolean isAlive() {
        return isAlive;
    }
    
    /** Description: increases x by factor of velX
      * @param n/a
      * @return n/a
      */
    public void moveRight() {
        x += velX;
    }
    
    /** Description: decreases mario's x by velX
      * @param n/a
      * @return n/a
      */
    public void moveLeft() {
        x -= velX;
    }
    
    /** Description: set y location just in case
      * @param n/a
      * @return n/a
      */
    public void setY(double y) {
        this.y = y;
    }
    
    /** Description: draws mario at one of the left facing images
      * @param int dir - which frame mario is at
      * @return n/a
      */
    public void drawLeft(int dir) {
        if (dir % 3 == 0) {
            PennDraw.picture(x, y + 0.01, "marioStand.png", 35, 35);
        } else if (dir % 3 == 1) {
            PennDraw.picture(x, y + 0.01, "marioRun1.png", 35, 35);
        } else if (dir % 3 == 2) {
            PennDraw.picture(x, y + 0.01, "marioRun2.png", 35, 35);
        }
    }
    
    /** Description: draws mario at one of the right facing images
      * @param int dir - which frame mario is at
      * @return n/a
      */
    public void drawRight(int dir) {
        if (dir % 3 == 0) {
            PennDraw.picture(x, y + 0.01, "marioStand.png", -35, 35);
        } else if (dir % 3 == 1) {
            PennDraw.picture(x, y + 0.01, "marioRun1.png", -35, 35);
        } else if (dir % 3 == 2) {
            PennDraw.picture(x, y + 0.01, "marioRun2.png", -35, 35);
        }
    }
    
    /** Description: draws mario standing still
      * @param boolean facing - which direction
      * @return n/a
      */
    public void draw(boolean facing) {
        if (facing) {
            PennDraw.picture(x, y, "marioStand.png", -35, 35);
        } else {
            PennDraw.picture(x, y, "marioStand.png", 35, 35);
        }
    }
    
    /** Description: draws mario as pikachu facing right
      * @param int dir - which frame pikachu is at
      * @return n/a
      */
    public void pDrawRight(int dir) {
        if (dir % 3 == 0) {
            PennDraw.picture(x, y, "pickachu1.png", 35, 35);
        } else if (dir % 3 == 1) {
            PennDraw.picture(x, y, "pickachu2.png", 35, 35);
        } else if (dir % 3 == 2) {
            PennDraw.picture(x, y, "pickachu3.png", 35, 35);
        }
    }
    
    /** Description: draws mario as pikachu facing left
      * @param int dir - which frame pikachu is at
      * @return n/a
      */
    public void pDrawLeft(int dir) {
        if (dir % 3 == 0) {
            PennDraw.picture(x, y, "pickachu1.png", -35, 35);
        } else if (dir % 3 == 1) {
            PennDraw.picture(x, y, "pickachu2.png", -35, 35);
        } else if (dir % 3 == 2) {
            PennDraw.picture(x, y, "pickachu3.png", -35, 35);
        }
    }
    
    /** Description: draws mario as pikachu standing still
      * @param boolean facing - which way pikachu is facing
      * @return n/a
      */
    public void pDraw(boolean facing) {
        if (facing) {
            PennDraw.picture(x, y, "pickachu1.png", 35, 35);
        } else {
            PennDraw.picture(x, y, "pickachu1.png", -35, 35);
        }
    }
    
    /** Description: draws mario climbing
      * @param int dir - which frame pikachu is at
      * @return n/a
      */
    public void drawClimbing(int dir) {
        if (dir % 2 == 0) {
            PennDraw.picture(x, y, "climbingMario.png", 35, 35);
        } else if (dir % 2 == 1) {
            PennDraw.picture(x, y, "climbingMario.png", -35, 35);
        }
    }
    
    /** Description: draws pikachu's lightning
      * @param double x, double y to draw at
      * @return n/a
      */
    public void lightning(double x, double y) {
        PennDraw.picture(x, y, "lightning.PNG", 46, 350);
    } 
    
    /** Description: draws mario in his jumping frame
      * @param boolean facing - which way he is facing
      * @return n/a
      */
    public void drawJump(boolean facing) {
        if (facing) {
            PennDraw.picture(x, y, "marioRun2.png", -35, 35);
        } else {
            PennDraw.picture(x, y, "marioRun2.png", 35, 35);
        }
    }
    
    /** Description: updates marios y vel for jumping feature
      * @param n/a
      * @return n/a
      */
    public void updateY() {
        y += velY;
    }
    
    /** Description: updates marios y vel for jumping feature
      * @param n/a
      * @return n/a
      */
    public void jump() {
        velY = jumpVel; 
    }
    
    /** Description: updates marios y vel for jumping feature
      * @param n/a
      * @return n/a
      */
    public void fall() {
        velY -= 0.001;
    }
    
    /** Description: makes mario stop falling at the closest floor level to him
      * @param Floor[] f
      * @return n/a
      */
    public void stop(Floor[] f) {
        double min = Double.POSITIVE_INFINITY;
        double closest = 0;
        
        //finds minimum between y and f[i].getY()
        //closest = closest of f[i].getY()
        for (int i = 0; i < f.length; i++) {
            double temp = Math.abs(y - f[i].getY());
            if (temp < min) {
                closest = f[i].getY();
                min = temp;
            }   
        }
        y = closest + halfHeight + Floor.getHeight();
        velY = 0.0;
    }
    
    /** Description: checks if marios bottom is connected to any of the floors
      * by calling the floor collision detection
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
    
    /* Descritption: checks if marios x location is within a ladder
     * input: ladder
     * output: boolean true or false
     */
    public boolean ladderCollision(Ladder[] l) {
        for (int i = 0; i < l.length; i++) {
            if(l[i].getX() - 0.015 < x && x < l[i].getX() + 0.015) {
                if (l[i].getY() - 0.075 < y && y < l[i].getY() + 0.1) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /* Description: Moves mario up
     * @param n/a
     * @return n/a
     */
    public void moveUp() {
        y += 0.015;
    }
    
    /* Description: Moves mario down
     * @param n/a
     * @return n/a
     */
    public void moveDown() {
        y -= 0.015;
    }
    
    /* Description: function to check if mario is equivalent to peach's
     * Input: Peach peach
     * Output: boolean
     */
    public boolean hasWon(Peach peach) {
        if (peach.getX() < x + 0.01 && x - 0.01 < peach.getX()) {
            if (peach.getY() < y + 0.015 && y - 0.015 < peach.getY()) {
                return true;
            }
        }
        return false;
    }
    
    /* Description: Checks if mario has collided with any of the barrels and if
     * he has set isAlive to false
     * @param LinkedList<Barrel> b
     * @return n/a
     */
    public void barrelCollision(LinkedList<Barrel> b) {
        int counter = 0;
        
        while (counter < b.size()) {
            if (b.get(counter).getX() < x + 0.02 &&
                x - 0.02 < b.get(counter).getX()) {
                if (b.get(counter).getY() < y + 0.03 &&
                    y - 0.03 < b.get(counter).getY())
                    isAlive = false;
            }
            counter++;
        }
    }
    
    /** Description: checks to ensure marios position is valid. He cannot
      * go off the screen and isAlive is set to false if he falls off the 
      * screen
      * @param n/a
      * @return n/a
      */
    public void checkPosition() {
        if (x > 0.97) {
            x = 0.97;
        } else if (x < 0.03) {
            x = 0.03;
        }
        
        if (y < -0.05) {
            isAlive = false;
        }
    }
   
    //TESTING
    public static void main(String[] args) {
        Floor[] floor = new Floor[2];
        floor[0] = new Floor(0.6, 0.25);
        floor[1] = new Floor(0.4, 0.1);
        
        Mario mario = new Mario(0.5, floor[0].getY() + floor[0].getHeight()
                                    + 0.024); //start at 0.11 for good position
        
        PennDraw.enableAnimation(30);
        
        while(true) { //later make a boolean for if the game is running
            PennDraw.clear(PennDraw.WHITE);
            
            for (int i = 0; i < floor.length; i++ ) {
                floor[i].draw();
            }
            
            //checks for left or right movement
            if (PennDraw.hasNextKeyTyped()) {
                char dir = PennDraw.nextKeyTyped();
                if (dir == 'a') {
                    mario.moveLeft();
                } 
                if (dir == 'd') {
                    mario.moveRight();
                }
                if (dir == 'w') {
                    if (mario.floorCollision(floor))
                        mario.jump();
                }
            }
            
            int counter = 0;
            for (int i = 0; i < floor.length; i++) {
                if ((floor[i].collision(mario))) {
                    counter++;
                    //   System.out.println("colliding");
                }
            }
            if(counter <= 0.0) {
                // System.out.println("he is not colliding with anything");
                mario.fall();
            } else if (mario.velY < 0.0) {
                // mario.stop(floors);
            }
            
            mario.updateY();
            PennDraw.advance();
        }
    }
}