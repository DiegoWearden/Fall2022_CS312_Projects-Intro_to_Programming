/**
 * CS312 Assignment 6
 *
 * On my honor, <Diego Wearden>, this programming assignment is my own work
 * and I have not shared my solution with any other student in the class.
 *
 * A program to play Hangman.
 *
 * Email address: dialwera@gmail.com
 * UTEID: daw3784
 * Unique 5 digit course ID: 52455
 * Number of slip days used on this assignment: 1
 * 
 * Estimated hours for this assignment: 10
 * Actual hours for this assignment: 24
 */

import java.util.Scanner;

public class Hangman {

    public static void main(String[] args) {
        // Load phrases from a file into the phrases variable
        PhraseBank phrases = buildPhraseBank(args);
        Scanner keyboard = new Scanner(System.in);
        // Print the intro to the program.
        intro();
        String playAgain = "Y";
        // while playAgain is equal to "Y" (user want to play again), the game restarts
        while (playAgain.equals("Y")) {
        playGame(phrases, keyboard);
        // if the user does not input "y", the while loop ends and whole program
        playAgain = ((keyboard.nextLine()).toUpperCase());
        }
        keyboard.close();
    }

    // Goal: make this method the main method that calls other
    // methods to make the game work
    // arguments: phrases, keyboard
    // no output or return statement
    public static void playGame(PhraseBank phrases, Scanner keyboard){
        String unguessedLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int wrongGuesses = 0;
        System.out.println();
        System.out.println("I am thinking of a " + phrases.getTopic() + " ...");
        System.out.println();
        String phrase = phrases.getNextPhrase();
        String maskedPhrase = currentPhrase(phrase);
        // while the user has not lost or won, continue game
        while (wrongGuesses != 5 && !maskedPhrase.equals(phrase)) {
            System.out.println("The current phrase is " + maskedPhrase);
            System.out.println();
            // sets letter guessed equal to an input set by user,
            // weather that input is a character or not
            String letterGuessed = enterNextGuess(unguessedLetters,
                    keyboard);
            // gets the current value of variable letterGuessed
            // and checks if it's valid or not and
            // replaces variable letterGuessed with new valid
            // character if previously invalid
            letterGuessed = validGuessChecker(unguessedLetters,
                    letterGuessed, keyboard);
            // removes guessed letters from the string "unguessedLetters"
            unguessedLetters = removeGuessedLetters(letterGuessed,
                    unguessedLetters);
            // created a new string with the updated masked phrase
            // to compare it with the old one in
            // the if statement after it
            String newMaskedPhraseComparer =
                    updateMaskedPhrase(maskedPhrase, letterGuessed, phrase);
            // if the given attempt does not change the masked
            // phrase, the guess is wrong
            if (maskedPhrase.equals(newMaskedPhraseComparer)){
                wrongGuesses++;
            }
            maskedPhrase = newMaskedPhraseComparer;
            System.out.println();
            System.out.println("Number of wrong guesses so far: " +
                    wrongGuesses);
        }
        printEndGameMessage(wrongGuesses, maskedPhrase, phrase);
    }

