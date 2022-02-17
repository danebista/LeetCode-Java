class Solution {
    Trie root;
    List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        root = new Trie();
        res = new ArrayList();
        for (String word: words){
            root.insert(word);
        }
        
        for (int i=0; i< board.length; i++){
            for (int j=0; j<board[0].length; j++){
                solve(board, i, j, root);
            }
        }
        return res;
    }
    
    public void solve(char[][]board, int i, int j, Trie curr){
        int index = board[i][j] - 'a';
        if (board[i][j]=='$' || curr.children[index]==null) return;
        curr = curr.children[index];
        if (curr.isEnd){
            res.add(curr.word);
            curr.isEnd = false;
        }
        
        char ch = board[i][j];
        board[i][j] = '$';
        if (i>0){
            solve(board, i-1, j, curr);
        }
        if (i< board.length-1){
            solve(board, i+1, j, curr);
        }
        
        if (j>0){
            solve(board, i, j-1, curr);
        }
        if (j< board[0].length-1){
            solve(board, i, j+1, curr);
        }
        board[i][j] = ch;
    }
    
    class Trie{
        boolean isEnd;
        Trie[] children;
        String word;
        
        public Trie(){
            children = new Trie[26];
            isEnd = false;
            word = "";
        }
        
        public void insert(String word){
            Trie curr = this;
            for (char c: word.toCharArray()){
                if (curr.children[c-'a']==null){
                    curr.children[c-'a'] = new Trie();
                }
                curr = curr.children[c-'a'];
            }
            curr.isEnd = true;
            curr.word = word;
        }
    }
}
