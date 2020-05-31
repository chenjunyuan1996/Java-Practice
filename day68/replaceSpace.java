/*
面试题05. 替换空格
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

链接: https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
*/

class Solution {
    public String replaceSpace(String s) {
        // 计算扩张后的空间内
        int size = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                size += 2;
            }
        }
        size += s.length();
        char[] array = new char[size];

        // 替换
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                array[index++] = '%';
                array[index++] = '2';
                array[index++] = '0';
            } else {
                array[index++] = s.charAt(i);
            }
        }

        return new String(array);

    }
}
