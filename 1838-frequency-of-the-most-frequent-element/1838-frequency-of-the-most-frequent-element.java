class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        for(int j = nums.length -1 ; j > -1; j--){
            if(ans >= j + 1) break;
            int i = j , kk = k;
            while(i - 1 > -1 && nums[j] - nums[i - 1] <= kk ){
                kk -= nums[j] - nums[i - 1];
                i--;
            }
            ans = Math.max( ans , j - i + 1);
        }
        return ans;
    }
}