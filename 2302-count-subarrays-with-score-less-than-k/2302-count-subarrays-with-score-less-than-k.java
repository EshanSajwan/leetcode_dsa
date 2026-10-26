class Solution {
    public long countSubarrays(int[] nums, long k) {
        long sum = 0 , count = 0;
        int i = 0 , j = 0;
        while(j < nums.length){
            sum += nums[j];
            while(sum * (j - i + 1) >= k) sum -= nums[i++];
            count += j++ - i + 1;
        }
        return count;
    }
}