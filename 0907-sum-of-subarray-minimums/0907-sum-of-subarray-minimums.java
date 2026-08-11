class Solution {
    Stack<Integer> stack ;
    public int sumSubarrayMins(int[] arr) {
        int[] nextSmallerEl = findNextSmaller(arr) , prevSmallerEl = findPrevSmaller(arr);
        int sum = 0 , mod = (int)1e9 + 7;
        for(int i = 0 ; i < arr.length ; i++)
            sum = (sum + (int)(1L * arr[i] * (nextSmallerEl[i] - i) * (i - prevSmallerEl[i]) % mod)) % mod;
        return sum;
    }
    
    private int[] findNextSmaller(int[] arr){
        int[] nse = new int[arr.length];
        stack = new Stack<>();
        for(int i = arr.length - 1 ; i > -1 ; i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]) stack.pop();
            if(stack.isEmpty()) nse[i] = arr.length;
            else nse[i] = stack.peek();
            stack.push(i);
        }
        return nse;
    }
    
    private int[] findPrevSmaller(int[] arr){
        int[] pse = new int[arr.length];
        stack = new Stack<>();
        for(int i = 0 ; i < arr.length ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]) stack.pop();
            if(stack.isEmpty()) pse[i] = -1;
            else pse[i] = stack.peek();
            stack.push(i);
        }
        return pse;
    }
}