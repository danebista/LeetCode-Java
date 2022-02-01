class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        
        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i< size; i++){
                String curr = queue.remove();
                if (curr.equals(endWord)) return level+1;
                List<String> neighbors = findNeighbors(curr, words);

                for (String neighbor: neighbors){
                    queue.add(neighbor);
                }
            }
            level++;
        }
        return 0;
    }
    
    public List<String> findNeighbors(String current, HashSet<String> words){
        char[] array = current.toCharArray();
        List<String> neighbors = new ArrayList();
        for (int i=0; i<array.length; i++){
            char temp = array[i];
            for (char c='a'; c<='z'; c++){
                if (c==temp) continue;
                array[i] = c;
                String newString = String.valueOf(array);
                if (words.contains(newString)){
                    neighbors.add(newString);
                    words.remove(newString);
                }
            }
            array[i] = temp;
        }
        
        return neighbors;
    }
}