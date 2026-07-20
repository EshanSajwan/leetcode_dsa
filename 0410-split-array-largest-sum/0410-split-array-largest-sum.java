class Solution {
    public int splitArray(int[] nums, int k) {
        // Arrays.sort(nums);
        int i = 0 , j = 0;
        for(int num : nums) {
            j += num;
            i = Math.max(i , num);
        }
        int ans= 0;
        while(i <= j){
            int mid = i + ( j - i )/ 2;
            int subArr = countSubArrays(mid , nums);
            if(subArr > k) i = mid + 1;
            else{
                ans = mid;
                j = mid - 1;
            }
        }
        return ans;
    }
    private int countSubArrays(int x , int[] arr){
        int subArr = 1;
        int size = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(size + arr[i] > x){
                subArr++;
                size = 0;
            }
            size += arr[i];
        }
        return subArr;
    }
}