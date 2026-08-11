class Solution {
    Stack<Integer> stack ;
    public int largestRectangleArea(int[] heights) {
        int[] nse = findNextSmallerEl(heights) , pse = findPrevSmallerEl(heights);
        int ans = 0;
        for(int i = 0; i < heights.length ; i++)
            ans = Math.max(ans , heights[i] * (nse[i] - pse[i] - 1));
        return ans;
    }
    private int[] findNextSmallerEl(int arr[]){
        stack = new Stack<>();
        int nse[] = new int[arr.length];
        for(int i = arr.length - 1 ; i > -1 ; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            nse[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return nse;
    }
    private int[] findPrevSmallerEl(int[] arr){
        stack = new Stack<>();
        int[] pse = new int[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i); 
        }
        return pse;
    }
}