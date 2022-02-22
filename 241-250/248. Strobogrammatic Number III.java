public class Solution {
    /**
     * @param low: a string
     * @param high: a string
     * @return: the total strobogrammatic numbers that exist in the range of low <= num <= high
     */
    public int strobogrammaticInRange(String low, String high) {
        // Write your code here
        List<String> result = new ArrayList();
        for (int i=low.length();i<=high.length();i++){
            result.addAll(helper(i,i));
        }
        int count =0;
        for (String res:result){
            if((res.length() == low.length() && res.compareTo(low)<0)
        || (res.length()==high.length() && res.compareTo(high)>0)) continue;
            count++;
        }

        return count;
    }

    public List<String> helper(int n, int m){
        //List<String> res = new ArrayList();
        if (n==0) return Arrays.asList("");
        if (n==1) return Arrays.asList("0","1","8");
        List<String> list = helper(n-2, m);
        List<String> res = new ArrayList();

        for (int i=0;i<list.size();i++){
            String next = list.get(i);
            if (n!=m) res.add("0"+next+"0");

            res.add("1"+next+"1");
            res.add("6"+next+"9");
            res.add("9"+next+"6");
            res.add("8"+next+"8");
        }
        return res;
    }
}
