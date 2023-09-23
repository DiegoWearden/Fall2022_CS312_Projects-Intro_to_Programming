import java.util.Scanner;

/**
 * CS312 Assignment 9.
 *
 * On my honor, Diego Wearden, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *  email address: dialwera@gmail.com
 *  UTEID: daw3784
 *  TA name: John Powers
 *  Number of slip days used on this assignment: 1
 *
 * Program to decrypt a message that has been
 * encrypted with a substitution cipher.
 * We assume only characters with ASCII codes
 * from 32 to 126 inclusive have been encrypted.
 */

public class Decrypt {

    private static final int NUM_ASCII_CHARS = 128;
    private static final int NUM_ASCII_LAST_LETTER = 127;
    private static final int NUM_ASCII_FIRST_LETTER = 32;

    public static void main(String[] arg) {
        // CS312 Students, do not create any other Scanners connected to System.in
        Scanner keyboard = new Scanner(System.in);
        String fileName = getFileName(keyboard);
        String encryptedText = DecryptUtilities.convertFileToString(fileName);
        int[] frequencies = getFrequencyTable(encryptedText);
        char[] key = DecryptUtilities.getDecryptionKey(frequencies);
        displayEncryptedText(encryptedText);
        displayFrequencyAnalysis(frequencies);
        displaySubstitutionCipher(key);
        String decryotedText = decryptEncryptedText(encryptedText, key);
        String userInput = askUserInput(keyboard);
        while (userInput.equals("Y")) {
            updateKey(keyboard, key);
            decryotedText = decryptEncryptedText(encryptedText, key);
            userInput = askUserInput(keyboard);
        }
        displaySubstitutionCipher(key);
        printFinalText(decryotedText);

        keyboard.close();
    }

    /**
     * displays initial encrypted text
     * @param encryptedText
     */
    private static void displayEncryptedText(String encryptedText) {
        System.out.println("The encrypted text is:");
        System.out.println(encryptedText);
    }

    /**
     * displays how frequent a char comes up in encrypted text
     * @param frequencies
     */
    private static void displayFrequencyAnalysis(int[] frequencies) {
        System.out.println("Frequencies of characters.");
        System.out.println("Character - Frequency");
        for(int i = NUM_ASCII_FIRST_LETTER; i < NUM_ASCII_LAST_LETTER; i++){
            System.out.println((char) (i) + " - " + frequencies[i]);
        }
    }

    /**
     * prints out  current version of the key
     * @param key
     */
    private static void displaySubstitutionCipher(char[] key) {
        System.out.println();
        System.out.println("The current version of the key for " +
                "ASCII characters 32 to 126 is: ");
        for(int i = NUM_ASCII_FIRST_LETTER; i < NUM_ASCII_LAST_LETTER; i++){
            System.out.println("Encrypt character: " + (char) (i) +
                    ", decrypt character: " + key[i]);
        }
        System.out.println();
    }

    /**
     * replaces chars in encrypted text with key
     * @param encryptedText
     * @param key
     * @return
     */
    private static String decryptEncryptedText(String encryptedText, char[] key) {
        System.out.println("The current version of the decrypted text is: ");
        System.out.println();
        String decryptedText = "";
        for (int i = 0; i < encryptedText.length(); i++){
            String updatedEncryptedText = decryptedText;
            char encryptChar = key[getIndexChar(encryptedText.charAt(i), key)];
            char decryptChar = key[encryptedText.charAt(i)];
            String decryptedChar = encryptedText.substring(i, i + 1).replace(encryptChar, decryptChar);
            decryptedText = updatedEncryptedText + decryptedChar;
        }
        System.out.println(decryptedText);
        return decryptedText;
    }

    /**
     * asks user if they want to continue replacing characters
     * @param keyboard
     * @return character that allows user to continue replacing characters
     */
    private static String askUserInput(Scanner keyboard) {
        System.out.println("Do you want to make a change to the key?");
        System.out.print("Enter 'Y' or 'y' to make change: ");
        return keyboard.nextLine().toUpperCase();
    }

    /**
     * asks user to input characters to replace each other in the encrypted text
     * Swaps chars in array "key"
     * @param keyboard
     * @param key
     */
    private static void updateKey(Scanner keyboard, char[] key) {
        System.out.print("Enter the decrypt character you want to change: ");
        char encryptedChar = key[getIndexChar(keyboard.nextLine().charAt(0), key)];
        System.out.print("Enter what the character " + encryptedChar + " should decrypt to instead: ");
        char decryptedChar = key[getIndexChar(keyboard.nextLine().charAt(0), key)];
        int encryptedCharIndex = getIndexChar(encryptedChar, key);
        int decryptedCharIndex = getIndexChar(decryptedChar, key);
        key[encryptedCharIndex] = decryptedChar;
        key[decryptedCharIndex] = encryptedChar;
        System.out.println(encryptedChar + "'s will now decrypt to " +
                decryptedChar + "'s and vice versa.");
        System.out.println();
    }

    /**
     * prints final decrypted text
     * @param newEncryptedText
     */
    private static void printFinalText(String newEncryptedText) {
        System.out.println("The final version of the decrypted text is: ");
        System.out.println();
        System.out.println(newEncryptedText);
    }

    /**
     * looks for certain char in key
     * @param chars
     * @param key
     * @return index of character in array key[]
     */
    private static int getIndexChar(char chars, char[] key) {
        for (int i = 0; i < key.length; i++){
            if (chars == key[i]){
                return i;
            }
        }
        return 0;
    }

    /**
     * counts how many of each character are in the encrypted text
     * @param encryptedText
     * @return array of how frequent each char appears in the encrypted text
     */
    private static int[] getFrequencyTable(String encryptedText) {
        Scanner frequencyAnalyzer = new Scanner(encryptedText);
        int[] frequencies = new int[NUM_ASCII_CHARS];
        while(frequencyAnalyzer.hasNextLine()){
            String encryptedTextLine = frequencyAnalyzer.nextLine();
            for (int i = NUM_ASCII_FIRST_LETTER; i < NUM_ASCII_LAST_LETTER; i++){
                for (int j = 0; j < encryptedTextLine.length(); j++){
                    if  (encryptedTextLine.charAt(j) == (char) (i)){
                        frequencies[i]++;
                    }
                }
            }
        }
        return frequencies;
    }

    // Get the name of file to use. For this assignment, no error
    // checking is required.
    public static String getFileName(Scanner kbScanner) {
        System.out.print("Enter the name of the encrypted file: ");
        String fileName = kbScanner.nextLine().trim();
        System.out.println();
        return fileName;
    }
}