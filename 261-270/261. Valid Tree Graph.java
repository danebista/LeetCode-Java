public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    HashMap<Integer, List<Integer>> hashmap;
    HashSet visited;
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n==0) return true;
        if (n==1 && edges.length == 0) return true;
        if (n>1 && edges.length == 0) return false;
        hashmap = new HashMap();
        for (int[] i: edges){
            if (!hashmap.containsKey(i[0])){
                hashmap.put(i[0], new ArrayList());
            }
            if (!hashmap.containsKey(i[1])){
                hashmap.put(i[1], new ArrayList());
            }
            hashmap.get(i[0]).add(i[1]);
            hashmap.get(i[1]).add(i[0]);
        }
        System.out.println(hashmap);

        visited = new HashSet();

        return helper(0,-1) && visited.size()==n;
    }

    public boolean helper(int n, int prev){
        if (visited.contains(n)) return false;
        visited.add(n);

        for (Integer j: hashmap.get(n)){
            if (j== prev) continue;
            if (!helper(j, n)) return false;
        }
        return true;
    }}
    