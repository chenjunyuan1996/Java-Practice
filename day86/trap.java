class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0, cur = 0;
        while (cur < height.length) {
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int h = height[stack.pop()];
                if (stack.isEmpty()) break;

                int dis = cur - stack.peek() - 1;
                int len = Math.min(height[cur], height[stack.peek()]) - h;
                res += dis * len;
            }
            stack.add(cur);
            cur++;
        }
        return res;

    }
}
