class ImplementPrefixTree {

    TrieNode head;

    class TrieNode{
        boolean isEnd;
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    public Trie() {
        head = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = head;
        for(int i=0; i<word.length(); i++) {
            int curr = word.charAt(i) - 'a';
            if(node.children[curr] == null){
                TrieNode nextNode = new TrieNode();
                node.children[curr] = nextNode;
            }
            node = node.children[curr];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = head;
        for(int i=0; i<word.length(); i++){
            int curr = word.charAt(i) - 'a';
            if(node.children[curr]==null){
                return false;
            }
            node = node.children[curr];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = head;
        for(int i=0; i<prefix.length(); i++){
            int curr = prefix.charAt(i) - 'a';
            if(node.children[curr]==null){
                return false;
            }
            node = node.children[curr];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
