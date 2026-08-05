class Solution {
    public int minSwaps(int[] nums) {
        int oneCount = 0;
        for(int num : nums) if(num == 1) oneCount++;
        if(oneCount < 2 || oneCount == nums.length) return 0;
        int ans = nums.length , windowSize = oneCount , i = 0 , j , res = 0;
        // res - > total 1s in window
        for(j = 0 ; j < oneCount ; j++) if(nums[j] == 1) res++;
        j--;
        while(j < nums.length
        ){
            ans = Math.min( ans , windowSize - res );
            if(nums[i] == 1) res--;
            i++;
            if(j + 1 < nums.length && nums[j + 1] == 1) res++;
            j++; 
        }
        j = 0;
        if(nums[j] == 1) res++;
        while(i < nums.length){
            ans = Math.min( ans , windowSize - res);
            if(i + 1 < nums.length ){
                if(nums[i] == 1) res--;
            }
            i++;
            if(nums[j + 1] == 1) res++;
            j++;
        }
        return ans;
    }
}