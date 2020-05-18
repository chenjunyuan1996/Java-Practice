class Solution:
    def totalNQueens(self, n: int) -> int:
        self.res = 0
        self._dfs(0, n, 0, 0, 0)
        return self.res

    def _dfs(self, row, n, col, pie, na):
        if row == n:
            self.res += 1
            return

        bits = (~(col | pie | na)) & ((1 << n) - 1)
        while bits:
            p = bits & -bits
            self._dfs(row + 1, n, col | p, (pie | p) << 1, (na | p) >> 1)
            bits &= bits - 1
