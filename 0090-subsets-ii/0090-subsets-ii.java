class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        SS(set , new ArrayList<Integer>() , 0 , nums);
        List<List<Integer>> ll = new ArrayList<>();
        for(List<Integer> list : set) ll.add(list);
        return ll;
    }
    void SS( Set<List<Integer>> set , ArrayList<Integer> al , int i , int[] nums){
        if(i == nums.length){
            // Collections.sort(al);
            set.add(new ArrayList<>(al));
            return;
        }
        
        al.add(nums[i]);
        SS(set , al , i+1 , nums);
        al.remove(al.size() - 1);
        SS(set , al , i+1 , nums);

    }
}