class Solution {
    public boolean search(int[] nums, int target) {
        int i = 0 , j = nums.length -1;
        while(i <= j){
            int mid = i + (j-i)/2;
            if(nums[mid] == target) return true;
            while(nums[i] == nums[mid] && i != mid) i++;
            while(nums[j] == nums[mid] && j != mid) j--;

            if(nums[i] <= nums[mid]){
                if(target <= nums[mid] && target >= nums[i]) j = mid -1;
                else i = mid + 1;
            }
            else{
                if(target <= nums[j] && target >= nums[mid]) i = mid + 1;
                else j = mid -1;
            }
        
        }
        return false;
    }
}