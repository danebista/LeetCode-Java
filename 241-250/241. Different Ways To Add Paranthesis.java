class Solution {
    HashMap<String, List<Integer>> hashmap;
    public List<Integer> diffWaysToCompute(String expression) {
        hashmap=new HashMap();
        return dfs(0, expression.length()-1, expression);
    }
    
    public List<Integer> dfs(int start, int end, String expression){
        String key = start+","+end;
        
        if (hashmap.containsKey(key)) return hashmap.get(key);
        List<Integer> result = new ArrayList();
        for (int i=start; i<end; i++){
            char express =expression.charAt(i);
            if (express =='*' ||express =='+'||
               express=='-'){
                List<Integer> left = dfs(start, i-1, expression);
                List<Integer> right = dfs(i+1, end, expression);
                for (Integer x:left){
                    for(Integer y:right){
                        if (express=='*'){
                            result.add(x * y);
                        }
                        else if (express == '-'){
                            result.add(x-y);
                        }
                        else{
                            result.add(x+y);
                        }
                    }
                }
            }
        }
        if (result.size()==0) result.add(Integer.parseInt(expression.substring(start,end+1)));
        hashmap.put(key,result);
        return result;
    }
}
