class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1 , -1};
        int i = 0 , j = nums.length - 1;
        while(i <= j){
            int mid = i + (j - i)/2;
            if(nums[mid] == target){
                i = j = mid;
                while(i - 1 > -1 && nums[i - 1] == nums[i]) i--;
                while( j + 1 < nums.length && nums[j + 1] == nums[j]) j++;
                ans[0] = i;
                ans[1] = j;
                break;
            }
            else if(nums[mid] < target) i = mid + 1;
            else j = mid - 1;
        }
        return ans;
    }
}