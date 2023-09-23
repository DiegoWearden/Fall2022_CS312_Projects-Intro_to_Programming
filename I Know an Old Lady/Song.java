/*
 * CS312 Assignment 1
 * On my honor, Diego Wearden, this programming assignment is my own work.
 *
 * A program to print out the lyrics to the
 * children's song, "There was an old woman".
 *
 *  Name: Diego Wearden
 *  email address: dialwera@gmail.com
 *  UTEID: daw3784
 *  Section 5 digit ID: 52455
 *  I estimate this assignment will take this many hours: 3 hours
 *  This assignment took this many hours: 10 hours
 *  Grader name:
 */

public class Song {
    public static void main(String[] args) {
        fly();
        spider();
        bird();
        cat();
        dog();
        goat();
        cow();
        horse();
    }

    //This method prints out the first verse of the song which introduces a fly
    static void fly(){
        System.out.println("There was an old woman who swallowed a fly.");
        repetitiveCase1();
    }

    //This method prints out the second verse of the song which introduces a spider
    static void spider(){
        System.out.println("There was an old woman who swallowed a spider,");
        System.out.println("That wriggled and iggled and jiggled inside her.");
        repetitiveCase2();
    }
    //This method prints out the third verse of the song which introduces a bird
    static void bird(){
        System.out.println("There was an old woman who swallowed a bird,");
        System.out.println("How absurd to swallow a bird.");
        repetitiveCase3();
    }
    //This method prints out the fourth verse of the song which introduces a cat
    static void cat(){
        System.out.println("There was an old woman who swallowed a cat,");
        System.out.println("Imagine that to swallow a cat.");
        repetitiveCase4();
    }
    //This method prints out the fifth verse of the song which introduces a dog
    static void dog(){
        System.out.println("There was an old woman who swallowed a dog,");
        System.out.println("What a hog to swallow a dog.");
        repetitiveCase5();
    }
    // This method prints out the sixth verse of the song which introduces a goat
    static void goat(){
        System.out.println("There was an old woman who swallowed a goat,");
        System.out.println("She just opened her throat to swallow a goat.");
        repetitiveCase6();
    }
    //This method prints out the seventh verse of the song which introduces a cow
    static void cow(){
        System.out.println("There was an old woman who swallowed a cow,");
        System.out.println("I don't know how she swallowed a cow.");
        repetitiveCase7();
    }
    //This method prints out the eighth verse of the song which introduces a horse
    static void horse(){
        System.out.println("There was an old woman who swallowed a horse,");
        System.out.println("She died of course.");
    }
    //This method prints out the last two lines of each repetitive verse.
    static void repetitiveCase1() {
        System.out.println("I don't know why she swallowed that fly,");
        System.out.println("Perhaps she'll die.");
        System.out.println();
    }
    /*
    This method prints out the repetitive part of the second verse
    and then calls on line1 to print out the last two lines.
     */
    static void repetitiveCase2() {
        System.out.println("She swallowed the spider to catch the fly,");
        repetitiveCase1();
    }

    /*
    This method prints out the repetitive part of the third verse and
    then calls on line2 to print out the rest of that verse.
     */

    static void repetitiveCase3() {
        System.out.println("She swallowed the bird to catch the spider,");
        repetitiveCase2();
    }
    /*
    This method prints out the repetitive part of the fourth verse and then calls
    on line3 to print out the rest of that verse.
     */

    static void repetitiveCase4() {
        System.out.println("She swallowed the cat to catch the bird,");
        repetitiveCase3();
    }
    /*
    This method prints out the repetitive part of the fifth verse
    and then calls on line4 to print out the rest of that verse.
     */

    static void repetitiveCase5() {
        System.out.println("She swallowed the dog to catch the cat,");
        repetitiveCase4();
    }
    /*
    This method prints out the repetitive part of the sixth verse
    and then calls on line5 to print out the rest of that verse.
     */

    static void repetitiveCase6() {
        System.out.println("She swallowed the goat to catch the dog,");
        repetitiveCase5();
    }
    /*
     This method prints out the repetitive part of the seventh verse
     and then calls on line6 to print out the rest of that verse.
     */
    static void repetitiveCase7() {
        System.out.println("She swallowed the cow to catch the goat,");
        repetitiveCase6();
    }
}

