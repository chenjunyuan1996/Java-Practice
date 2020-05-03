class Solution {
    public int lengthOfLastWord(String s) {
        int pivot = s.length() - 1;

        while (pivot >= 0 && s.charAt(pivot) == ' ') pivot--;
        if (pivot < 0) return 0;
        
        int end = pivot;
        while(pivot >= 0 && s.charAt(pivot) != ' ') pivot--;

        return end - pivot;


    }
}
