import java.math.BigInteger;
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n<=2) return n;
        int result = 0;
        HashMap<String, Integer> map = new HashMap();
        int duplicates = 0;
        for (int i=0; i<=n-2; i++){
            map.clear();
            duplicates=0;
            
            for (int j=i+1; j<=n-1; j++){
       
                if (points[i][0]==points[j][0] && points[i][1]==points[j][1]){
                    duplicates++;
                }
                else{
                    Pair<Integer, Integer> p = getCoPrime(points[i], points[j]);
                    
                    int key = p.getKey();
                    int value = p.getValue();
                    String mapKey = key + "." + value;
                    
                    if(!map.containsKey(mapKey)) {
                       map.put(mapKey, 2);
                    } else {
                       map.put(mapKey, map.get(mapKey) + 1);
                    } 
                }
            }
            
            for (Integer value: map.values()){
                result = Math.max(result, value+duplicates);
            }
        }
        
        return result;
    }
    
    public Pair<Integer, Integer> getCoPrime(int[] point1, int[] point2){
     
        int deltaX = point1[0] - point2[0];
        int deltaY = point1[1] - point2[1];
        
        if(deltaX == 0) {
            return new Pair<>(0,0);
        } else if(deltaY == 0) {
            return new Pair<>(Integer.MAX_VALUE, Integer.MAX_VALUE);
        } else if(deltaX < 0) {
            deltaX = -deltaX;
            deltaY = -deltaY;
        }
        
        Integer gcd = BigInteger.valueOf(deltaX).gcd(BigInteger.valueOf(deltaY)).intValue();
    
        return new Pair<Integer, Integer>(deltaX / gcd, deltaY / gcd);
    }
}
