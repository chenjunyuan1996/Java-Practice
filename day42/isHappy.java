class Solution {

    public boolean isHappy(int n) {
        Set<Integer> repeat = new HashSet<>();
        while (n != 1 && !repeat.contains(n)) {
            repeat.add(n);
            n = updateN(n);
        }
        return n == 1;
        
    }

    private int updateN(int n) {
        int temp = 0;
        while (n != 0) {
            temp += Math.pow(n % 10, 2);
            n /= 10;
        }
        return temp;
    }
}
