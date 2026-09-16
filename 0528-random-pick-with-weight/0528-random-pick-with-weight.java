class Solution {
    int prefix[] ;
    int totalsum ;
    Random r;
    public Solution(int[] w) {
        int pre = 0;
        r = new Random();
        prefix = new int[w.length];
        for( int i = 0 ; i < w.length ; i++){
            pre += w[i];
            prefix[i] = pre;
        }
        totalsum = pre;
    }
    
    public int pickIndex() {
        int i = 0 , j = prefix.length - 1;
        int target = r.nextInt(totalsum) + 1;
        while(i < j){
            int mid = i + (j - i) / 2;
            if(prefix[mid] < target) i = mid + 1;
            else j = mid;
        }
        return i;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */