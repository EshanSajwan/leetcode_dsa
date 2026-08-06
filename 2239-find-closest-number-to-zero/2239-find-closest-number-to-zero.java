class Solution {
    public int findClosestNumber(int[] nums) {
        Arrays.sort(nums);
        int l = 0 , h = nums.length - 1;
        while(l + 1 != h){
            int mid = l + (h - l) / 2;
            if(nums[mid] == 0) return 0;
            else if(nums[mid] < 0) l = mid;
            else h = mid;
        }
        int d1 = Math.abs(nums[l]) , d2 = Math.abs(nums[h]);
        if(d1 < d2) return nums[l];
        else if(d1 > d2) return nums[h];
        else return Math.max( nums[l] , nums[h] );
    }
}