# 循环队列

class MyCircularQueue {
    private int[] queue;
    private int head;
    private int tail;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.queue = new int[k];
        this.head = this.tail = -1;
        this.size = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (this.isFull()) {
            return false;
        } else {
            if (this.head == -1) this.head++;
            this.tail = ++this.tail % this.size;
            this.queue[tail] = value;
            return true;
        }
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (this.isEmpty()) {
            return false;
        } else if (this.head != this.tail) {
            this.head = ++this.head % this.size;
            return true;
        } else {
            this.head = this.tail = -1;
            return true;
        }
    }
    
    /** Get the front item from the queue. */
    public int Front() {
        if (this.isEmpty()) {
            return -1;
        } else {
            return this.queue[head];
        }
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
        if (this.isEmpty()) {
            return -1;
        } else {
            return this.queue[tail];
        }
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        if (this.tail == -1) {
            return true;
        } else {
            return false;
        }
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        if (this.tail == this.head - 1 || (this.head == 0 && this.tail == this.size - 1)) {
            return true;
        } else {
            return false;
        }
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
