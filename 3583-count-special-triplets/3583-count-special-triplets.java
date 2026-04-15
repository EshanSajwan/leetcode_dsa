class Solution {
    public int specialTriplets(int[] nums) {
        Map<Integer , Integer> left = new HashMap<>();
        Map<Integer , Integer> right = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            right.put( nums[i] , right.getOrDefault(nums[i] , 0) + 1);
        }
        long ans = 0;
        for(int i = 0 ; i < nums.length ; i++){
            right.put(nums[i] , right.get(nums[i]) - 1);
            if(right.get(nums[i]) == 0) right.remove(nums[i]);
            long l = 0 , r = 0;
            if(left.containsKey(nums[i] * 2)) l = left.get(nums[i] * 2);
            if(right.containsKey(nums[i] * 2)) r = right.get(nums[i] * 2);
            ans = (ans + (( l * r ) % 1_000_000_007))  % 1_000_000_007;
            left.put( nums[i] , left.getOrDefault(nums[i] , 0) + 1);
        }
        return (int)ans;
    }
}