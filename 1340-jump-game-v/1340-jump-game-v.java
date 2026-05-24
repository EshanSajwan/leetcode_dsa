class Solution {
    Integer[] jumps;
    int n;
    int d;
    public int maxJumps(int[] arr, int d) {
        n = arr.length;
        if(n == 1) return n;
        this.d = d;
        jumps = new Integer[n];
        if(arr[0] <= arr[1]) jumps[0] = 0;
        if(arr[n - 1] <= arr[n - 2]) jumps[n-1] = 0;
        for(int i = 1 ; i < n - 1 ; i++) if(arr[i] <= arr[i + 1] && arr[i] <= arr[i - 1]) jumps[i] = 0;
        for(int i = 0 ; i < n ; i++) if(jumps[i] == null) jumps[i] = findMaxJumps(i , arr );
        int max = 0;
        for(int i : jumps) if(i > max) max = i;
        return max + 1;
    }
    private int findMaxJumps(int index , int[] arr){
        int max = 0;
        for(int i = index + 1 ; i < Math.min(n , index + d + 1) ; i++){
            if(arr[i] >= arr[index]) break;
            if(jumps[i] == null) max = Math.max( max , 1 + findMaxJumps(i , arr));
            else max = Math.max( max , jumps[i] + 1);
        }
        for(int i = index - 1 ; i > Math.max(-1 , index - d - 1) ; i--){
            if(arr[i] >= arr[index]) break;
            if(jumps[i] == null) max = Math.max( max , 1 + findMaxJumps(i , arr));
            else max = Math.max( max , jumps[i] + 1);
        }
        return jumps[index] = max;
    }
}