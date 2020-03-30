class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals)< 2:
            return intervals
        intervals.sort(key=lambda x: x[0])
        res = [intervals.pop(0)]
        for interval in intervals:
            if interval[0] <= res[-1][1]:
                res[-1][1] = max([res[-1][1], interval[1]])
            else:
                res.append(interval)
        return res
