import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        int size = stones.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(size, (o1, o2) -> o2 - o1);
        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1 && maxHeap.peek() != 0) {
            Integer head1 = maxHeap.poll();
            Integer head2 = maxHeap.poll();

            maxHeap.offer(head1 - head2);
        }
        
        return maxHeap.peek();
    }
}
