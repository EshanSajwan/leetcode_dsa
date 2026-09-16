class Solution {
    Map<Integer , List<Integer>> map;
    Random r ;
    public Solution(int[] nums) {
        map = new HashMap<>();
        for(int i = 0 ; i < nums.length ; i++ ){
            if(!map.containsKey(nums[i]))
                map.put(nums[i] , new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        r = new Random();
    }
    
    public int pick(int target) {
        int index = r.nextInt(map.get(target).size()) ;
        return map.get(target).get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */