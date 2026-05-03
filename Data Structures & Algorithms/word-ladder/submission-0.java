class Solution {
    public String modifyString(String word, int i) {
        char[] arr = word.toCharArray();
        arr[i] = '*';
        return String.valueOf(arr);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> patternToWordsMap = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = modifyString(word, i);
                patternToWordsMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(beginWord, 1));

        while (!q.isEmpty()) {
            Pair<String, Integer> p = q.poll();

            String currentWord = p.getKey();
            int level = p.getValue();

            if (currentWord.equals(endWord)) {
                return level;
            }

            for (int i = 0; i < currentWord.length(); i++) {
                String pat = modifyString(currentWord, i);
                if (patternToWordsMap.containsKey(pat)) {
                    List<String> neighbors = patternToWordsMap.get(pat);
                    for (String neighbor : neighbors) {
                        q.offer(new Pair<>(neighbor, level + 1));
                    }
                    patternToWordsMap.remove(pat);
                }
            }
        }

        return 0;
    }
}
