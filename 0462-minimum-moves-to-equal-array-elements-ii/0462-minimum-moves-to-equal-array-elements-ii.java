class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = nums[nums.length / 2];
        int op = 0;
        for(int i : nums) op += Math.abs(i - median);
        return op;
    }
}