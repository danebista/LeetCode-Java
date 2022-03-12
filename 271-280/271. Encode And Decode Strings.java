public class Solution {
    /*
     * @param strs: a list of strings
     * @return: encodes a list of strings to a single string.
     */
    public String encode(List<String> strs) {
        // write your code here
        StringBuilder sb = new StringBuilder();
        for (String next: strs){
            sb.append(next.length());
            sb.append('#');
            sb.append(next);
        }

        return sb.toString();
    }

    /*
     * @param str: A string
     * @return: dcodes a single string to a list of strings
     */
    public List<String> decode(String str) {
        // write your code here
        List<String> result = new ArrayList();
        char[] arr = str.toCharArray();
        for(int i=0; i<arr.length; i++){
            StringBuilder sb = new StringBuilder();

            while(arr[i]!='#'){
                sb.append(arr[i++]);
            }
            i++;
            int noOfCharacters = Integer.valueOf(sb.toString());
            sb= new StringBuilder();
            int end = i+noOfCharacters;
            while (i<end){
                sb.append(arr[i++]);
            }
            i--;
            result.add(sb.toString());
        }
        return result;
    }
}
