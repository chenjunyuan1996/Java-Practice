// class Solution {
//     public double myPow(double x, int n) {
//         double res = 1.0;
//         for (int i = n ; i != 0; i /= 2) {
//             if (i % 2 != 0) {
//                 res *= x;
//             }
//             x *= x;
//         }

//         return n > 0 ? res : 1 / res;
//     }
// }

class Solution {
    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        if (n == 0) return 1.0;

        double half = fastPow(x, n / 2);
        if (n % 2 == 0) return half * half;
        else return half * half * x;

    }
}
