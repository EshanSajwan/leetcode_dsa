class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int lesser = 0 , equal = 0;
        for(int i : nums) {
            if(i == target) equal++;
            else if(i < target) lesser++;
        }
        List<Integer> al= new ArrayList<>();
        for(int i = 0 ; i < equal ; i++)    al.add(lesser++);
        return al;
    }
}