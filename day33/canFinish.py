'''
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
'''

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        degrees = [0] * numCourses
        adjacency = [[] for _ in range(numCourses)]
        queue = collections.deque()

        for cur, pre in prerequisites:
            degrees[cur] += 1
            adjacency[pre].append(cur)
        
        for index, value in enumerate(degrees):
            if not value: queue.append(index)
        
        while queue:
            cur = queue.popleft()
            numCourses -= 1
            for index in adjacency[cur]:
                degrees[index] -= 1
                if not degrees[index]: queue.append(index)
        return not numCourses
