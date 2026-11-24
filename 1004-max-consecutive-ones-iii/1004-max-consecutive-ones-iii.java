class Solution {
    public int longestOnes(int[] nums, int k) {
        int z = 0 , maxi = 0 , i = 0 ;
        for(int j = 0 ; j < nums.length ; j++){
            if(nums[j] == 0) z++;
            while(z > k){
                if(nums[i] == 0) z--;
                i++;
            }
            maxi = Math.max(maxi , j - i + 1);
        }
        return maxi;
    }
}