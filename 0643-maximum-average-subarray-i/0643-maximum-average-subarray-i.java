class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0 , avg = 0;
        for(int i = 0 ; i < k ; i++) sum += nums[i];
        avg = sum / k;
        double maxi = avg;
        for(int i = k ; i < nums.length ; i++){
            sum = sum - nums[i - k] + nums[i];
            avg = sum / k;
            maxi = Math.max(maxi , avg);
        }
        return maxi;
    }
}