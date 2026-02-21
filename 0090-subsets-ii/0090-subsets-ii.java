class Solution {
    Set<ArrayList<Integer>> set ;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        set = new HashSet<>();
        ArrayList<Integer> l = new ArrayList<>();
        Arrays.sort(nums);
        subset(0 , l , nums);
        for(ArrayList<Integer> al : set) list.add(al);
        return list;
    }
    private void subset(int i , ArrayList<Integer> l , int[] nums){
        if(i == nums.length){
            Collections.sort(l);
            set.add(new ArrayList<>(l));
            return;
        }
        // take i
        l.add(nums[i]);
        subset(i+1 , l , nums);
        // leave i
        l.removeLast();
        subset(i + 1 , l , nums);
    }
}