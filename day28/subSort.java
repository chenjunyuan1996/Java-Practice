class Solution {
    public int[] subSort(int[] array) {
        if (array.length == 0) return new int[]{-1, -1};

        int l = -1, r = -1;
        int lmin = array[array.length - 1];
        int rmax = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] >= rmax) {
                rmax = array[i];
            } else {
                r = i;
            }
    
            if (array[array.length - 1 - i] <= lmin) {
                lmin = array[array.length - 1 - i];
            } else {
                l = array.length - 1 - i;
            }
        }

        return new int[]{l, r};

    }
}

// class Solution {
//     public int[] subSort(int[] array) {
//         if (array.length == 0) return new int[]{-1, -1};

//         int l = -1, r = -1;
//         int lmin = array[array.length - 1];
//         int rmax = array[0];

//         for (int i = 1; i < array.length; i++) {
//             if (array[i] >= rmax) {
//                 rmax = array[i];
//             } else {
//                 r = i;
//             }
//         }
//         for (int i = array.length - 2; i > -1; i--) {
//             if (array[i] <= lmin) {
//                 lmin = array[i];
//             } else {
//                 l = i;
//             }
//         }
//         return new int[]{l, r};

//     }
// }

// class Solution {
//     public int[] subSort(int[] array) {
//         int[] temp = array.clone();
//         Arrays.sort(temp);
//         int l = -1, r = -1;
//         for (int i = 0; i < array.length; i++) {
//             if (array[i] != temp[i]) {
//                 if (l == -1) {
//                     l = i;
//                 } else {
//                     r = i;
//                 }
//             }
//         }
//         return new int[]{l ,r};
        
//     }
// }

// class Solution {
//     public int[] subSort(int[] array) {
//         int[] temp = array.clone();
//         Arrays.sort(temp);
//         int l = 0, r = array.length - 1;
//         while (l <= r && temp[l] == array[l]) {
//             l++;
//         }
//         if (l > r) {
//             return new int[]{-1, -1};
//         } else {
//             while (temp[r] == array[r]) {
//                 r--;
//             }
//             return new int[]{l, r};
//         }
//     }
// }
