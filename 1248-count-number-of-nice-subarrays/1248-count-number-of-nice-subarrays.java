class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return 
            subsHasLessOrEqualThanK(nums , k) -
            subsHasLessOrEqualThanK(nums , k - 1);
    }
    private int subsHasLessOrEqualThanK(int[] nums , int k){
        int i = 0 , j = 0 , ans = 0 , oddCount = 0;
        while(j < nums.length){
            if(nums[j] % 2 == 1) oddCount++;
            while(oddCount > k){
                if(nums[i++] % 2 == 1) oddCount--;
            }
            ans += j++ - i + 1;
        }
        return ans;
    }
}