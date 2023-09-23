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

public class Bird extends Critter{
    public int counter;
    public Bird(){
        this.counter = 0;
    }

    @Override
    public Critter.Attack fight(String opponent) {
        if (opponent.equals("%")){
            return Critter.Attack.ROAR;
        }
        else{
            return Critter.Attack.POUNCE;
        }
    }
    @Override
    public Color getColor() {
        return Color.BLUE;
    }
    @Override
    public Critter.Direction getMove() {
        this.counter++;
        if (this.counter >= 0 && this.counter < 4){
            return Critter.Direction.NORTH;
        }
        else if(this.counter >= 4 && this.counter < 7){
            return Critter.Direction.EAST;
        }
        else if(this.counter >= 7 && this.counter < 10){
            return Critter.Direction.SOUTH;
        }
        else{
            return Critter.Direction.WEST;
        }
    }
    @Override
    public String toString(){
        if (this.counter >= 0 && this.counter < 4){
            return "^";
        }
        else if(this.counter >= 4 && this.counter < 7){
            return ">";
        }
        else if(this.counter >= 7 && this.counter < 10){
            return "V";
        }
        else{
            if (this.counter == 12){
                this.counter = 0;
            }
            return "<";
        }
    }
}
