class Solution {
    public int countHillValley(int[] nums) {
        int i = 0, j = 1 , k = 2 , ans = 0;
        while(k < nums.length){
            while( k < nums.length &&
                (nums[i] == nums[j] || nums[j] == nums[k] )){
                if(nums[j] == nums[k]) k++;
                else j++;
                if(i == j) j++;
                if(j == k) k++;
            }
            if(k >= nums.length) break;
            if((nums[i] < nums[j] && nums[k] < nums[j]) ||
                nums[i] > nums[j] && nums[k] > nums[j] ) ans++;
            i = j;
            j = k;
            k++;
        }
        return ans;
    }
}