class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double x = 0;
        double sum = 0;
        for(int i = 0 ; i < k ; i++){
            sum+= (double)nums[i];
        }
        x =(sum / k);
        for(int i = k ; i < nums.length ; i++){
            sum -= nums[i-k];
            sum += nums[i];
            x = Math.max(x , (sum / k));
        }
        return x ;
    }
}