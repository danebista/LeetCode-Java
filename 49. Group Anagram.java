class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList();
        
        Map<String, List<String>> map= new HashMap();
        
        for (String value: strs){
            char[] chars = value.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            if (!map.containsKey(sorted)){
                map.put(sorted, new ArrayList());
            }
            map.get(sorted).add(value);
        }
        
        anagrams.addAll(map.values());
        
        return anagrams;
    }
}
