class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        int p = 0 , q = 0;
        for(int i = 2 ; i < n ; i++){
            if(arr1[p] > arr2[q]) arr1[++p] = nums[i];
            else arr2[++q] = nums[i];
        }
        for(int i = 0; i <= p ; i++) nums[i] = arr1[i];
        for(int i = 0 ; i <= q ; i++) nums[i + p + 1] = arr2[i];
        return nums;
    }
}