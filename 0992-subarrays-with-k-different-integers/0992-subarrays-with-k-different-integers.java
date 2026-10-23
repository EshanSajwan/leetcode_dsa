class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return subsHasLessThanOrEqualKDistinct(nums , k) -
                subsHasLessThanOrEqualKDistinct(nums , k - 1);
    }
    private int subsHasLessThanOrEqualKDistinct(int[] nums , int k){
        Map<Integer , Integer> map = new HashMap<>();
        int i = 0 , j = 0 , count = 0;
        while(j < nums.length){
            map.put(nums[j] , j);
            while(map.size() > k){
                if(map.get(nums[i]) == i) map.remove(nums[i]);
                i++;
            }
            count += j++ - i + 1;
        }
        return count;
    }
}