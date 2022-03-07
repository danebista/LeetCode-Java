public class Solution {
    /**
     * @param s: the given string
     * @return: all the palindromic permutations (without duplicates) of it
     */
    public List<String> generatePalindromes(String s) {
        HashMap<Character, Integer> hashmap = new HashMap();
        int odd=0;
        List<String> result = new ArrayList();

        for (char c: s.toCharArray()){
            hashmap.put(c, hashmap.getOrDefault(c,0)+1);
            odd+=hashmap.get(c)%2==0?-1:1;
        }

        if (odd > 1) return result;

        List<Character> str = new ArrayList();
        String odds = "";
        
        for (char c: hashmap.keySet()){
            if (hashmap.get(c)%2==1) odds+=c;
            
            for (int i = 0; i < hashmap.get(c) / 2; i++) str.add(c);
        }
        System.out.println(str);

        helper(new StringBuilder(), result, str, new boolean[str.size()],odds);
        return result;
    }
    public void helper(StringBuilder sb, List<String> result, List<Character> str, boolean[] used, String odd){
        if (sb.length() == str.size()){
            result.add(sb.toString()+odd+sb.reverse().toString());
            //reverse back
            sb.reverse();
            return;
        }
        char prev = '$';
        for (int i=0; i<str.size();i++){
            if (i>0 && str.get(i)==prev && !used[i-1]) continue;
            if (used[i]) continue;

            used[i] = true;
            sb.append(str.get(i));
            helper(sb, result, str, used, odd);
            used[i] = false;
            sb.deleteCharAt(sb.length() - 1);
            prev = str.get(i);
        }
    } 
}
