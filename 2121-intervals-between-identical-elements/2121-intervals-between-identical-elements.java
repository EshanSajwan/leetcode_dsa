class Solution {
    public long[] getDistances(int[] nums) {
        Map<Integer , List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(!map.containsKey(nums[i])) map.put(nums[i] , new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        long[] ans = new long[nums.length];
        for(Map.Entry<Integer , List<Integer>> e : map.entrySet()){
            List<Integer> al = e.getValue();
            List<Long> preFix = new ArrayList<>();
            List<Long> postFix = new ArrayList<>();
            int n = al.size() ; long preSum = 0 , postSum = 0;
            for(int i = 0 ; i < n ; i++){
                preFix.add(preSum);
                postFix.add(0 , postSum);
                preSum += al.get(i);
                postSum += al.get(n - i - 1);
            }
            for(int i = 0 ; i < n ; i++){
                int index = al.get(i);
                ans[index] = postFix.get(i) - preFix.get(i) + (long)( 2 * i - n + 1) * index;
            }
        }
        return ans;
    }
}