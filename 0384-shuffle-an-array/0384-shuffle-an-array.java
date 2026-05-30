class Solution {
    int[] nums;
    int[] original;
    Random rand;
    public Solution(int[] nums) {
        this.nums = nums;
        original = nums;
        rand = new Random();
    }
    
    public int[] reset() {
        return nums = original;
    }
    
    public int[] shuffle() {
        int n = nums.length;
        int[] used = new int[n];
        int newArr[] = new int[n];
        int na = 0;
        while(na < n){
            int randomIndex = rand.nextInt(n);
            if(used[randomIndex] == 0){
                used[randomIndex] = 1;
                newArr[na++] = nums[randomIndex];
            }
        }
        return newArr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */