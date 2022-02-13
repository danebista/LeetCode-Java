public class TwoSum {
    /**
     * @param number: An integer
     * @return: nothing
     */
    List<Integer> result = new ArrayList();

    public void add(int number) {
        // write your code here
        result.add(number);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        HashSet<Integer> hashSet = new HashSet();
        for (int num:result){
            if (hashSet.contains(value-num)) return true;
            hashSet.add(num);
        }
        return false;
    }
}
