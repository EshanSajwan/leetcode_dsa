class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {

        Arrays.sort(nums);
        
        int[] dp = new int[nums.length];
        Arrays.fill(dp , 1);
        int[] hash = new int[nums.length];

        for(int i = 0 ; i < hash.length ; i++) hash[i] = i;

        int maxi = 0 , l_index = 0;
        for(int i = 0 ; i < nums.length ; i++){
            for(int prev = 0 ; prev < i ; prev++){
                if(nums[i] % nums[prev] == 0 && dp[prev] + 1 > dp[i]){
                    dp[i] = dp[prev] +1;
                    hash[i] = prev;
                }
            }
            if(maxi < dp[i]){
                maxi = dp[i];
                l_index = i;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(0 , nums[l_index]);
        while(hash[l_index] != l_index){
            l_index = hash[l_index];
            list.add(0 , nums[l_index]);
        }
        return list;
    }
}