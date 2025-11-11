class Solution {
    public int pivotIndex(int[] nums) {
        int[] lSum = new int[nums.length];
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            lSum[i] = sum;
            sum += nums[i];
        }
        int[] rSum = new int[nums.length];
        sum = 0;
        for(int i = nums.length -1 ; i>-1 ;i--){
            rSum[i] = sum;
            sum += nums[i];
        }
        for(int i =0 ; i < nums.length ;i++) if(lSum[i] == rSum[i]) return i;
        return -1;
    }
}