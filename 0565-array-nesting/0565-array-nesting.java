class Solution {
    int[] nums;
    // Map<Integer , Integer> memo;
    int[] memo;
    public int arrayNesting(int[] nums) {
        int ans = 0;
        this.nums = nums;
        memo = new int[nums.length];
        Arrays.fill(memo , -1);
        // memo = new HashMap<>();
        boolean[] visit = new boolean[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            ans = Math.max ( ans , go(i , visit));
        }
        return ans;
    }
    private int go(int i , boolean visit[]){
        if(visit[i]) return 0;
        if(memo[i] != -1) return memo[i];
        // if(memo.containsKey( i )) return memo.get(i);
        visit[i] = true;
        int ans = 1 + go(nums[i] , visit);
        visit[i] = false;
        // memo.put(i , ans);
        return memo[i] = ans; 
    }
}