/*
 *  CS312 Assignment 2.
 *  On my honor, <Diego Wearden>, this programming assignment is my own work.
 *
 *  A program to print out the UT Tower in ASCII art form.
 *
 *  Name: Diego Warden
 *  email address: dialwera@gmail.com
 *  UTEID: daw3784
 *  Section 5 digit ID:52455
 *  Grader name:
 *  Number of slip days used on this assignment:
 */

public class Tower {

    // CS312 students, DO NOT ALTER THE FOLLOWING LINE except for the
    // value of the literal int.
    // You may change the literal int assigned to SIZE to any value from 2 to 100.
    // In the final version of the program you submit set the SIZE to 3.
    public static final int SIZE = 5;

    // CS312 students, if you add any constants DO NOT include the word SIZE
    // (including any variations on capitilazations such as sIZE, etc.) in
    // the name of that constant. So for example nothing like:
    //
    // public static final int BASE_SIZE2 = 5;
    //
    // If you do, you will flummox our grading script
    // and lose correctness points.

    public static void main(String[] args) {
        drawTop();
        drawWindows();
        drawBottom1();
        drawBottom2();
    }


    //Prints out the number of spaces needed to center the top of the tower
    static void printSpacesTop(){
        System.out.println();
        for (int i = 0; i < 4*SIZE+2; i++) {
            System.out.print(" ");
        }
    }

    //Prints out the number of spaces needed to center the middle of the tower
    static void printSpacesMiddle(){
        System.out.println();
        for (int i = 0; i < SIZE*4; i++) {
            System.out.print(" ");
        }
    }

    //Prints out the top part of the tower
    // in accordance to the value of the input size
    static void drawTop() {

        //Prints out the spaces for the first line
        // and does not call on the method since the first line
        // has no println()
        for (int i = 0; i < 4*SIZE+2; i++) {
            System.out.print(" ");
        }

        //Prints out the correct number of # for the top part
        // of the top of the tower
        for (int i = 0; i < (2*SIZE) - 1; i++) {
            System.out.print("#");
        }

        //Prints out the correct number of | for the top part
        // of the tower
        for (int j = 0; j < (2*SIZE) - 2; j++) {
            printSpacesTop();
            for (int k = 0; k < (2*SIZE) - 1; k++) {
                System.out.print("|");
            }
        }

        //Prints out the correct number of # for the bottom part
        //of the top of the tower
        printSpacesTop();
        for (int i = 0; i < (2*SIZE) - 1; i++) {
            System.out.print("#");
        }

    }

    //Prints out the middle part of the tower with all of the O's
    static void drawWindows(){
        for (int i=0; i < SIZE*SIZE; i++){
        printSpacesMiddle();

        //Prints out the right number of
            // ~ in the middle of the tower
            // in accordance to the size
        for (int k = 0; k < SIZE*2 + 3; k++) {
            System.out.print("~");
        }
        printSpacesMiddle();

        //Prints out a |- at the beginning of
            //each line after the ~ before all of the
            //O- have been printed as the first
            // does not get covered by the other for loop
        System.out.print("|-");

        //Prints out the right number of
            // O- in the middle of the tower
            // in accordance to the size
        for (int g = 0; g < SIZE; g++) {
            System.out.print("O-");
        }
        //Prints out a | at the end of
            // each line after the ~ once all of the
            // O- have been printed
        System.out.print("|");
    }
        printSpacesMiddle();

        //Prints out the last line of
        // ~ as the last line does not get covered
        // by the for loop
        for (int j = 0; j < SIZE*2 + 3; j++) {
            System.out.print("~");
        }
    }

    //Prints out the bottom part on the tower without the O's
    static void drawBottom1(){

        //for loop counts down in order to provide
        // the correct input for the other for loops
        // in this method
        for (int i = SIZE/2; i >= 0;){
            System.out.println();

            //Prints out the required spaces for
            // this part of the tower in accordance to
            // the changing size by making the amount of
            // times this for loop is ran equal to i*3
            // where i given to us by the first for loop in this method
            for (int j = 0; j < i*3; j++) {
                System.out.print(" ");
            }
            System.out.print("/");

            //Prints out the correct number of "' for
            // this part of the tower in accordance to
            // the changing size by making the amount of
            // times this for loop is ran equal to (5 * SIZE) - (3 * i)
            // where i given to us by the first for loop in this method
            for (int k = 0; k < (5 * SIZE) - (3 * i); k++) {
                System.out.print("\"'");
            }
            //Prints out the "\ at the end of each line as the
            // last " does not get covered by the other for loop
            System.out.print("\"\\");

            //subtracts 1 from i for the first for loop at the end of method
            // in order to not change i as an input value
            // before it is used by the other for loops in this method
            i--;
        }
    }

    //Prints out the bottom part on the tower with the O's
    static void drawBottom2(){
        for (int i = 0; i < SIZE; i++){
            System.out.println();

            //Prints out the first / at the beginning
            // of each line
            System.out.print("/");

            //prints out the correct number of "O
            for (int k = 0; k < 5*SIZE; k++) {
                System.out.print("\"O");
            }
            //Prints out the "\ at the end of each line as the
            // last " does not get covered by the other for loop
            System.out.print("\"\\");
        }
    }
}