    // builds the masked phrase with "*" and accounts
    // for underscores in the phrase with "_"
    private static String currentPhrase(String phrase) {
        String secretPhrase = "";
        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            if (ch == '_') {
                secretPhrase += "_";
            }
            else {
                secretPhrase += "*";
            }
        }
        return secretPhrase;
    }

    // prints the letters not guessed and asked user for input
    // (the letter they want to guess)
    private static String enterNextGuess(String unguessedLetters, Scanner keyboard){
        System.out.println("The letters you have not guessed yet are: ");
        printUnguessedLetters(unguessedLetters);
        System.out.println();
        System.out.println();
        System.out.print("Enter your next guess: ");
        return "" + keyboard.nextLine();
    }

    // checks if the inputted guess by user is a character. If not,
    // it tells the user it is not a valid guess
    // and asks user to guess again
    private static String validGuessChecker(String unguessedLetters, String letterGuessed,
                                            Scanner keyboard){
        //while loop runs forever until user inputs a character in "unguessedLetters"
        while (true){
            for (int i = 0; i < unguessedLetters.length(); i++){
                if (letterGuessed.length() > 0 && letterGuessed.toUpperCase().charAt(0)
                        == unguessedLetters.charAt(i)) {
                    letterGuessed = "" + letterGuessed.toUpperCase().charAt(0);
                    return letterGuessed;
                }
            }
            System.out.println();
            System.out.println(letterGuessed + " is not a valid guess.");
            // user input is called from this method
            letterGuessed = enterNextGuess(unguessedLetters, keyboard);
        }
    }

    // removes guessed letters from the string "unguessedLetters"
    private static String removeGuessedLetters(String letterGuessed,
                                               String unguessedLetters) {
        int indexLetter = unguessedLetters.indexOf(letterGuessed);
        String newUnguessed = unguessedLetters;
        // variable newUnguessed is set equal to the part (substring) of
        // unguessedLetters without the guessed letter
        newUnguessed = unguessedLetters.substring(0, indexLetter) +
                unguessedLetters.substring(indexLetter + 1);
        return newUnguessed;
    }

    // Goal: replace astrisk in currentPhraseIs with letter
    // if user guessed correctly
    // arguments: maskedPhrase, letterGuessed, phrase
    // output: maskedPhrase replaced with letterGuessed
    // return: newMaskedPhrase as String
    private static String updateMaskedPhrase(String maskedPhrase,
                                             String letterGuessed, String phrase) {
        String newMaskedPhrase = maskedPhrase;
        String present = "That is not present in the secret phrase.";
        System.out.println();
        System.out.println("You guessed " + letterGuessed + ".");
        for (int i = 0; i < maskedPhrase.length(); i++) {
            int maskedPhraseIndex = phrase.indexOf(letterGuessed, i);
            if ((maskedPhraseIndex != -1) && (maskedPhraseIndex == i)) {
                // sets newMaskedPhrase equal to the substring that would be
                //replaced with the correct letter guessed
                newMaskedPhrase = newMaskedPhrase.substring(maskedPhraseIndex,
                        maskedPhraseIndex + 1);
                // replaces the astrisks in newMaskedPhrase with correctly guessed letter
                newMaskedPhrase = newMaskedPhrase.replace(newMaskedPhrase.charAt(0),
                        letterGuessed.charAt(0));
                // rebuilds masked phrase around correctly guessed letter
                newMaskedPhrase = maskedPhrase.substring(0, maskedPhraseIndex) + newMaskedPhrase
                        + maskedPhrase.substring(maskedPhraseIndex + 1);
                // sets maskedPhrase equal to newMaskedPhrase to have this process repeat for
                // other characters in the string that may have also been guessed correctly
                maskedPhrase = newMaskedPhrase;
                present = "That is present in the secret phrase.";
            }
        }
        System.out.println();
        System.out.println(present);
        return newMaskedPhrase;
    }

    // adds the "--" in between all unguessed letters in the string "unguessedLetters"
    private static void printUnguessedLetters(String unguessedLetters){
        for (int i = 0; i < unguessedLetters.length(); i++){
            //print letter and add -- after unless its z
            System.out.print(unguessedLetters.charAt(i));
            if (i != unguessedLetters.length() - 1) {
                System.out.print("--");
            }
        }
    }

    // prints a special message if the player loses or wins based on the number of guesses
    // and weather or not the masked phrase has been fully revealed
    private static void printEndGameMessage(int wrongGuesses,
                                            String maskedPhrase, String phrase){
        if (wrongGuesses == 5){
            System.out.println("You lose. The secret phrase was " + phrase);
        }
        else if (maskedPhrase.equals(phrase)){
            System.out.println("The phrase is " + phrase + ".");
            System.out.println("You win!!");
        }
        System.out.println("Do you want to play again?");
        System.out.print("Enter 'Y' or 'y' to play again: ");
    }

    // Build the PhraseBank.
    // === When you run this program, there won't be any String[] args sent to main,
    // so this line - result =  new PhraseBank(); - will create a bank of phrases
    // that 1) uses the default file "HangmanMovies.txt" and 2) uses fixed responses
    // that allow the test script to work. 
    // === When the test script runs this program, it will call the main method 
    // multiple times, with different arguments for different input filenames. 
    // === In both of the previous cases, the PhraseBank constructor with only one 
    // argument is used,so the responses from the PhraseBank won't be random, again, 
    // so the test script will work.
    public static PhraseBank buildPhraseBank(String[] args) {
        PhraseBank result;
        if (args == null || args.length == 0
                        || args[0] == null || args[0].length() == 0) {
            result =  new PhraseBank();
            /* CS312 students, uncomment the following line if you
             * would like less predictable behavior from the PhraseBank
             * during testing. NOTE, this line MUST be commented out
             * in the version of the program you turn in
             * or your will fail all tests.
             */
           result = new PhraseBank("HangmanMovies.txt", true); // MUST be commented out in version you submit.
        } else {
            result = new PhraseBank(args[0]);
        }
        return result;
    }

    // Print the intro to the program.
    public static void intro() {
        System.out.println("This program plays the game of hangman.");
        System.out.println();
        System.out.println("The computer will pick a random phrase.");
        System.out.println("Enter letters for your guess.");
        System.out.println("After 5 wrong guesses you lose.");
    }
}
