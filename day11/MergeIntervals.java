class Solution {
    public int[][] merge(int[][] intervals) {
        int size = intervals.length;
        if (size <= 1) return intervals;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> res = new ArrayList();
        
        int i = 0;
        while (i < size) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i < size - 1 && end >= intervals[i + 1][0]) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            res.add(new int[] {start, end});
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}
