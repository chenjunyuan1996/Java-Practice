class Trie {

    private class TrieNode {
        private TrieNode[] next = new TrieNode[26];
        private boolean isEnd = false;

        public TrieNode() { }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.next[index] == null) cur.next[index] = new TrieNode();
            cur = cur.next[index];
        }
        cur.isEnd = true;

    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = this.root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.next[index] == null) return false;
            cur = cur.next[index];
        }
        return cur.isEnd;

    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (cur.next[index] == null) return false;
            cur = cur.next[index];
        }
        return true;

    }
}

// class Trie {
//     private Trie[] next = new Trie[26];
//     private boolean isEnd = false;

//     /** Initialize your data structure here. */
//     public Trie() {
        
//     }
    
//     /** Inserts a word into the trie. */
//     public void insert(String word) {
//         Trie root = this;
//         for (int i = 0; i < word.length(); i++) {
//             int index = word.charAt(i) - 'a';
//             if (root.next[index] == null) root.next[index] = new Trie();
//             root = root.next[index];
//         }
//         root.isEnd = true;

//     }
    
//     /** Returns if the word is in the trie. */
//     public boolean search(String word) {
//         Trie root = this;
//         for (int i = 0; i < word.length(); i++) {
//             int index = word.charAt(i) - 'a';
//             if (root.next[index] == null) return false;
//             root = root.next[index];
//         }
//         return root.isEnd;

//     }
    
//     /** Returns if there is any word in the trie that starts with the given prefix. */
//     public boolean startsWith(String prefix) {
//         Trie root = this;
//         for (int i = 0; i < prefix.length(); i++) {
//             int index = prefix.charAt(i) - 'a';
//             if (root.next[index] == null) return false;
//             root = root.next[index];
//         }
//         return true;

//     }
// }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
