class TrieNode {
    TrieNode nodes[];
    boolean endOfWord;

    public TrieNode() {
        this.nodes = new TrieNode[26];
        this.endOfWord = false;
    }

    public void addToTrie(String word) {
        TrieNode current = this;
        for (char ch : word.toCharArray()) {
            if (current.nodes[ch - 'a'] == null) {
                current.nodes[ch - 'a'] = new TrieNode();
            }
            current = current.nodes[ch - 'a'];
        }
        current.endOfWord = true;
    }

    public boolean isWordInTrie(String word) {
        TrieNode curr = this;
        for (char ch : word.toCharArray()) {
            if (curr.nodes[ch - 'a'] == null) {
                return false;
            }
            curr = curr.nodes[ch - 'a'];
        }
        return curr.endOfWord;
    }

    public boolean isPrefixInTrie(String word) {
        TrieNode curr = this;
        for (char ch : word.toCharArray()) {
            if (curr.nodes[ch - 'a'] == null) {
                return false;
            }
            curr = curr.nodes[ch - 'a'];
        }
        return true;
    }
}

class PrefixTree {
    TrieNode root;
    public PrefixTree() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        root.addToTrie(word);
    }

    public boolean search(String word) {
        return root.isWordInTrie(word);
    }

    public boolean startsWith(String prefix) {
        return root.isPrefixInTrie(prefix);
    }
}
