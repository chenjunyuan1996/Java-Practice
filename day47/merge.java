class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        int l = m + n;
        n--;
        while (m >= 0 && n >= 0) 
            nums1[l--] = nums1[m] > nums2[n]? nums1[m--]: nums2[n--];
        
        // for (int i = 0; i <= n; i++) 
        //     nums1[i] = nums2[i];
        System.arraycopy(nums2, 0, nums1, 0, n + 1); 
    }
}

// class Solution {
//     public void merge(int[] nums1, int m, int[] nums2, int n) {
//         System.arraycopy(nums2, 0, nums1, m, n);
//         Arrays.sort(nums1);
//     }
// }
