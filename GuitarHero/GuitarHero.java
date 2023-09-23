/*
 * CS312 Assignment 11.
 *
 * On MY honor, Diego Wearden, this programming assignment is MY own work
 * and I have not provided this code to any other student.
 *
 * Student name: Diego Wearden
 * UTEID: daw3784
 * email address: dialwera@gmail.com
 * Grader name: John Powers
 * Number of slip days used on this assignment: 0
 *
 */

/**
 * Plays all the guitar strings and types out all the keys in an interactive
 * window
 */

public class GuitarHero {
    private static final String KEYS = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    private static final GuitarString[] GUITAR_STRINGS = new GuitarString[KEYS.length()];
    public static void main(String[] args) {
        for (int i = 0; i < KEYS.length(); i++) {
            double frequency = 440.0 * Math.pow(1.05956, (i - 24.0));
            GUITAR_STRINGS[i] = new GuitarString(frequency);
        }
        Keyboard keyboard = new Keyboard();
        while (true) {
            if (keyboard.hasNextKeyPlayed()) {
                String keyPlayed = String.valueOf(keyboard.nextKeyPlayed());
                if (KEYS.contains(keyPlayed)) {
                    GUITAR_STRINGS[KEYS.indexOf(keyPlayed)].pluck();
                }
            }
            double sample = 0;
            // compute the superposition of the samples
            for (int i = 0; i < KEYS.length(); i++) {
                sample += GUITAR_STRINGS[i].sample();
                GUITAR_STRINGS[i].tic();
            }
            StdAudio.play(sample);
        }
    }
}
