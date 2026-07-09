class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m =  queries.length;
        boolean ans[] = new boolean[m];
        int[] arr = new int[n];
        for(int i = 1 ; i < n ; i++){
            arr[i] = arr[i - 1] + (nums[i] - nums[i - 1] > maxDiff ? 1 : 0);
        }
        for(int i = 0 ; i < m ; i++){
            ans[i] = arr[queries[i][0]] == arr[queries[i][1]];
        }
        return ans;
    }
}