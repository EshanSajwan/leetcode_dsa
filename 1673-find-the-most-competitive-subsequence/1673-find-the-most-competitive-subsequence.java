class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        List<Integer> al = new ArrayList<>();
        int n = nums.length;
        for(int i = 0 ; i < n ; i++){
            int left = n - i;
            while( al.size() > 0 && 
                left + al.size() > k &&
                al.get(al.size() - 1) > nums[i]) al.removeLast();
            if(al.size() < k) al.add(nums[i]);
        }
        int[] ans = new int[k];
        for(int i = 0 ; i < k ; i++) ans[i] = al.get(i);
        return ans;
    }
}