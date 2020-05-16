class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = {}
        self.end_of_word = "#"

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self.root
        for char in word:
            node = node.setdefault(char, {})
        node[self.end_of_word] = self.end_of_word

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.root
        for char in word:
            if char not in node:
                return False
            node = node[char]
        return self.end_of_word in node

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.root
        for char in prefix:
            if char not in node:
                return False
            node = node[char]
        return True

# class Trie:

#     def __init__(self):
#         """
#         Initialize your data structure here.
#         """
#         self.sub_node = [None] * 26
#         self.isEnd = False

#     def insert(self, word: str) -> None:
#         """
#         Inserts a word into the trie.
#         """
#         node = self
#         for char in word:
#             index = ord(char) - ord("a")
#             if node.sub_node[index] == None: node.sub_node[index] = Trie();
#             node = node.sub_node[index]
#         node.isEnd = True

#     def search(self, word: str) -> bool:
#         """
#         Returns if the word is in the trie.
#         """
#         node = self
#         for char in word:
#             index = ord(char) - ord("a")
#             if node.sub_node[index] == None: return False
#             node = node.sub_node[index]
#         return node.isEnd

#     def startsWith(self, prefix: str) -> bool:
#         """
#         Returns if there is any word in the trie that starts with the given prefix.
#         """
#         node = self
#         for char in prefix:
#             index = ord(char) - ord("a")
#             if node.sub_node[index] == None: return False
#             node = node.sub_node[index]
#         return True


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)
