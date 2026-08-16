class Solution {
    public int longestSubsequence(int[] nums) {
        int xor = 0;
        boolean allZs = true;
        for(int num : nums) {
            xor ^= num;
            if(num != 0) allZs = false;
        }
        if(xor != 0) return nums.length;
        if(allZs) return 0;
        return nums.length - 1;        
    }
}