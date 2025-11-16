class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ll = new ArrayList<>();
        SS(ll , new ArrayList<Integer>() , 0 , nums);
        return ll;
    }
    void SS( List<List<Integer>> ll , ArrayList<Integer> al , int i , int[] nums){
        ll.add(new ArrayList<>(al));
        for(int j = i ; j < nums.length ; j++){
            if(j != i && nums[j] == nums[j-1]) continue;
            al.add(nums[j]);
            SS(ll , al , j+1 , nums);
            al.remove(al.size() - 1);
        }   
    }
}