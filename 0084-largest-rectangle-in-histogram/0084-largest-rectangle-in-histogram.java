class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for(int i = 0 ; i < heights.length ; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]){
                int ns = i , element = heights[stack.pop()];
                int pse = stack.isEmpty() ? -1 : stack.peek();
                ans = Math.max( ans , element * (ns - pse -1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int element = heights[stack.pop()];
            int pse = stack.isEmpty() ? -1 : stack.peek();
            ans = Math.max( ans , element * (heights.length - pse -1));
        }
        return ans;
    }
}