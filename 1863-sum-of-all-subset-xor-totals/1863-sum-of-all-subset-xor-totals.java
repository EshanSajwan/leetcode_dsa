class Solution {
    List<List<Integer>> subsets = new ArrayList<>();
    public int subsetXORSum(int[] nums) {
        createSubSets(0 , nums , new ArrayList<Integer>());
        int res = 0;
        for(List<Integer> al : subsets){
            int xor = 0;
            for(int i : al) xor ^= i;
            res += xor;
        }
        return res;
    }
    private void createSubSets(int i , int[] nums , List<Integer> al){
        if(i == nums.length) {
            subsets.add(new ArrayList<>(al));
            return;
        }
        al.add(nums[i]);
        createSubSets(i + 1 , nums , al);
        al.removeLast();
        createSubSets(i + 1 , nums , al);
    }
}