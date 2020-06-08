class Solution {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if  (n > m) return addBinary(b, a);

        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = m - 1; i >= 0; i--) {
            int c = n > 0 && a.charAt(--n) == '1' ? 1:0;
            int d = b.charAt(i) == '1' ? 1:0;
            int cur = c + d + carry;
            carry = cur / 2;
            res.append(cur % 2 == 1? '1':'0');
        }
        if (carry == 1) res.append('1');
        res.reverse();
        return res.toString();
        
    }
}

// class Solution {
//   public String addBinary(String a, String b) {
//     return Integer.toBinaryString(Integer.parseInt(a, 2) + Integer.parseInt(b, 2));
//   }
// }
