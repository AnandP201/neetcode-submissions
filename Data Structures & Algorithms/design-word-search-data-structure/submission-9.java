class TrieNode {
    TrieNode nodes[];
    boolean isEnd;

    public TrieNode() {
        this.nodes = new TrieNode[26];
    }

    public void insertWord(String word) {
        TrieNode current = this;
        for (char ch : word.toCharArray()) {
            if (current.nodes[ch - 'a'] == null) {
                current.nodes[ch - 'a'] = new TrieNode();
            }
            current = current.nodes[ch - 'a'];
        }
        current.isEnd = true;
    }

    public boolean isPresent(String word) {
        TrieNode current = this;
        return search(word, 0, current);
    }

    public boolean search(String word, int idx, TrieNode current) {
        if (current == null)
            return false;
        if (idx == word.length())
            return current.isEnd;

        char ch = word.charAt(idx);

        if (ch == '.') {
            for (int i = 0; i < 26; i++) {
                if (current.nodes[i] != null) {
                    if (search(word, idx + 1, current.nodes[i]))
                        return true;
                }
            }
        } else {
            if (current.nodes[ch - 'a'] == null) {
                return false;
            }
            TrieNode next = current.nodes[ch - 'a'];
            return search(word, idx + 1, next);
        }
        return false;
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        root.insertWord(word);
    }

    public boolean search(String word) {
        return root.isPresent(word);
    }
}
