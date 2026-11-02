class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int size = 0;
        for(List<Integer> al : nums){
            size += al.size();
        }
        int[] ans = new int[size];
        int index = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{nums.get(0).get(0) , 0 , 0});
        while(!q.isEmpty()){
            int[] curr = q.poll();
            ans[index++] = curr[0];
            int i = curr[1] , j = curr[2];
            if(i + 1 < nums.size() && nums.get(i + 1).size() > j
             && nums.get(i + 1).get(j) != 0)
            {
                q.offer(new int[]{nums.get(i + 1).get(j) , i + 1 , j});
                nums.get(i + 1).set(j , 0);
            }
            if(nums.get(i).size() > j + 1 && nums.get(i).get(j + 1) != 0){
                q.offer(new int[]{nums.get(i).get(j + 1) , i , j + 1});
                nums.get(i).set(j + 1, 0);
            }
        }
        return ans;
    }
}