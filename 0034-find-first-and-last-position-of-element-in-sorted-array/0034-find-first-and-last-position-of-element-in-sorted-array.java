class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = { -1 , -1};
        for(int i = 0 ; i< nums.length ; i++){
            if(nums[i] == target){
                   ans[0] = i;
                   ans[1] = i;
                   
                   while(i+1 < nums.length && nums[i+1] == target){
                     ans[1] = i+1;
                     i++;
                   }
            }
        }
        return ans;
    }
}