class LRUCache(collections.OrderedDict):

    def __init__(self, capacity: int):
        super().__init__()
        self._capacity = capacity

    def get(self, key: int) -> int:
        if key not in self:
            return -1
        self.move_to_end(key)
        return self[key]

    def put(self, key: int, value: int) -> None:
        if key in self:
            self.move_to_end(key)
        elif len(self) == self._capacity:
            self.popitem(last=False)
        self[key] = value

# class LRUCache:

#     def __init__(self, capacity: int):
#         self.dic = collections.OrderedDict()
#         self.remain = capacity

#     def get(self, key: int) -> int:
#         if key not in self.dic: return -1
#         self.dic[key] = self.dic.pop(key)
#         return self.dic.get(key)

#     def put(self, key: int, value: int) -> None:
#         if key in self.dic:
#             self.dic.pop(key)
#         elif self.remain > 0:
#             self.remain -= 1
#         else:
#             self.dic.popitem(last=False)
#         self.dic[key] = value
#         return

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
