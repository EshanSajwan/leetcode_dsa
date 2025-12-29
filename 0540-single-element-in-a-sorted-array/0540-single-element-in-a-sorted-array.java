class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) return nums[0];
        int n = nums.length , l = 0 ,  r = nums.length -1;
        return split(nums , n , l , r);
    }
    int split(int[] nums , int n , int l , int r){
        if( l == r)// single part
        {
            if(l != 0 && r != n-1){ // not edge element
                if(nums[l] != nums[l-1] && nums[l] != nums[l+1]) return nums[l];
                else return 0;
            } else { // edge element
                if( l == 0){
                    if(nums[l] != nums[l+1]) return nums[l];
                    else return 0 ;
                } else{
                    if(nums[l] != nums[l-1]) return nums[l];
                    else return 0 ;
                }
            }
        }
        int mid = (l + r) / 2;
        //l to mid and mid+1 to r
        return split(nums , n , l , mid) + split(nums , n , mid+1 , r);
    }
}