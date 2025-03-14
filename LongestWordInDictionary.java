  class LongestWordInDictionary {

    Map<Integer, String> wordMap = new HashMap<>();
    int maxCount = Integer.MIN_VALUE;

    class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    TrieNode head = new TrieNode();

    private void insert(String word) {
        TrieNode node = head;
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            int curr = word.charAt(i) - 'a';
            if (node.children[curr] == null) {
                TrieNode nextNode = new TrieNode();
                node.children[curr] = nextNode;
                node = node.children[curr];
            } else {
                node = node.children[curr];
                if (node.isEnd) {
                    count++;
                }
            }
        }
        node.isEnd = true;
        if(count < word.length())
            count++;

        if (count >= maxCount && (word.length() == 1 || word.length() - count < 1)) {
            maxCount = count;
            if (wordMap.containsKey(maxCount)) {
                String existingWord = wordMap.get(maxCount);

                if (existingWord.compareTo(word) < 0) {
                    wordMap.put(maxCount, existingWord);
                    return;
                }
                wordMap.put(maxCount, word);
                return;
            }
            wordMap.put(count, word);
        }
        Map<Integer, String> m = new HashMap<>();
        m = wordMap;
    }

    public String longestWord(String[] words) {
        Arrays.sort(words);
        if (words == null || words.length == 0) {
            return null;
        }

        for (String word : words) {
            insert(word);
        }
        return wordMap.get(maxCount) != null ? wordMap.get(maxCount) : "";
    }
}
