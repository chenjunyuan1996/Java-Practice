class Solution:
    def gcd(self, a, b):
        return b if a % b == 0 else self.gcd(b, a % b)

    def hasGroupsSizeX(self, deck: List[int]) -> bool:
        deck.sort()
        tmp = index = 1
        count = []
        while index < len(deck):
            if deck[index] == deck[index - 1]:
                tmp += 1
            else:
                count.append(tmp)
                tmp = 1
            index += 1
        count.append(tmp)

        com = count.pop(0)
        for n in count:
            com = self.gcd(com, n)
        return False if com == 1 else True
