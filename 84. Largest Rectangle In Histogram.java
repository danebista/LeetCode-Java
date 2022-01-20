class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        for (int i=0; i<n; i++){
            if(stack.isEmpty()){
                stack.push(i);
                left[i]=0;
            }
            else{
                while(!stack.isEmpty() && heights[stack.peek()]>= heights[i]) stack.pop();
                left[i] = stack.isEmpty()? 0: stack.peek()+1;
                stack.push(i);
            }
        }
        
        while (!stack.isEmpty()){
            stack.pop();
        }
        
        for (int i=n-1; i>=0; i--){
            if (stack.isEmpty()){
               stack.push(i);
                right[i] = n-1;
            }
            else {
                while(!stack.isEmpty() && heights[stack.peek()]>= heights[i]) stack.pop();
                right[i] = stack.isEmpty()? n-1: stack.peek()-1;
                stack.push(i);
            }
        }
        
        int maxArea = 0;
        for (int i=0; i< n; i++){
            maxArea = Math.max(maxArea, heights[i]* ( right[i]-left[i] + 1));
        }
        
        return maxArea;
    
    }
}
