class Solution {
    public int[] productExceptSelf(int[] nums) {
        int pre = 1 , suff = 1;
        int[] preArr = new int[nums.length] ,suffArr = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            preArr[i] = pre;
            suffArr[nums.length - i - 1] = suff;
            pre *= nums[i];
            suff *= nums[nums.length - i - 1];
        }
        int[] ans = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            ans[i] = preArr[i] * suffArr[i];
        }
        return ans;
    }
}