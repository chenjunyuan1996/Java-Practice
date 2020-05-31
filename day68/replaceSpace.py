class Solution:
    def replaceSpace(self, s: str) -> str:
        res = ""
        for c in s:
            if c == " ":
                res += "%20"
            else:
                res += c
        return res


# class Solution:
#     def replaceSpace(self, s: str) -> str:
#         return s.replace(" ", "%20")
