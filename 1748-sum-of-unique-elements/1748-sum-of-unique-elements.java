class Solution {
    public int sumOfUnique(int[] nums) {
        int[] arr = new int[101];
        for(int i : nums) arr[i]++;
        int res = 0;
        for(int i = 0 ; i < 101 ; i++) if(arr[i] == 1) res += i;
        return res;
    }
}