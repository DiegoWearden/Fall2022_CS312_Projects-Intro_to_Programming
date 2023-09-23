import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * CS312 Assignment 6
 * 
 * On my honor, <Diego Wearden>, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to play determine the extend of home field advantage in sports.
 *
 *  email address:dialwera@gmail.com
 *  UTEID:daw3784
 *  Unique 5 digit course ID: 52455
 *  Grader name: John Powers
 *  Number of slip days used on this assignment: 0
 */
 
 /**
 * Data from 14 input files and analysis of Home Field Advantage go here.
 *
  * **********   College Football --- 2005   **********
  *
  * HOME FIELD ADVANTAGE RESULTS
  *
  * Total number of games: 4,069
  * Number of games with a home team: 3,955
  * Percentage of games with a home team: 97.2%
  * Number of games the home team won: 2,257
  * Home team win percentage: 57.1%
  * Home team average margin: 4.24
  *
  * **********   College Football --- 2008   **********
  *
  * HOME FIELD ADVANTAGE RESULTS
  *
  * Total number of games: 4,702
  * Number of games with a home team: 4,592
  * Percentage of games with a home team: 97.7%
  * Number of games the home team won: 2,617
  * Home team win percentage: 57.0%
  * Home team average margin: 4.28
  *
  * **********   NCAA Men's Basketball --- 2011 - 2012   **********
  *
  * HOME FIELD ADVANTAGE RESULTS
  *
  * Total number of games: 15,842
  * Number of games with a home team: 14,481
  * Percentage of games with a home team: 91.4%
  * Number of games the home team won: 9,178
  * Home team win percentage: 63.4%
  * Home team average margin: 5.37
  *
  * **********   NCAA Men's Basketball --- 2013 - 2014   **********
  *
  * HOME FIELD ADVANTAGE RESULTS
  *
  * Total number of games: 16,219
  * Number of games with a home team: 14,754
  * Percentage of games with a home team: 91.0%
  * Number of games the home team won: 9,276
  * Home team win percentage: 62.9%
  * Home team average margin: 5.18
  *
  * **********   Major League Baseball --- 2012   **********
  *
  * HOME FIELD ADVANTAGE RESULTS
  *
  * Total number of games: 2,467
  * Number of games with a home team: 2,465
  * Percentage of games with a home team: 99.9%
  * Number of games the home team won: 1,312
  * Home team win percentage: 53.2%
  * Home team average margin: 0.16
  *
  * **********   College Men's Soccer --- 2006   **********
  *
  * HOME FIELD ADVANTAGE RESULTS
  *
  * Total number of games: 8,380
  * Number of games with a home team: 7,373
  * Percentage of games with a home team: 88.0%
  * Number of games the home team won: 3,962
  * Home team win percentage: 53.7%
  * Home team average margin: 0.51
  *
  * **********   NCAA Women's Basketball --- 1999 - 2000   **********
  *
  * HOME FIELD ADVANTAGE RESULTS
  *
  * Total number of games: 4,607
  * Number of games with a home team: 4,345
  * Percentage of games with a home team: 94.3%
  * Number of games the home team won: 2,696
  * Home team win percentage: 62.0%
  * Home team average margin: 5.60
  *
  * **********   NCAA Women's Basketball --- 2004 - 2005   **********
  *
  * HOME FIELD ADVANTAGE RESULTS
  *
  * Total number of games: 14,687
  * Number of games with a home team: 13,261
  * Percentage of games with a home team: 90.3%
  * Number of games the home team won: 8,043
  * Home team win percentage: 60.7%
  * Home team average margin: 4.95
  *
  * **********   NCAA Women's Basketball --- 2011 - 2012   **********
  *
  * HOME FIELD ADVANTAGE RESULTS
  *
  * Total number of games: 14
  * Number of games with a home team: 9
  * Percentage of games with a home team: 64.3%
  * Number of games the home team won: 6
  * Home team win percentage: 66.7%
  * Home team average margin: 6.00
  *
  * **********   NCAA Women's Basketball --- 2011 - 2012   **********
  *
  * HOME FIELD ADVANTAGE RESULTS
  *
  * Total number of games: 15,640
  * Number of games with a home team: 14,303
  * Percentage of games with a home team: 91.5%
  * Number of games the home team won: 8,496
  * Home team win percentage: 59.4%
  * Home team average margin: 4.41
  *
  * **********   NCAA Women's Basketball --- 2012 - 2013   **********
  *
  * HOME FIELD ADVANTAGE RESULTS
  *
  * Total number of games: 15,722
  * Number of games with a home team: 14,341
  * Percentage of games with a home team: 91.2%
  * Number of games the home team won: 8,512
  * Home team win percentage: 59.4%
  * Home team average margin: 4.23
  *
  * **********   NCAA Women's Basketball --- 2013 - 2014   **********
  *
  * HOME FIELD ADVANTAGE RESULTS
  *
  * Total number of games: 15,790
  * Number of games with a home team: 14,305
  * Percentage of games with a home team: 90.6%
  * Number of games the home team won: 8,471
  * Home team win percentage: 59.2%
  * Home team average margin: 4.24
  *
  * **********   NCAA Women's Soccer --- 2010   **********
  *
  * HOME FIELD ADVANTAGE RESULTS
  *
  * Total number of games: 10,593
  * Number of games with a home team: 9,941
  * Percentage of games with a home team: 93.8%
  * Number of games the home team won: 5,392
  * Home team win percentage: 54.2%
  * Home team average margin: 0.51
  *
  * Analysis:
  * The data shows that in general, the home teams wins
  * more often then the away team. However, there is
  * a lot of variation between different sports. For example,
  * in college football, the home team won 57.1% of games in
  * 2005 and 57.0% of games in 2008. In Major League Baseball,
  * the home team won 53.2% of games in 2012. in NCAA women's
  * basketball, the home team won 62.0% of games in 1999-2000
  * and 59.4% of games in 2011-2012. There does not seem to be
  * a clear trend over time either; for example, in NCAA women's
  * basketball, the home team's winning percentage has fluctuated
  * between 66.7% and 59.2% over the span of 15 years. The margin of
  * victory also varies between sports, with the home team averaging
  * a 4.24 point margin of victory in college football and a 0.51
  * point margin of victory in NCAA women's soccer, but this
  * could also be due to the nature of the sport (football is a
  * higher scoring sport then soccer). One thing we could take from
  * this is that the average margin seems to always be positive for
  * the home team, meaning that they win more often then they lose.
  * Overall, the evidence suggests that home field advantage does
  * exist, however, it varies greatly in terms of its magnitude.
 */
 
