class Solution {
    public int search(int[] nums, int target) {
        // humpe purii array hai
        // l---mid----h
        // 100% yaa toh l--mid sorted hoga yaa mid--h
        // ab jo sorted hai usme check karo ,,,, ki TARGET usme lie karta hai ki nahi

        int i = 0 , j = nums.length - 1;
        while(i <= j){
            int mid = i + (j - i)/2;
            if(nums[mid] == target) return mid;

            // left sorted ya right sorted

            if(nums[i] <= nums[mid]  ){
                if(nums[i] <= target && nums[mid] >= target) j = mid-1;
                else i = mid + 1;
            }
            else if(nums[mid] <= nums[j]  ){
                if(nums[mid] <= target && nums[j] >= target) i = mid+1;
                else j = mid-1;
            }
        }
        return -1;
    }
}