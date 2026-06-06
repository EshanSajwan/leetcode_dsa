class Solution {
    public int[] distinctDifferenceArray(int[] nums) {
        Map<Integer , Integer> right = new HashMap<>();
        Map<Integer , Integer> left = new HashMap<>();
        for(int i : nums) right.put(i , right.getOrDefault(i , 0) + 1);
        int[] ans = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            left.put(nums[i] , left.getOrDefault(nums[i] , 0) + 1);
            right.put(nums[i] , right.get(nums[i]) - 1);
            if(right.get(nums[i]) == 0) right.remove(nums[i]);
            ans[i] = left.size() - right.size();
        }
        return ans;
    }
}