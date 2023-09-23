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

import java.util.NoSuchElementException;

public class RingBuffer {
    private final double[] ringBuffer;
    private final int capacity;
    private int first;
    private int size;
    private int last;
    private int unsetLast;

    /**
     * create an empty ring buffer, with given max capacity
     * @param capacity
     */
    public RingBuffer(int capacity){
        this.ringBuffer = new double[capacity];
        this.size = 0;
        this.capacity = capacity;
        this.first = 0;
        this.last = 0;
    }

    /**
     * return number of items currently in the buffer
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * is the buffer empty (size equals zero)?
     * @return
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * is the buffer full  (size equals capacity)?
     * @return
     */
    public boolean isFull(){
        return this.size == this.capacity;
    }

    /**
     * add item x to the end (as long as the buffer is not full)
     * @param x
     */
    public void enqueue(double x) {
        this.unsetLast = this.last;
        if (isFull()){
                throw new IllegalStateException("Queue is full");
        }
        this.ringBuffer[this.last] = x;
        this.last++;
        this.size++;
        if (this.last == this.capacity){
            this.last = 0;
        }
    }

    /**
     * delete and return item from the front (as long as the buffer is not empty)
     * @return
     */
    public double dequeue() {
        if (isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        double firstItem = this.ringBuffer[this.first];
        this.first++;
        this.size--;
        if (this.first == this.capacity){
            this.first = 0;
        }
        return firstItem;
    }

    /**
     * return (but do not delete) item from the front of the buffer
     * @return
     */
    public double peek() {
        if(isEmpty()){
            throw new NoSuchElementException("Queue is empty");
        }
        return this.ringBuffer[this.first];
    }

    /**
     * override toString. Return a String of the form [front, next, next, last]
     * @return
     */
    @Override
    public String toString(){
        int n = this.first;
        String builtString = "[";
        for (int i = 0; i < this.size; i++){
            builtString += ringBuffer[n];
            if (n != this.unsetLast){
                builtString += ", ";
                n++;
            }
            if (n == this.capacity){
                n = 0;
            }
        }
        builtString += "]";
        return builtString;
    }
}
