
class Trie {
    Trie nodes[];
    String endWord;

    public Trie() {
        this.nodes = new Trie[26];
        this.endWord = null;
    }

    public void addWord(Trie root, String word) {
        Trie current = root;
        for (char ch : word.toCharArray()) {
            if (current.nodes[ch - 'a'] == null) {
                current.nodes[ch - 'a'] = new Trie();
            }
            current = current.nodes[ch - 'a'];
        }
        current.endWord = word;
    }
}

class Solution {
    public void dfs(char[][] grid, Trie trie, List<String> result, int r, int c) {
        if (r < 0 || c < 0 || r == grid.length || c == grid[0].length)
            return;

        char ch = grid[r][c];

        // if already visited OR current trie node with ch char is null so return from this DFS path
        if (ch == '#' || trie.nodes[ch - 'a'] == null) {
            return;
        }

        trie = trie.nodes[ch - 'a'];

        if (trie.endWord != null) {
            // we reached the end of a word from the given words
            result.add(trie.endWord);
            // making word as null to avoid duplicate words if any other path comes to this way
            // again
            trie.endWord = null;
        }

        grid[r][c] = '#';

        dfs(grid, trie, result, r + 1, c);
        dfs(grid, trie, result, r, c + 1);
        dfs(grid, trie, result, r, c - 1);
        dfs(grid, trie, result, r - 1, c);

        grid[r][c] = ch;

        return;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.addWord(trie, word);
        }

        List<String> result = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, trie, result, r, c);
            }
        }

        return result;
    }
}
