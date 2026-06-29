class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        int x = 0;
        for(int i = 0 ; i < n ; i++){
            ans[x++] = nums[i];
            ans[x++] = nums[i + n];
        }
        return ans;
    }
}