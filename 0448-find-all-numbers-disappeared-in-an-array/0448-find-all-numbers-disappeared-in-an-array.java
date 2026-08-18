class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]){
                swap(nums , i , nums[i] - 1);
                i--;
            }
        }
        List<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++)
            if(nums[i] != i + 1) al.add(i + 1);
        return al;
    }
    private void swap(int[] nums , int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}