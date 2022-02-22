public class Solution {
    /**
     * @param words: a list of words
     * @param word1: a string
     * @param word2: a string
     * @return: the shortest distance between word1 and word2 in the list
     */
    public int shortestWordDistance(String[] words, String word1, String word2) {
        // Write your code here
    Map<String, List<Integer>> map = new HashMap();

    for (int i=0; i<words.length;i++){
        if (!map.containsKey(words[i])){
            List<Integer> newList = new ArrayList();
            newList.add(i);
            map.put(words[i], newList);
        }
        else{
            map.get(words[i]).add(i);
        }
    }
    int i=0;
    int j=0;
    List<Integer> l1 = map.get(word1);
    List<Integer> l2 = map.get(word2);
    int res=Integer.MAX_VALUE;
    System.out.println(l1);
    System.out.println(l2);
    while (i< l1.size()&& j<l2.size()){
        if (l1.get(i)< l2.get(j)){
            if (l1.get(i)-l2.get(j)==0){
                i++;
                continue;
            }
            res= Math.min(res, l2.get(j)-l1.get(i));
            i++;
        }
        else{
            if (l1.get(i)-l2.get(j)==0){
                j++;
                continue;
            }
            res=Math.min(res, l1.get(i)-l2.get(j));
            j++;
        }
    }

    return res;
    }
}
