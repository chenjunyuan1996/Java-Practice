class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        self.res = []
        self._gen(n, n, "")
        return self.res

    def _gen(self, left, right, res):
            if right == 0:
                self.res.append(res)
                return
                
            if left != 0: self._gen(left - 1, right, res + "(")
            if right > left: self._gen(left, right - 1, res + ")")
