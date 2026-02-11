class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int piv = -1 , i = n -1;
        while( i > 0){
            if(nums[i-1] < nums[i]){
                piv = i-1;
                break;
            }
            i--;
        }
        if(i==0){
            int l = 0 , r = n-1;
            while(l < r) swap(l++ , r-- , nums);
        } else {
            i = n -1;
            while(i >= piv){
                if(nums[i] > nums[piv]) {
                    swap(piv , i , nums);
                    break;
                }
                i--;
            }
            int l = piv + 1, r = n -1;
            while(l < r) swap(l++ , r-- , nums);
        }
    }
    private void swap(int i , int j , int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}