/*
242. 有效的字母异位词

给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
说明:
你可以假设字符串只包含小写字母。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-anagram
 */

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         if (s.length() != t.length()) return false;

//         char[] str1 = s.toCharArray();
//         char[] str2 = t.toCharArray();
//         Arrays.sort(str1);
//         Arrays.sort(str2);
//         return Arrays.equals(str1, str2);
//     }
// }

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        } 
        for (int num: count) {
            if (num != 0) return false;
        }
        return true;
    }
}
