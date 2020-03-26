package Queue;

import java.util.*;

public class MyCircularQueueTest {
    public static void main(String[] args) {
        var circularQueue = new MyCircularQueue(3);
        circularQueue.enQueue(1);
        circularQueue.enQueue(2);
        circularQueue.enQueue(3);
        circularQueue.enQueue(4);
        System.out.println(circularQueue.Rear());
        circularQueue.isFull();
        circularQueue.deQueue();
        circularQueue.enQueue(4);
        System.out.println(circularQueue.Rear());
    }
}

class MyCircularQueue {
    private int[] data;
    private int head;
    private int tail;
    private int size;

    public MyCircularQueue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    public boolean enQueue(int value) {
        if (isFull()) { return false; }
        if (isEmpty()) { head = 0; }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) { return false; }
        if (head == tail) {
            head = tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    public int Front() {
        if (isEmpty()) { return -1; }
        return data[head];
    }

    public int Rear() {
        if (isEmpty()) { return -1; }
        return data[tail];
    }

    public boolean isFull() {
        return (tail + 1) % size == head;
    }

    public boolean isEmpty() {
        return head == -1;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
