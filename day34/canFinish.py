'''
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/course-schedule
'''

# 题目跟昨天一样，昨天是广度优先遍历（用队列实现），今天用深度优先遍历；

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        flags = [0] * numCourses
        adjacency = [[] for _ in range(numCourses)]
        for cur, pre in prerequisites:
            adjacency[pre].append(cur)

        def dfs(i, adjacency, flags):
            if flags[i] == -1: return True
            if flags[i] == 1: return False
            flags[i] = 1
            for j in adjacency[i]:
                if not dfs(j, adjacency, flags): 
                    return False
            flags[i] = -1
            return True

        for i in range(numCourses):
            if not dfs(i, adjacency, flags):
                return False
        return True
