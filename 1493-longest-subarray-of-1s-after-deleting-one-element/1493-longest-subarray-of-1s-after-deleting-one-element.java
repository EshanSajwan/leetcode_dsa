class Solution {
    public int longestSubarray(int[] nums) {
        int i = 0 , maxi = 0 , zero = 0;
        for(int j = 0 ; j < nums.length ; j++){
            if(nums[j] == 0) zero++;
            while(zero > 1){
                if(nums[i] == 0) zero--;
                i++;
            }
            maxi = Math.max(j - i , maxi);
        }
        return maxi;
    }
}