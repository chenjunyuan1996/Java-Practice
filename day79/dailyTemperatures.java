class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            int temp = T[i];
            while (!stack.isEmpty() && T[stack.peek()] < temp) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.add(i);
        }
        return res;

    }   
}
