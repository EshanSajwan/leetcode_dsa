class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        // Map<Integer , Integer> map = new HashMap<>();
        int[] pos = new int[1_000_001];
        for(int i = 0 ; i < nums.length ; i++) pos[nums[i]] = i;
        // map.put(nums[i] , i);
        for(int[] op : operations){
            int index = pos[op[0]];
            pos[op[0]] = -1;
            nums[index] = op[1];
            pos[op[1]] = index;
        }
        return nums;
    }
}