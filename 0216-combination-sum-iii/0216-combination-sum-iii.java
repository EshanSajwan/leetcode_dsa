class Solution {
    int sum = 0;
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int nums[] ={1 , 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> ds = new ArrayList<>();
        c3(0 , nums , ds ,  k ,n);
        return ans;
    }
    void c3(int i , int[] nums , List<Integer> ds , int k, int n){

        if(sum == n && ds.size() == k){
            ans.add(new ArrayList<>(ds));
            return;
        }

        if(i == nums.length || nums[i] > n || ds.size() > k  ) return ;

        sum += nums[i];
        ds.add(nums[i]);
        c3(i+1 , nums , ds ,k , n);
        sum -= nums[i];
        ds.removeLast();
        c3(i+1 , nums , ds , k, n);

    }
}