public class HomeField {

     // Ask the user for the name of a data file and process
     // it until they want to quit.
     public static void main(String[] args) throws IOException {
         System.out.println("A program to analyze home field advantage in sports.");
         System.out.println();
         // CS312 students. Do not create any other Scanners connected to System.in.
         // Pass keyboard as a parameter to all the methods that need it.
         Scanner keyboard = new Scanner(System.in);
         String processAgain = "Y";
         // While string "processAgain" continues
         // to equal Y (if the user changes it)
         // continue to ask user for another file
         // and process another file
         while (processAgain.equals("Y")) {
             Scanner fileName = askForFileName(keyboard);
             printOutputFileHeader(fileName);
             fileAnalysis(fileName);
             processAgain = askUserForAnotherFile(keyboard);
         }

         // CS312 students - Add your code here

         keyboard.close();
     }

     // asks to enter file name
     //if file name not valid, enter while loop to ask user for valid file name
     // return file name if file name exist
     public static Scanner askForFileName(Scanner keyboard) throws IOException {
         while (true) {
             System.out.print("Enter the file name: ");
             File fileName = new File(keyboard.nextLine());
             if (!fileName.exists()) {
                 System.out.println("Sorry, that file does not exist");
             } else if (fileName.exists()) {
                 return new Scanner(fileName);
             }
         }
     }

     // prints the header for the output file
     public static void printOutputFileHeader(Scanner fileName) {
         System.out.println();
         System.out.println("**********   " + fileName.nextLine() + " --- "
                 + fileName.nextLine() + "   **********");
         System.out.println();
         System.out.println("HOME FIELD ADVANTAGE RESULTS");
         System.out.println();
     }

