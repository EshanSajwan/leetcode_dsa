class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int maxi = 0, sum = 0 , i = 0 , j = 0;
        while(j < nums.length){
            while(set.contains(nums[j])) {
                set.remove(nums[i]);
                sum -= nums[i++];
            }
            sum += nums[j];
            set.add(nums[j++]);
            maxi = Math.max( maxi , sum );
        }
        return maxi;
    }
}