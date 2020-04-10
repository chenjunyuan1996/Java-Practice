'''
实现一个基本的计算器来计算一个简单的字符串表达式的值。
字符串表达式可以包含左括号 ( ，右括号 )，加号 + ，减号 -，非负整数和空格  。
'''

class Solution:
    def evaluate_expr(self, stack):
        res = stack.pop() if stack else 0
        while stack:
            opera = stack.pop()
            if opera == "+":
                res += stack.pop()
            elif opera == "-":
                res -= stack.pop()
            elif opera == ")":
                break
        return res

    def calculate(self, s: str) -> int:
        stack = []
        n = num = 0
        for i in range(len(s) - 1, -1, -1):
            char = s[i]
            if char.isdigit():
                num += int(char) * 10 ** n
                n += 1
            elif char != " ":
                if n:
                    stack.append(num)
                    n = num = 0
                if char == "(":
                    res = self.evaluate_expr(stack)
                    stack.append(res)
                else:
                    stack.append(char)
        if n:
            stack.append(num)

        return self.evaluate_expr(stack)
