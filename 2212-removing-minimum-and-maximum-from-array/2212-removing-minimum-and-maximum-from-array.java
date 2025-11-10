class Solution {
    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minI = 0 , maxI = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= min) {
                min = nums[i];
                minI = i;
            }
            if(nums[i] >= max) {
                max = nums[i];
                maxI = i;
            }
        }
        int left = Math.max(minI , maxI)+1;// if both left
        int right = nums.length - Math.min(maxI , minI); // when both in right
        int leftRight ;
        if(minI < maxI) leftRight = minI + 1 + (nums.length - maxI);
        else leftRight = maxI + 1 + (nums.length - minI);
        return Math.min(left , Math.min(leftRight , right));
        
        // int mid = nums.length /2;
        // if(minI < mid && maxI <= mid || minI <= mid && maxI < mid) return Math.max(minI , maxI)+1;
        // if(minI > mid && maxI >= mid || minI >= mid && maxI > mid) return nums.length - Math.min(maxI , minI);
        
        // if(minI < mid && maxI >= mid || minI <= mid && maxI > mid) return minI + 1 + (nums.length - maxI);
        // if(minI > mid && maxI <= mid || minI >= mid && maxI < mid) return maxI + 1 + (nums.length - minI);
        // else return 1;
    }
}