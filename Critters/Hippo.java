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

public class Hippo extends Critter{
    public int hunger;
    public int counter;
    public int random;
    public Hippo(int hunger){
        this.hunger = hunger;
        this.counter = 5;
    }

    @Override
    public boolean eat() {
        if (this.hunger > 0){
            this.hunger--;
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public Critter.Attack fight(String opponent) {
        if (this.hunger > 0){
            return Attack.SCRATCH;
        }
        else{
            return Critter.Attack.POUNCE;
        }
    }
    @Override
    public Color getColor() {
        if (this.hunger > 0){
            return Color.GRAY;
        }
        else{
            return Color.WHITE;
        }
    }
    @Override
    public Critter.Direction getMove() {
        this.counter++;
        if (this.counter > 4){
            this.counter = 0;
            this.random = (int) ((Math.random() * 4 + 1));
        }
        if (this.random == 1){
            return Direction.SOUTH;
        }
        else if (this.random == 2){
            return Direction.EAST;
        }
        else if (this.random == 3){
            return Direction.NORTH;
        }
        else {
            return Direction.WEST;
        }
    }
    @Override
    public String toString(){
        return "" + this.hunger;
    }
}
