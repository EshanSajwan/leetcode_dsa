class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return 
            subArrsLessThanEqualTo(nums , goal) - 
            subArrsLessThanEqualTo(nums , goal - 1);
    }
    private int subArrsLessThanEqualTo(int[] nums , int goal){
        int i = 0 , j = 0 , sum = 0 , count = 0;
        while(j < nums.length){
            sum += nums[j];
            if(i <= j && sum > goal){
                sum -= nums[i++];
            }
            count += j - i + 1;
            j++;
        }
        return count;
    }
}