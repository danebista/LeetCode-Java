class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] r = new int[nums.length-k+1];
        int index=0;
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i=0; i<nums.length;i++){
            if (!deque.isEmpty() && deque.peek()==i-k){
                deque.poll();
            }
            
            while (!deque.isEmpty() && nums[deque.peekLast()]<nums[i]){
                deque.pollLast();
            }
            
            deque.offer(i);
            
            if (i>=k-1){
                r[index++] = nums[deque.peek()];
            }
        }
        return r;
    }
}
