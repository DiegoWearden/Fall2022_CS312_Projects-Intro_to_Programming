/*
 * CS312 Assignment 10.
 *
 * On MY honor, Diego Wearden, this programming assignment is MY own work
 * and I have not provided this code to any other student.
 *
 * Student name: Diego Wearden
 * UTEID: daw3784
 * email address: dialwera@gmail.com
 * Grader name: John Powers
 * Number of slip days used on this assignment:
 *
 */


import java.awt.*;

public class Ant extends Critter{
    private boolean walkSouth;
    public int counter;
    public Ant(boolean walkSouth){
        this.walkSouth = walkSouth;
        this.counter = -1;
    }
    @Override
    public boolean eat() {
        return true;
    }
    @Override
    public Attack fight(String opponent) {

        return Attack.SCRATCH;
    }
    @Override
    public Color getColor() {
        return Color.RED;
    }
    @Override
    public Direction getMove() {
        this.counter++;
        if (this.walkSouth && this.counter % 2 == 0){
            return Direction.SOUTH;
        }
        else if(!this.walkSouth && this.counter % 2 == 0){
            return Direction.NORTH;
        }
        else{
            return Direction.EAST;
        }
    }
    @Override
    public String toString(){
        return "%";
    }

}
