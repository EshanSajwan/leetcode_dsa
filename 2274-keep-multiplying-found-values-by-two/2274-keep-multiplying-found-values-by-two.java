class Solution {
    public int findFinalValue(int[] nums, int original) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++) al.add(nums[i]);
        while(true){
            for(int i = 0 ; i < al.size();i++){
                if(al.get(i) == original){
                    original *= 2;
                    al.remove(i);
                    if(al.size() == 0) return original;
                    break;
                }
                if(i == al.size()-1) return original;
            }
        }
    }
}