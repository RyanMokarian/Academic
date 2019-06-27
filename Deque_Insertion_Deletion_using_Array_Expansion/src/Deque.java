/*
Project: Deque insertion deletion
Author: Ryan Mokarian
Category: Data Structure
Description: Write four O(1)-time procedures to insert elements into and delete elements from both ends
of a deque constructed from an array.
*/


import java.util.Arrays;

public class Deque {

    int leftIndex;
    int rightIndex;
    static int[] array = null;
    double loadFactor;
    static boolean firstLeftIndexTaken;
    static boolean firstRightIndexTaken;

    public Deque(int initialSize) {
        leftIndex = (initialSize / 2) - 1;
        rightIndex = (initialSize / 2);
        array = new int[initialSize];
        loadFactor = 0.8;
    }

    public boolean shouldResizeRight() {
        int halfSize = (array.length / 2);
        double load = Double.valueOf(rightIndex - halfSize) / Double.valueOf(halfSize);
        return load >= this.loadFactor;
    }

    public void resizeDeque() {
        int size = array.length * 2;
        int[] newArray = new int[size];
        int startingPosition = (newArray.length / 2) - (rightIndex - leftIndex);
        int newLeftIndex = startingPosition;
        int newRightIndex = startingPosition + (rightIndex - leftIndex);
        for (int i = leftIndex; i <= rightIndex; i++) {
            newArray[startingPosition] = array[i];
            startingPosition++;
        }
        this.array = newArray;
        this.leftIndex = newLeftIndex;
        this.rightIndex = newRightIndex - 1;
    }

    public void insertFront(int item) {
        if (firstLeftIndexTaken) {
            leftIndex--;
        }
        array[leftIndex] = item;

        if (shouldResizeLeft()) {
            resizeDeque();
        }
        firstLeftIndexTaken = true;
    }

    public boolean shouldResizeLeft() {
        int halfSize = (array.length / 2);
        double load = Double.valueOf(halfSize - leftIndex) / Double.valueOf(halfSize);
        return load >= this.loadFactor;
    }

    public void insertRear(int item) {
        if (firstRightIndexTaken) {
            rightIndex++;
        }
        array[rightIndex] = item;

        if (shouldResizeRight()) {
            resizeDeque();
        }
        firstRightIndexTaken = true;
    }

    public int removeFront() {
        if (!firstLeftIndexTaken) {
            return -1;
        }
        int front = array[leftIndex];
        array[leftIndex] = 0;
        leftIndex++;
        return front;
    }

    public int removeRear() {
        if (!firstRightIndexTaken) {
            return -1;
        }
        int rear = array[rightIndex];
        array[rightIndex] = 0;
        rightIndex--;
        return rear;
    }

    public static String getArray() {
        return Arrays.toString(array);
    }

    public static void main(String a[]) {

        Deque deque = new Deque(10);
        deque.insertFront(2);
        deque.insertFront(3);
        int front = deque.removeFront();
        deque.insertFront(8);
        deque.insertRear(78);
        deque.insertRear(6);
        int rear = deque.removeRear();
        deque.insertRear(5);
        deque.insertRear(9);
        deque.insertRear(11);
        System.out.println("Array before expansion: "+getArray());
        deque.insertRear(7);
        System.out.println("Array after expansion: "+getArray());
    }
}
