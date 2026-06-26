class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        long res = 0 ; int validSS = 0 , currSum = 0;
        Map<Integer , Integer> map = new HashMap<>();
        map.put(currSum,1);
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == target){
                validSS += map.get(currSum);
                currSum++;
            } else {
                currSum--;
                if(map.containsKey(currSum)) validSS -= map.get(currSum);
            }
            res += validSS;
            map.put(currSum  , map.getOrDefault(currSum , 0) + 1);
        }
        return res;
    }
}