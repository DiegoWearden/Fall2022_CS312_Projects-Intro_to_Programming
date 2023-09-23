import java.awt.*;
import java.io.IOException;

/**
 * CS312 Assignment 3.
 *
 * Replace <NAME> with your name, stating on your honor you completed this
 * assignment on your own and that you didn't share your code with other
 * students.
 *
 * On my honor, <Diego Wearden>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to print out various scintillation grids and a student designed drawing.
 *
 *  email address: dialwera@gmail.com
 *  UTEID: daw3784
 *  Number of slip days I am using on this assignment: 0
 */

public class ScintillationGrid {

    // Main method that creates the DrawingPanel with scintillation grids.
    // Restricted to chapters 1 - 3 of Building Java Programs
    public static void main(String[] args) {
        /* In the final version of the program DO NOT call method drawingOne
           from main or anywhere else in the program */
        final int WIDTH = 950;
        final int HEIGHT = 650;
        DrawingPanel dp = new DrawingPanel(WIDTH, HEIGHT);
        drawGrids(0, 0, 348, 75, 16, 3, dp);
        drawGrids(400, 50, 422, 50, 12, 6, dp);
        drawGrids(50, 400, 220, 100, 20, 1, dp);
        drawGrids(500, 500, 148, 15, 4, 7, dp);


        // CS312 Students add you four methods calls to draw the four
        // required scintillation grids here.


        // CS312 students, do not alter the following line of code.
        saveDrawingPanel(dp, "grid.png");
    }


    // Save the current drawing panel to the given file.
    // CS312 Students, do not alter this method.
    public static void saveDrawingPanel(DrawingPanel dp, String fileName) {
        try {
            dp.save(fileName);
        } catch (IOException e) {

            System.out.println("Unable to save DrawingPanel");
        }
    }

    // Changes the background color of the drawing panel to cyan
    static void setBackgroundColor(DrawingPanel dp) {
        dp.setBackground(Color.CYAN);
    }

    // Draws the 4 large black squares using the
    // parameters described in the main method
    // as input values for this method using a
    // given x and y value that describes its position,
    // and square size.
    static void drawSquares(int x, int y, int bigSquareSize, DrawingPanel dp) {
        Graphics g = dp.getGraphics();
        g.setColor(Color.BLACK);
            g.fillRect(x, y, bigSquareSize, bigSquareSize);
    }

    // Draws gray grids on top of the 4 black squares using the parameters
    // described in the main method
    // using a given x and y values that describes its position,
    // the large black square size,
    // the small squares size made by the
    // grid how thick the line that make the grids make are,
    // and how many lines there are on each big
    // square to make the grid either only
    // horizontally or only vertically.
    static void drawGrids(int x, int y, int bigSquareSize, int smallSquareSize,
                          int lineThickness, int lineNumber, DrawingPanel dp) {
        setBackgroundColor(dp);
        drawSquares(x, y, bigSquareSize, dp);
        Graphics g = dp.getGraphics();
        g.setColor(Color.GRAY);
        for (int i = 0; i < lineNumber; i++) {
            g.fillRect(x, y+smallSquareSize + (i * (smallSquareSize
                    +lineThickness)), bigSquareSize, lineThickness);
            g.fillRect(x+smallSquareSize + (i * (smallSquareSize
                    +lineThickness)), y, lineThickness, bigSquareSize);
        }
        drawCircles(x, y, smallSquareSize, lineThickness, lineNumber, dp);

    }

    // Draws the white circles on the intersection on each of the grids
    // using the parameters described in the main method as input values
    // for this method using a given x and y value that describes their position,the
    // small squares size made by the grid, how thick the lines that
    // make the grids make are, and how many horizontal or vertical
    // lines there are on each big square to make the grid.
    static void drawCircles(int x, int y, int smallSquareSize,
                            int lineThickness, int lineNumber, DrawingPanel dp) {
        Graphics g = dp.getGraphics();
        g.setColor(Color.WHITE);
        int extraBit = (int) ((Math.sqrt(((Math.pow(lineThickness, 2))+
                        (Math.pow(lineThickness, 2))))-lineThickness)/2);
        for (int i = 0; i < lineNumber; i++) {
            for (int j = 0; j < lineNumber; j++) {
                g.fillOval(smallSquareSize-extraBit + ((smallSquareSize
                        + lineThickness) * i)+x, smallSquareSize-extraBit
                        + (smallSquareSize + lineThickness)*j+y, lineThickness +
                        (extraBit*2), lineThickness+(extraBit*2));
            }
        }
    }
}
