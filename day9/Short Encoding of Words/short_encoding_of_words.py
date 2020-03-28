class Solution:
    def minimumLengthEncoding(self, words: List[str]) -> int:
        words.sort(key = lambda x: len(x), reverse=True)
        S = words[0] + "#"
        indexes = [0]
        for i in range(1, len(words)):
            tmp = S.find(words[i])

            if S[tmp + len(words[i])] == "#":
                indexes.append(tmp)
                continue

            indexes.append(len(S))
            S += words[i] + "#"

        return len(S)
