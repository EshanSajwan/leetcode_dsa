class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0 , j = 0 , minLen = nums.length + 1 , sum = 0;
        while(j < nums.length){
            sum += nums[j];
           // if(sum >= target) minLen = Math.min(minLen , j - i + 1);
            while(sum >= target && i <= j){
                if(sum >= target) minLen = Math.min(minLen , j - i + 1);
                sum -= nums[i++];
                //if(sum >= target) minLen = Math.min(minLen , j - i + 1);
            }
            j++;
        }
        return minLen == nums.length + 1 ? 0 : minLen;
    }
}