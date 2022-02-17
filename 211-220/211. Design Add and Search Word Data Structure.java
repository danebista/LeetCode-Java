class WordDictionary {
    Trie root;
    public WordDictionary() {
        root = new Trie(); 
    }
    
    public void addWord(String word) {
        root.insert(word);
    }
    
    public boolean search(String word) {
        return root.search(word, root, 0);
    }
    
    class Trie {
        Trie[] children;
        boolean isEnd;
        
        public Trie(){
            children = new Trie[26];
            isEnd = false;
        }
        
        public void insert (String word){
            Trie curr = this;
            for (char c: word.toCharArray()){
                if (curr.children[c-'a']==null){
                    curr.children[c-'a'] = new Trie();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
        }
        
        public boolean search(String word, Trie curr, int position){
            if (word.charAt(position)!='.' && 
               curr.children[word.charAt(position)-'a']!=null){
                if(position == word.length()-1){
                    curr = curr.children[word.charAt(position)-'a'];
                    
                    return curr.isEnd;
                }
                return search (word, curr.children[word.charAt(position)-'a'], position+1);
            }
            else if (word.charAt(position) == '.'){
                Trie current = curr;
                for (int i=0; i<26; i++){
                    if (position == word.length()-1 && curr.children[i]!=null)                       {
                        current = curr.children[i];
                        if (current.isEnd){
                            return true;
                        }
                    }
                    else if (curr.children[i]!=null && search(word, curr.
                                                             children[i], position+1)){
                        return true;
                    }
                }
                return false;
            }
          return false;  
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
