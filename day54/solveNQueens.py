class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        self.result = []
        self.DFS([], [], [], n)
        return self.result
    
    def DFS(self, queens, xy_dif, xy_sum, n):
        p = len(queens)
        if p == n:
            self.result.append(["." * i + "Q" + "." * (n - i - 1) for i in queens])
            return
        
        for q in range(n):
            if q not in queens and p - q not in xy_dif and p + q not in xy_sum:
                self.DFS(queens + [q], xy_dif + [p - q], xy_sum + [p + q], n)
