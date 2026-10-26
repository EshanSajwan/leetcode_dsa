class Solution {
    public int longestNiceSubarray(int[] nums) {
        int i = 0 , j = 0 , res = 0 , window = 0;
        while(j < nums.length){
            // window ke sath naye jth ele ka jo xor hai vo =0 hona chiye toh and kya hoga =0
            while((nums[j] & window) != 0) window ^= nums[i++];
            window |= nums[j];
            res = Math.max(res , j++ - i + 1);
        }
        return res;
    }
}