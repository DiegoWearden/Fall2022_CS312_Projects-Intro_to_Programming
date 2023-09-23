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

public class GuitarString {
    private static final double ENERGY_DECAY_FACTOR = .994;
    private static final int SAMPLING_RATE = 44100;
    private RingBuffer frequencyBuffer;
    private int frequencyCapacity;
    private int time;

    /**
     * create a guitar string of the given frequency, using a sampling rate of 44,100
     * @param frequency
     */
    public GuitarString(double frequency) {
        time = 0;
        frequencyCapacity = (int) Math.ceil(SAMPLING_RATE / frequency);
        frequencyBuffer = new RingBuffer(frequencyCapacity);
        while (!frequencyBuffer.isFull()){
            frequencyBuffer.enqueue(0);
        }
    }

    /**
     * create a guitar string whose size and initial values are given by the array
     * @param init
     */
    public GuitarString(double[] init) {
        frequencyBuffer = new RingBuffer(init.length);
        for(int i = 0; i < init.length; i++) {
            frequencyBuffer.enqueue(init[i]);
        }
    }

    /**
     * set the buffer to white noise
     */
    public void pluck(){
        for (int i = 0; i < frequencyCapacity; i++){
            frequencyBuffer.dequeue();
        }
        for(int i = 0; i < frequencyCapacity; i++) {
            double random = Math.random() - 0.5;
            frequencyBuffer.enqueue(random);
        }
    }

    /**
     * advance the simulation one time step
     */
    public void tic(){
        double firstElement = frequencyBuffer.dequeue();
        double secondElement = sample();
        double average = ((firstElement + secondElement) / 2) * ENERGY_DECAY_FACTOR;
        frequencyBuffer.enqueue(average);
        time++;
    }

    /**
     * return the current sample
     * @return
     */
    public double sample(){
        return frequencyBuffer.peek();
    }

    /**
     * return number of tics
     * @return
     */
    public int time(){
        return time;
    }                          // return number of tics

}
