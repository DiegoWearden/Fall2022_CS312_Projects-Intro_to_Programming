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

public class Longhorn extends Critter{
    private int counter;
    private int random;
    public Longhorn(){
        this.counter = 5;
    }

    @Override
    public boolean eat() {
        return true;
    }

    @Override
    public Critter.Attack fight(String opponent) {
        for (int i = 0; i < 10; i++){
            String num = String.valueOf(i);
            if (opponent.equals("%")){
                return Attack.ROAR;
            }
            else if (opponent.equals("^") || opponent.equals(">") || opponent.equals("V") || opponent.equals("<")){
                return Attack.SCRATCH;
            }
            else if (opponent.equals("S")){
                return Attack.POUNCE;
            }
            else if(opponent.equals(num)){
                if (opponent.equals("0")){
                    return Attack.SCRATCH;
                }
                else {
                    return Attack.ROAR;
                }
            }

        }
        return Attack.ROAR;
    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    @Override
    public Critter.Direction getMove() {
        this.counter++;
        if (this.counter > 1){
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
        return "☭";
    }

    @Override
    public void lose() {
        super.win();
    }
}
