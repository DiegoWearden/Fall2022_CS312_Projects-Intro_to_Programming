import java.util.Scanner;

/**
 * CS312 Assignment 10.
 *
 * On my honor, Diego Wearden, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *  email address: dialwera@gmail.com
 *  UTEID: daw3784
 *  TA name: John Powers
 *  Number of slip days used on this assignment: 2
 *
 * Program that allows two people to play Connect Four.
 */


public class ConnectFour {

    static final int COLUMNS = 7;
    static final int ROWS = 6;
    static final String[] COLUMN_NUMS = {"1 ", "2 ", "3 ", "4 ", "5 ", "6 ", "7 "};
    static final int NUM_PLAYERS = 2;


    public static void main(String[] args) {
        String[][] player = new String[NUM_PLAYERS][NUM_PLAYERS];
        String[][] grid = new String[ROWS][COLUMNS];
        Scanner key = new Scanner(System.in);
        int numRound = 0;
        int status = -1;
        String name = null;
        intro();
        player[0] = askForName(key, 1);
        player[1] = askForName(key, 2);
        while (status < 0) {
            createBoard(grid);
            int playerTurn = numRound % 2;
            name = player[playerTurn][0];
            String color = player[playerTurn][1];
            int columnChoice = askForColumnChoice(key, name, color, grid);
            updateGrid(columnChoice, grid, color);
            status = checkStatus(color, grid); //check for win/draw
            numRound++;
        }
        createFinalBoard(grid, status, name);

        // complete this method
        // Recall make and use one Scanner connected to System.in
    }

    /**
     * if someone wins or draws, creates the final board with accordance
     * @param grid
     * @param status
     * @param name
     */
    private static void createFinalBoard(String[][] grid, int status, String name) {
        if (status > 0) {
            System.out.println(name + " wins!!");
        }
        else if (status == 0) {
            System.out.println("The game is a draw.");
        }
        System.out.println();
        System.out.println("Final Board");
        printGrid(grid);
    }

    /**
     * checks if there is a connect 4
     * also checks each spot for potential draw
     * @param color
     * @param grid
     * @return 1 if win, 0 if draw, -1 if no win or no draw
     */
    private static int checkStatus(String color, String[][] grid) {
        boolean win;
        int drawIdentifier = 0;
        for (int x = 0; x < ROWS; x++) {
            for (int y = 0; y < COLUMNS; y++) {
                if (!grid[x][y].equals(". ")) {
                    drawIdentifier++;
                }
                for (int i = 0; i < 4; i++) {
                    win = winChecker(grid, color, x, y, i);
                    if (win) {
                        return 1;
                    }
                }
                if (drawIdentifier == COLUMNS * ROWS) {
                    return 0;
                }
            }
        }
        return -1;
    }

    /**
     * When sine = 0, check for win on horizontal axis
     * When cosine = 0, check for win on vertical axis
     * When both either 1 or -1, will check for win on the diagonal axis
     * Output for the trig values (1, 0, -1) depend on what i is (the checking direction)
     * @param grid
     * @param color
     * @param x
     * @param y
     * @param i
     * @return 1 if win -1 if no win
     */
    private static boolean winChecker(String[][] grid, String color, int x, int y, int i) {
        int combo = 0;
        for (int j = 0; j < 4; j++){
            int sine = (int) Math.round(Math.sin((Math.PI / 4) * i));
            int cosine = (int) Math.round(Math.cos((Math.PI / 4) * i));
            int rowToCheck = x + (j * sine);
            int columnToCheck = y + (j * cosine);
            if ((columnToCheck >= COLUMNS || columnToCheck < 0) || (rowToCheck >= ROWS || rowToCheck < 0)) {
                j = 5;
            } else if (grid[rowToCheck][columnToCheck].equals(color + " ")) {
                combo++;
                if (combo == 4) {
                    return true;
                }
            }
            else {
                return false;
            }
        }
        return false;
    }

    /**
     * updates the 2d array with the players color in the chosen column
     * @param columnChoice
     * @param grid
     * @param color
     * @return the row that the checker fell into
     */
    private static int updateGrid(int columnChoice, String[][] grid, String color) {
        int row = 0;
        for (int i = 0; i < ROWS; i++) {
            row = (ROWS - 1) - i;
            if (grid[row][columnChoice].equals(". ")) {
                grid[row][columnChoice] = color + " ";
                return row;
            }
        }
        return row;
    }