     // analyzes file and determines the amount of points for home team
     // and away team
     public static void fileAnalysis(Scanner fileName) {
         int numGames = 0;
         int numHomeGames = 0;
         int numHomeGameWins = 0;
         int totalHomePoints = 0;
         int totalAwayPoints = 0;
         while (fileName.hasNextLine()) {
             String currentString = fileName.nextLine();
             numGames++;
             // if the line have and @ then it checks for how many
             // points the away team had and counts 1 for the number
             // of home games because the game has a home game
             if (currentString.contains("@")) {
                 numHomeGames++;
                 int homePoints = getHomePoints(currentString);
                 int awayPoints = getAwayPoints(currentString);
                 if (homePoints > awayPoints) {
                     numHomeGameWins++;
                 }
                 // accumulates home points and to later use them
                 // to calculate average margin
                 totalHomePoints += homePoints;
                 totalAwayPoints += awayPoints;
             }
         }
         double homeTeamPercentage = (((double) numHomeGames) / numGames) * 100;
         double homeTeamWinPercentage = (((double) numHomeGameWins) / numHomeGames) * 100;
         // uses formula of average margin to calculate it
         double homeTeamAverageMargin = (totalHomePoints - totalAwayPoints) / (double) numHomeGames;
         printFileAnalysis(numGames, numHomeGames, numHomeGameWins,
                 homeTeamPercentage, homeTeamWinPercentage, homeTeamAverageMargin);
         fileName.close();
     }

     // checks for which team is the home team and
     // returns the score number
     public static int getHomePoints(String currentString) {
         int home = 0;
         Scanner stringScannerHome = new Scanner(currentString);
         String parsedStringHome;
         while (stringScannerHome.hasNext()) {
             parsedStringHome = stringScannerHome.next();
             if (parsedStringHome.contains("@")) {
                 home = homeTeamChecker(stringScannerHome).nextInt();
             }
         }
         stringScannerHome.close();
         return home;
     }

     // checks for which team is the away team and
     // returns the score number
     // checks to see which is the home team to ensure it does
     // not take up that value as the away teams value
     public static int getAwayPoints(String currentString) {
         int away;
         Scanner stringScannerAway = new Scanner(currentString);
         String parsedStringAway;
         while (stringScannerAway.hasNext() && !stringScannerAway.hasNextInt()) {
             parsedStringAway = stringScannerAway.next();
             if (parsedStringAway.contains("@")) {
                 homeTeamChecker(stringScannerAway).nextInt();
             }
         }
         away = stringScannerAway.nextInt();
         stringScannerAway.close();
         return away;
     }

     // if the string has an @, the go through all words
     // until you hit a number
     public static Scanner homeTeamChecker(Scanner stringScanner) {
         while (!stringScanner.hasNextInt()) {
             stringScanner.next();
         }
         return stringScanner;
     }

     // prints the data that the file analyzed formatted
     public static void printFileAnalysis(int numGames, int numHomeGames, int numHomeGameWins,
                                          double homeTeamPercentage, double homeTeamWinPercentage,
                                          double homeTeamAverageMargin) {
         System.out.printf("Total number of games: %,d\n" +
                         "Number of games with a home team: %,d\n" +
                         "Percentage of games with a home team: %.1f%%\n" +
                         "Number of games the home team won: %,d\n" +
                         "Home team win percentage: %.1f%%\n" +
                         "Home team average margin: %,.2f\n",
                 numGames, numHomeGames, homeTeamPercentage, numHomeGameWins,
                 homeTeamWinPercentage, homeTeamAverageMargin);
     }

     // Asks user if file they want to process another file
     // and returns their input
     public static String askUserForAnotherFile(Scanner keyboard) {
         System.out.println();
         System.out.println("Do you want to check another data set?");
         System.out.print("Enter Y or y to analyze another file, anything else to quit: ");
         String processAgain = keyboard.nextLine().toUpperCase();
         System.out.println();
         return processAgain;
     }
     // CS312 Students - Add your methods here.
 }
