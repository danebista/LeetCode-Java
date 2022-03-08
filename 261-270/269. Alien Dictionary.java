public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    StringBuilder sb;
    Map<Character, Set<Character>> hashmap;
    Map<Character, Integer> depth;
    
    public String alienOrder(String[] words) {
        // Write your code here
        hashmap = new HashMap();
        depth=new HashMap();
        sb= new StringBuilder();

        for (String word: words){
            for (char c: word.toCharArray()){
                hashmap.put(c, new HashSet());
                depth.put(c, 0);
            }
        }

        for (int i=0; i < words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            int minLen = Math.min(word1.length(), word2.length());
            
            if (word1.length()> word2.length()
             && word1.substring(0,minLen).equals(word2.substring(0,minLen))) return "";

            for (int j=0; j < minLen; j++){
                if (word1.charAt(j)!=word2.charAt(j)){
                    hashmap.get(word1.charAt(j)).add(word2.charAt(j));
                    break;
                }
            }
        }

        for (char c: hashmap.keySet()){
          for (char neigh: hashmap.get(c)){
              depth.put(neigh, depth.get(neigh)+1);
          }
        }
        PriorityQueue<Character> pq = new PriorityQueue();

        for (char c: depth.keySet()){
          if (depth.get(c)==0){
            pq.add(c);
          }
        }

        while (!pq.isEmpty()){
          char current = pq.remove();
          sb.append(current);
          for (char neigh: hashmap.get(current)){
            depth.put(neigh, depth.get(neigh)-1);
            if (depth.get(neigh)==0){
              pq.add(neigh);
            }
          }
        }

        if (sb.length() != hashmap.keySet().size()) return "";
        
        return sb.toString();
    }
}
