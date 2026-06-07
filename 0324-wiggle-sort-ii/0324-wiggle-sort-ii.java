class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = n / 2 ;
        if(n % 2 == 0) i--;
        int mid = i;
        int j = n - 1;
        List<Integer> al =  new ArrayList<>();
        while(i > -1 && j > mid){
            al.add(nums[i--]);
            al.add(nums[j--]);
        }
        if(i > -1) al.add(nums[i]);
        
        for(i = 0 ; i < n ; i++) nums[i] = al.get(i);
    }
}
// nums =
// [1,4,3,4,1,2,1,3,1,3,2,3,3]
// Output
// [3,2,4,2,4,1,3,1,3,1,3,1,3]
// Expected
// [3,4,2,4,2,3,1,3,1,3,1,3,1]
