public class Solution {
    /**
     * @param strings: a string array
     * @return: return a list of string array
     */

    public List<List<String>> groupStrings(String[] strings) {
        // write your code here
        HashMap<String, List<String>> hashmap = new HashMap();
        for (String str: strings) {
            String key = getKey(str);
            if (hashmap.containsKey(key)) {
                hashmap.get(key).add(str);
            }
            else{
                List<String> result = new ArrayList<>();
                result.add(str);
                hashmap.put(key, result);
            }
        }

        List<List<String>> finalOutput = new ArrayList();
        finalOutput.addAll(hashmap.values());
        return finalOutput;
    }

    public String getKey(String s){
        StringBuilder key = new StringBuilder();
        
        for (int i=1; i<s.length();i++){
            char curr = s.charAt(i);
            char prev = s.charAt(i-1);
            int diff = curr-prev;
            if (diff<0) diff+=26;
            key.append(diff).append("#");
        }

        key.append(".");

        return key.toString();
    }
}
