/**
 * CS312 Assignment 7 - Personality Quiz
 * 
 * On my honor, Diego Wearden, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * A program to read a file with raw data from a Keirsey personality test
 * and print out the results.
 *
 *  email address: dialwera@gmail.com
 *  UTEID: daw3784
 *  TA name: John Powers
 *  Number of slip days used on this assignment: 0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Personality {
    
    // CS312 Student- Add your constants here.

    // The main method to process the data from the personality tests
    public static void main(String[] args) {
        // do not make any other Scanners connected to System.in
        Scanner keyboard = new Scanner(System.in);
        Scanner fileScanner = getFileScanner(keyboard);

        // CS312 students - your code and methods calls go here
        int numPeople = fileScanner.nextInt();
        fileScanner.nextLine();
        for (int i = 0; i < numPeople; i++){
            String name = fileScanner.nextLine();   // Get name of person from file
            String answers = fileScanner.nextLine(); // Get person's answers
            int[] percentages = processAnswers(answers); // Get percentage of B's for each characteristic
            String personalityType = getLetters(percentages);   // Compute their string personality (i.e. ILTP)
            printResults(name, percentages, personalityType);   // Print person's results
        }
        fileScanner.close();
        keyboard.close();
    }

    /**
     * builds personality type string and returns it as string
     * @param percentages Percentage of questions answered B for each characteristic
     * @return the built personality type as a string
     */
    public static String getLetters(int[] percentages){
        String[] personalityLetters = new String[]{"EI", "SN", "TF", "JP"};
        String letters = "";
        for (int i = 0; i < percentages.length; i++){
            if (percentages[i] == -1){
                letters += "-";
            }
            else if (percentages[i] < 50){
                letters += personalityLetters[i].charAt(0);
            }
            else if (percentages[i] > 50){
                letters += personalityLetters[i].charAt(1);
            }
            else {
                letters += "X";
            }
        }
        return letters;
    }

    /**
     * Gets number of questions answered B for each characteristic
     * and total questions answered
     * @param answers String of persons answers to quiz
     * @return Percentage of questions answered B for each characteristic
     */
    public static int[] processAnswers(String answers){
        double[] numBs = new double[4];
        double[] totalResponses = new double[4];
        int characteristic;
        for (int i = 0; i < answers.length(); i++){
            if (i % 7 == 0){ // i modulo 7 to iterate through numbers 1-7 with for loop
                characteristic = 0;
            }
            else if (i % 7 == 1 || i % 7 ==2){
                characteristic = 1;
            }
            else if (i % 7 == 3 || i % 7 ==4){
                characteristic = 2;
            }
            else {
                characteristic = 3;
            }
            char charToCheck = answers.toUpperCase().charAt(i);
            if (charToCheck != '-'){ // if there is an answer
                totalResponses[characteristic]++;
                if (charToCheck == 'B'){
                    numBs[characteristic]++;
                }
            }
        }
        return getPercentages(numBs, totalResponses);
    }

    /**
     * Returns the percentage of questions answered "B"
     * @param numBs number of questions answered B
     * @param totalResponses total number of questions answered
     * @return percentage of questions answered B
     */
    public static int[] getPercentages(double[] numBs, double[] totalResponses){
        int[] percentages = new int[totalResponses.length];
        for (int i = 0; i < percentages.length; i++){
            if (totalResponses[i] == 0){
                percentages[i] = -1;  // -1 if no responses
            }
            else {
                percentages[i] = (int) (((numBs[i] / totalResponses[i]) * 100) + 0.5);
            }
        }
        return percentages;
    }

    /**
     * Prints results of personality with a right-justification
     * @param name The name of the person being analyzed
     * @param percentages Percentage of questions answered B for each characteristic
     * @param personalityType String that describes the personality type of the person
     */
    public static void printResults(String name, int[] percentages, String personalityType){
        String[] percentAsString = new String[percentages.length];
        for (int i = 0; i < percentages.length; i++){
            if (percentages[i] == -1){
                percentAsString[i] = "NO ANSWERS";
            }
            else {
                percentAsString[i] = "" + percentages[i];
            }
        }
        System.out.printf("%30s:%11s%11s%11s%11s = %s\n", name, percentAsString[0], percentAsString[1],
                percentAsString[2], percentAsString[3], personalityType);
    }

    // Method to choose a file.
    // Asks user for name of file. 
    // If file not found create a Scanner hooked up to a dummy set of data
    // Example use: 
    public static Scanner getFileScanner(Scanner keyboard){
        Scanner result = null;
        try {
            System.out.print("Enter the name of the file with"
                    + " the personality data: ");
            String fileName = keyboard.nextLine().trim();
            System.out.println();
            result = new Scanner(new File(fileName));
        } catch(FileNotFoundException e) {
            System.out.println("Problem creating Scanner: " + e);
            System.out.println("Creating Scanner hooked up to default data " 
                    + e);
            String defaultData = "1\nDEFAULT DATA\n"
                + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
                + "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
            result = new Scanner(defaultData);
        }
        return result;
    }
}
