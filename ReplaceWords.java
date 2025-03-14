
class ReplaceWords {
    class TrieNode{
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    TrieNode head = new TrieNode();

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

    private String getDictionaryWord(String word){
        TrieNode node = head;
        int c = word.charAt(0) - 'a';
        String dictionaryWord = "";
        for(int i=0;i<word.length(); i++){
            c = word.charAt(i) - 'a';
            if(node.children[c] == null || node.isEnd){
                break;
            }
            dictionaryWord += word.charAt(i);
            node = node.children[c];
        }

        if(node.isEnd)
            return dictionaryWord;

        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        if(dictionary == null || dictionary.size() == 0 ){
            return null;
        }

        for(String word:dictionary){
            insert(word);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i=0;i<words.length;i++){
            if(i!=0){
                result.append(" ");
            }
            result.append(getDictionaryWord(words[i]));
        }
        return result.toString();

    }
}
