class Solution {
    public List<Integer> intersection(int[][] nums) {
        int max = 0;
        for(int arr[] : nums) {
            for(int num : arr) max = Math.max( max , num );
        }
        int[][] mat = new int[nums.length][max + 1];
        for(int i = 0 ; i < nums.length ; i++){
            for(int j = 0 ; j < nums[i].length ; j++){
                mat[i][nums[i][j]] = 1;
            }
        }
        List<Integer> al = new ArrayList<>();
        for(int i = 1 ; i < max + 1 ; i++){
            boolean flag = true;
            for(int j = 0 ; j < nums.length ; j++){
                if(mat[j][i] == 0){
                    flag = false;
                    break;
                }
            }
            if(flag) al.add(i);
        }
        return al;
    }
}