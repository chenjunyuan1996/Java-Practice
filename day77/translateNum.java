class Solution {
    public int translateNum(int num) {
        int a = 1, b = 1;
        while (num / 10 != 0) {
            int tmp = b;
            int cur = num - num / 100 * 100;
            b = cur >= 10 && cur <= 25? a + b: b;
            a = tmp;
            num /= 10;
        }

        return b;
    }
}
