class Solution {
    public int longestOnes(int[] nums, int k) {
        int zCount = 0 , i = 0 , j = 0 , ans = 0;
        while(j < nums.length){
            if(nums[j] == 0) zCount++;
            while(zCount > k) {
                if(nums[i++] == 0) zCount--;
            }
            ans = Math.max(ans , j++ - i + 1);
        }
        return ans;
    }
}