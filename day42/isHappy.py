'''
编写一个算法来判断一个数 n 是不是快乐数。
「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
如果 n 是快乐数就返回 True ；不是，则返回 False 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/happy-number
'''

class Solution:
    def isHappy(self, n: int) -> bool:
        def updateN(n):
            temp = 0
            while n != 0:
                n, m = divmod(n, 10)
                temp += m ** 2
            return temp

        repeat = set()
        while n != 1 and n not in repeat:
            repeat.add(n)
            n = updateN(n)
        return True if n == 1 else False
