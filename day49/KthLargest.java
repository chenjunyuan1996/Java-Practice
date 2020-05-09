class KthLargest {

    private PriorityQueue<Integer> heap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>(k);
        for (int num : nums) {
            add(num); // 调用KthLargest中add的方法
        }

    }
    
    public int add(int val) {
        if (heap.size() < this.k) {
            heap.offer(val);
        } else if (heap.peek() < val) {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();

    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
