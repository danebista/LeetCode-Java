class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        Map<String, List<String>> neighborGraph = new HashMap();
        Map<String, Integer> visitedLevel = new HashMap();
        List<List<String>> result = new ArrayList();
        
        if (!words.contains(endWord)) return result;
        bfs(beginWord, endWord, words, neighborGraph, visitedLevel);
        List<String> current = new ArrayList();
        current.add(beginWord);
        dfs(visitedLevel, result, current, neighborGraph, beginWord, endWord);
        return result;
    }
    
    public void dfs(Map<String, Integer> visitedLevel, List<List<String>> result, List<String> current, Map<String, List<String>> neighborGraph, String word, String endWord){
        if (word.equals(endWord)){
            result.add(new ArrayList(current));
            return;
        }
        int currentVisitedLevel = visitedLevel.get(word);
        
        for (String next: neighborGraph.get(word)){
            int nextLevel = visitedLevel.get(next);
            
            if (nextLevel == currentVisitedLevel+1){
                current.add(next);
                dfs(visitedLevel,result, current, neighborGraph, next, endWord);
                current.remove(current.size()-1);
            }
        }
    }
    
    public void bfs(String beginWord, String endWord, HashSet<String> words,  Map<String, List<String>> neighborGraph, Map<String, Integer> visitedLevel){
        Queue<String> queue = new LinkedList();
        queue.add(beginWord);
        visitedLevel.put(beginWord, 0);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i=0; i< size; i++){
                String curr = queue.remove();
                if (curr==endWord) break;
                List<String> neighbors = findNeighbors(curr, words);
                neighborGraph.put(curr, neighbors);
                for (String neighbor: neighbors){
                    if(visitedLevel.containsKey(neighbor)) continue;
                    visitedLevel.put(neighbor, level+1);
                    queue.add(neighbor);
                }
            }
            level++;
        }
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
                }
            }
            array[i] = temp;
        }
        
        return neighbors;
    }
}