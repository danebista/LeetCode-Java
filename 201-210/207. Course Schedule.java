class Solution {
    HashMap<Integer, List<Integer>> hashmap;
    HashSet<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        hashmap = new HashMap();
        visited = new HashSet();
        
        
        for (int i=0; i< numCourses; i++){
            hashmap.put(i, new ArrayList());
        }
        
        for (int[] preq: prerequisites){
           hashmap.get(preq[0]).add(preq[1]);
        }
        
        for (int i=0; i<numCourses; i++){
            if (!helper(i)) return false;
        }

        return true;
    }
    
    public boolean helper(int root){
        if (visited.contains(root))  return false;
        if (hashmap.get(root).size()==0) return true;
        
        visited.add(root);
        for (int value: hashmap.get(root)){
            if (!helper(value)) return false;
        }
        visited.remove(root);
        hashmap.put(root, new ArrayList());
        
        return true;
    }
}