    /**
     * Asks user to input column choice
     * @param key
     * @param name
     * @param color
     * @param grid
     * @return the integer representing the column choice
     */
    private static int askForColumnChoice(Scanner key, String name, String color, String[][] grid) {
        String prompt = name + ", enter the column to drop your checker: ";
        System.out.println(name + " it is your turn.");
        System.out.println("Your pieces are the " + color + "'s.");
        System.out.print(prompt);
        return validIntChecker(grid, key, prompt);
    }

    /**
     * prints out the board with
     * the contents in the 2d array grid
     * @param grid
     */
    private static void createBoard(String[][] grid) {
        System.out.println("Current Board");
        printGrid(grid);
        System.out.println();
    }

    /**
     * checks if column choice is valid or not
     * @param grid
     * @param key
     * @param prompt
     * @return returns a valid column choice
     */
    private static int validIntChecker(String[][] grid, Scanner key, String prompt) {
        int columnChoice = getInt(key, prompt);
        boolean inGrid = (columnChoice <= COLUMNS && columnChoice > 0);
        while ((!inGrid || !hasSpace(columnChoice, grid))){
            System.out.println();
            if (!inGrid) {
                System.out.println(columnChoice + " is not a valid column.");
            }
            else {
                System.out.println(columnChoice + " is not a legal column. That column is full");
            }
            System.out.print(prompt);
            columnChoice = getInt(key, prompt);
            inGrid = (columnChoice <= COLUMNS && columnChoice > 0);
        }
        System.out.println();
        return columnChoice - 1;
    }

    /**
     * checks if there is any space in chosen column
     * @param columnChoice
     * @param grid
     * @return true if there is space false if not
     */
    private static boolean hasSpace(int columnChoice, String[][] grid) {
        for (int i = 0; i < ROWS; i++){
            if (grid[i][columnChoice - 1].equals(". ")){
                return true;
            }
        }
        return false;
    }

    /**
     * asks player for name and assigns color to player
     * @param keyboard
     * @param playerNum
     * @return array of strings that contains player name and assigned color
     */
    private static String[] askForName(Scanner keyboard, int playerNum) {
        String[] choices = {"r", "b"};
        System.out.print("Player " + playerNum + " enter your name: ");
        String name = keyboard.nextLine();
        String checkerColor = choices[playerNum - 1];
        System.out.println();
        return new String[]{name, checkerColor};
    }

    /**
     * prints out grid using strings in 2d array in main
     * @param grid
     */
    private static void printGrid(String[][] grid) {
        for(int i = 0; i < COLUMNS; i++){
            System.out.print(COLUMN_NUMS[i]);
        }
        System.out.println(" column numbers");
        for (int i = 0; i < ROWS; i++){
            for (int j = 0; j < COLUMNS; j++){
                if (grid[i][j] == null){
                    grid[i][j] = ". ";
                    System.out.print(grid[i][j]);
                }
                else {
                    System.out.print(grid[i][j]);
                }
            }
            System.out.println();
        }
    }

    // CS312 Students, add your methods
    // show the intro
    public static void intro() {
        System.out.println("This program allows two people to play the");
        System.out.println("game of Connect four. Each player takes turns");
        System.out.println("dropping a checker in one of the open columns");
        System.out.println("on the board. The columns are numbered 1 to 7.");
        System.out.println("The first player to get four checkers in a row");
        System.out.println("horizontally, vertically, or diagonally wins");
        System.out.println("the game. If no player gets fours in a row and");
        System.out.println("and all spots are taken the game is a draw.");
        System.out.println("Player one's checkers will appear as r's and");
        System.out.println("player two's checkers will appear as b's.");
        System.out.println("Open spaces on the board will appear as .'s.\n");
    }

    // Prompt the user for an int. The String prompt will
    // be printed out. I expect key is connected to System.in.
    public static int getInt(Scanner key, String prompt) {
        while(!key.hasNextInt()) {
            System.out.println();
            String notAnInt = key.nextLine();
            System.out.println(notAnInt + " is not an integer.");
            System.out.print(prompt);
        }
        int result = key.nextInt();
        key.nextLine();
        return result;
    }
}
