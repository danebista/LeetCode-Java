public class ArrayApp{
    public static int triples(int[] arr, int sum){
        Arrays.sort(arr);
        int tripletCount = 0;

        for (int i=0; i< arr.length-2; i++){
            int start = i+1;
            int end = arr.length-1;
            while (start < end){
                int targ = arr[i] + arr[start]+arr[end];
                if (targ<sum){
                    tripletCount += end- start;
                    start++;
                }
                else{
                    end--;
                }
            }
        }

        return tripletCount;
    }
}