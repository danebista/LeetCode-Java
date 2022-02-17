class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i=0; i<buildings.length; i++){
            int start = buildings[i][0];
            int end = buildings[i][1];
            int ht = buildings[i][2];
            list.add(new Pair(start, -ht));
            list.add(new Pair(end, ht));
        }
        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int ch=0;
        pq.add(0);
        
        for (int i=0; i< list.size(); i++){
            int x = list.get(i).x;
            int h = list.get(i).h;
            if (h<0){
                pq.add(-h);
            }else{
                pq.remove(h);
            }
            if (ch !=pq.peek()){
                List<Integer> temp = new ArrayList();
                temp.add(x);
                temp.add(pq.peek());
                
                result.add(temp);
                ch = pq.peek();
            }
        }
        
        return result;
    }
        
        public class Pair implements Comparable<Pair>{
            int x;
            int h;
            
            public Pair(int x, int h){
                this.x = x;
                this.h = h;
            }
            
            @Override
            public int compareTo(Pair o){
                if (this.x !=o.x){
                    return this.x - o.x;
                }
                else{
                    return this.h - o.h;
                }
            }
        } 
}
