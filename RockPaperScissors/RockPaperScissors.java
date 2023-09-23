import java.util.Scanner;

/**
 *  CS312 Assignment 4.
 *
 *  On my honor, <NAME>, this programming assignment is my own work and I have
 *  not shared my solution with any other student in the class.
 *
 *  A program to play Rock Paper Scissors
 *
 *  Name:Diego Wearden
 *  email address:dialwera@gmail.com
 *  UTEID:daw3784
 *  Section 5 digit ID:52455
 *  Grader name: John Powers
 *  Number of slip days used on this assignment: 1
 */

public class RockPaperScissors {

    /* A program to allow a human player to play rock - paper - scissors
     * against the computer. If args.length != 0 then we assume
     * the first element of args can be converted to an int
     */
    public static final int ROCK = 1;
    public static final int PAPER = 2;
    public static final int SCISSORS = 3;
    static int numDraw = 0;
    static int numWon = 0;
    static int numLost = 0;
    public static void main(String[] args) {
        // CS312 Students. Do not change the following line.
        RandomPlayer computerPlayer = buildRandomPlayer(args);

        // CS312 students do no change the following line. 
        // Do not create any other Scanners.
        Scanner keyboard = new Scanner(System.in);
        String username = getName(keyboard);
        int numRounds = getRounds(keyboard, username);
        playAllRounds(keyboard, username, numRounds, computerPlayer);

        keyboard.close();
    }


    /*
     * Build the random player. If args is length 0 then the
     * default RandomPlayer is built that follows a predictable
     * sequence. If args.length > 0 then we assume we can
     * convert the first element to an int and build the
     * RandomPlayer with that initial value.
     */
    public static RandomPlayer buildRandomPlayer(String[] args) {
        if(args.length == 0) {
            return new RandomPlayer();
        } else {
            int seed = Integer.parseInt(args[0]);
            return new RandomPlayer(seed);
        }
    }

    //method to create username
    //input: ask user for their name
    //output: return username as string
    public static String getName(Scanner keyboard){
        System.out.println("Welcome to ROCK PAPER SCISSORS. I, Computer, " +
                "will be your opponent.");
        System.out.print("Please type in your name and press return: ");
        String username = keyboard.nextLine();
        System.out.println();
        System.out.println("Welcome " + username + ".");
        System.out.println();
        return username;
    }

    // method to ask user for amount of rounds
    //input: user input for number of rounds and username info for dialogue
    //output: return number of rounds as int
    public static int getRounds(Scanner keyboard, String username) {
        System.out.println("All right " + username + ". " +
                "How many rounds would you like to play?");
        System.out.print("Enter the number of rounds you want to " +
                "play and press return: ");
        int numRounds = keyboard.nextInt();
        return numRounds;
    }

    //Calls playOneRound method and runs it numRounds amount of times
    //Then displays the summary results
    private static void playAllRounds(Scanner keyboard, String username,
                                      int numRounds, RandomPlayer computerPlayer){
        for (int i = 1; i <= numRounds; i++) {
            playOneRound(keyboard, username, computerPlayer, i);
        }
        System.out.println();
        System.out.println();
        System.out.println("Number of games of ROCK PAPER SCISSORS: " + numRounds);
        System.out.println("Number of times Computer won: " + numLost);
        System.out.println("Number of times " + username + " won: " + numWon);
        System.out.println("Number of draws: " + numDraw);
        //if human win
        if (numWon > numLost){
            System.out.println("You, " + username + ", are a master " +
                    "at ROCK, PAPER, SCISSORS.");
        }
        //else if computer wins
        else if (numLost > numWon){
            System.out.println("I, Computer, am a master at " +
                    "ROCK, PAPER, SCISSORS.");
        }
        //else draw
        else {
            System.out.println("We are evenly matched.");
        }
    }

    // A single round of the rock paper scissors game
    // gets human and computer choice of rock paper scissors and sends
    // it to compareGuesses method to compare them
    private static void playOneRound(Scanner keyboard, String username,
                                     RandomPlayer computerPlayer, int i){
        System.out.println();
        System.out.println("Round " + i + ".");
        System.out.println(username + ", please enter your choice for this round.");
        System.out.print("1 for ROCK, 2 for PAPER, and 3 for SCISSORS: ");
        int humanChoice = keyboard.nextInt();
        int computerChoice = computerPlayer.getComputerChoice();
        //calls compareGuesses method to determine who won the round
        System.out.println("Computer picked " +
                choiceNameHelper(computerChoice) + ", " +
                username + " picked " + choiceNameHelper(humanChoice) + ".");
        compareGuesses(humanChoice, computerChoice);
    }

    //Choice name helper method
    //Input: some number, 1, 2 or 3
    //Output: a string: rock if 1, paper if 2, scissors if 3
    private static String choiceNameHelper(int choice){
        if (choice == ROCK){
            return "ROCK";
        }
        else if (choice == PAPER){
           return "PAPER";
        }
        else if (choice == SCISSORS){
            return "SCISSORS";
        }
        return "ERROR";
    }

    //method name compare guesses
    //input: computer choice, human choice
    //uses computer choice and human choice to compare the guesses
    //output: print draw, won, lost message
    private static void compareGuesses(int humanChoice, int computerChoice){
        System.out.println();
        //Draw
        if (humanChoice == computerChoice){
            System.out.println("We picked the same thing! This round is a draw.");
            numDraw++;
        }//Computer: Rock, Human: Paper. Human win
        else if (humanChoice == PAPER && computerChoice == ROCK){
            System.out.println("PAPER covers ROCK. You win.");
            numWon++;
        }
        //Computer: Paper, Human: Scissors. Human Win
        else if (humanChoice == SCISSORS && computerChoice == PAPER){
            System.out.println("SCISSORS cut PAPER. You win.");
            numWon++;
        }
        //Computer: Scissors, Human: Rock. Human Win
        else if (humanChoice == ROCK && computerChoice == SCISSORS){
            System.out.println("ROCK breaks SCISSORS. You win.");
            numWon++;
        }
        //Computer: Rock, Human: Scissors. Computer win
        else if (humanChoice == SCISSORS && computerChoice == ROCK){
            System.out.println("ROCK breaks SCISSORS. I win.");
            numLost++;
        }
        //Computer: Paper, Human: Rock. Computer win
        else if (humanChoice == ROCK && computerChoice == PAPER){
            System.out.println("PAPER covers ROCK. I win.");
            numLost++;
        }
        //Computer: Scissors, Human: Paper. Computer win
        else if (humanChoice == PAPER && computerChoice == SCISSORS){
            System.out.println("SCISSORS cut PAPER. I win.");
            numLost++;
        }
    }
}


