class Solution {
    public int maximalRectangle(char[][] matrix) {
        int[][] histo = new int[matrix.length + 1][matrix[0].length];
        for(int i = 1 ; i <= matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(matrix[i - 1][j] == 49){
                    histo[i][j] = histo[i - 1][j] + 1;
                }
            }
        }
        int ans = 0;
        for(int i = 1; i < histo.length ; i++){
            ans = Math.max( ans , maxRec(histo[i]));
        }
        return ans;
    }
    private int maxRec(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int maxR = 0;
        for(int i = 0 ; i < arr.length ; i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                int element = arr[stack.pop()];
                int pse = stack.isEmpty() ? -1 : stack.peek();
                maxR = Math.max( maxR , element * (i - pse - 1));
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int element = arr[stack.pop()];
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxR = Math.max( maxR , element * (arr.length - pse -1)); 
        }
        return maxR;
    }
}