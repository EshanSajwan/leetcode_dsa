class Solution {
    public int maxRotateFunction(int[] nums) {
        int f_0 = 0 , sum = 0 , n = nums.length;
        for(int i = 0 ; i < n ; i++){
            sum += nums[i];
            f_0 += i * nums[i];
        }
        int prev = f_0 , ans = f_0;
        for(int i = 1 ; i < n ; i++){
            int f_i = prev + sum - n * nums[n - i];
            ans = Math.max(ans , f_i);
            prev = f_i;
        }
        return ans;
    }
}