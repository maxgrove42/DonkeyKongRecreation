## Max Grove's and Ethan Terner's Donkey Kong Arcade - Recreation

This project is a modified version of the classic Donkey Kong arcade game. Players control a character with the goal of navigating through obstacles to rescue the princess at the top of the screen.

### Prerequisites
- Java Development Kit (JDK) installed on your system.

### How to Run
1. Compile all the `.java` files in the project directory.
2. Open `World.java` in your Java IDE or command line.
3. In the IDE's interactions pane or command line, type `java World` to start the game.
4. Follow the on-screen instructions for controls and gameplay.

### Gameplay Instructions
- Use `a` to move the character left, `d` to move right.
- Press `w` to jump or climb ladders, and `s` to move down ladders.
- Upon reaching the third floor, the character transforms into Pikachu, which can destroy barrels with a lightning bolt by pressing `f`.
- The objective is to reach Princess Peach at the top. The game ends if the character collides with a barrel or falls off the screen.

### Features
- Transition from Mario to Pikachu on the third floor.
- Interactive objects: barrels, DonkeyKong, floors, ladders, Mario/Pikachu, Peach, and the game world.
- Background music and sound effects for jumping, winning, and losing.

### Notes
- Pay attention to the character's ability to change into Pikachu and the lightning attack mechanic.
- Observe the game's handling of collision and object interactions.
- Music continues playing until the Standard Draw window is closed.
- After winning or losing, press 'y' to restart or 'n' to exit the game.

### Detailed Description
This project runs a modified version of Donkey Kong arcade where the user controls a character aiming to reach the top of the screen and collide with the princess, with the game ending upon collision with a barrel or falling off the screen; upon reaching the third floor, the character transforms from Mario to Pikachu, who can destroy barrels directly above him with a specific keypress.

The program includes objects such as a barrel, DonkeyKong, floors, ladders, a Mario figure (which can also be depicted as Pikachu), a Peach figure, and the World (a static main function, not an object), with DonkeyKong being the only non-interactive object; most interactions are managed by the Mario object, which checks for collisions with ladders, barrels, and Peach, while floors check for collisions with Mario and barrels, leading to a decision to integrate Pikachu as part of the Mario object due to functional similarities, focusing on drawing changes.
    
    
Classes/objects are structured with essential functions for each: Mario can be depicted or as Pikachu, check for collisions, fall, climb, and trigger a lightning ability as Pikachu, including verifying contact with a floor through the corresponding floor function.
        
Peach, Ladder, and DonkeyKong have only draw and location getter functions with constructors setting their x, y locations; the Barrel features a falling function (altering its floorlevel), a stop falling function, and various movement functions; the Floor includes drawing, getting, and collision functions, checking for collisions with barrels and Mario for ease of interaction; the World function orchestrates the game by combining all objects.

The techniques used include collision detection among various objects (floors check for collisions with barrels and Mario based on their x and y locations to determine "standing"), and in the main World, nested while loops await user input for instructions and replay options, with looping through barrels using the get() function, further detailed in the LinkedLists section.
    
Mario can be drawn as Pikachu or Mario based on his y location, and barrels are removed with Pikachu's lightning feature using a true/false operator to check if lightning is activated and if the x position falls within a specific range.
    
In order to account for imperfect numbers, we hardcoded a few "error-tolerance" values.
    
We implemented a timer feature to keep track of what frame we are on - looping frames every 180 frames. This was to keep a constant creation time of barrels and drawing various donkey kong images.
    
We used ALGORITHMS such as finding the minimum of several values and looping through a linkedlist.
 
This code could be EXPANDED with more levels, like in the original game. It would only involve changing the code at the top of World’s main function involving the ladders and floors and original locations. Once the original locations and where to draw objects are changed, you have a whole new level! One could add more ladders, less ladders, more floors, different floor locations, and more.

This code is relatively EFFICIENT. It uses a linkedlist to get rid of unused barrels. (this is touched on later on how it is the most efficient method to use) It uses while loops to check things numerous times so may not be able to be run on an older computer, but this will not affect most users with relatively recent technology. The many while loops all have computational complexity of O(n), which is the fastest that it can be for this sort of program where many n objects have to be drawn. We don’t have to sort anything and combined various functions into one while loop to make more efficient. In addition, because PennDraw.enableAnimation() is used, the user doesn’t see changes until all changes for one frame have been made.


The CHALLENGES of this program included removing barrels when mario (pikachu) uses it’s lightning bolt ability. Making barrels fall down floor was difficult but we used collision detection and a falling function similar to mario’s jump function. The simple drawing was much easier.    

OPEN PROBLEMS: on some computers, if mario tries to jump onto a ladder, that is, he tries to jump up and then move over to a ladder, the code manually overrides his position and flashes him to the top.                                                     
