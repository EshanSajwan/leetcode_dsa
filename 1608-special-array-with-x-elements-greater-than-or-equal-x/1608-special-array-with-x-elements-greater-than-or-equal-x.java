class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1 ; i <= nums[nums.length - 1] ; i++){
            int l = 0 , h = nums.length - 1;
            while(l < h){
                int mid = l + (h - l) / 2;
                if(nums[mid] >= i) h = mid;
                else l = mid + 1;
            }
            if(i == nums.length - h) return i;
        }
        return -1;
    }
}