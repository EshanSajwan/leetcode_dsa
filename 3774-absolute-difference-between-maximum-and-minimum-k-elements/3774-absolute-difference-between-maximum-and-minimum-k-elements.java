class Solution {
    public int absDifference(int[] nums, int k) {
        Arrays.sort( nums );
        int sum = 0;
        for(int i = 0 ; i < k ; i++) sum += nums[i];
        for(int i = nums.length - k ; i < nums.length ; i++) sum -= nums[i];
        return Math.abs(sum); 
    }
}