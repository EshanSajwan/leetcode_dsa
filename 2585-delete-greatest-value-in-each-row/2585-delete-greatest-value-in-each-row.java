class Solution {
    public int deleteGreatestValue(int[][] grid) {
        for(int i = 0 ; i < grid.length ;i++){
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int j : grid[i]) pq.offer(j);
            for(int j = grid[0].length -1 ;j > -1 ;j--) grid[i][j] = pq.poll();
        }
        int ans = 0;
        for(int j = 0 ; j < grid[0].length ; j++){
            int max = 0;
            for(int i = 0 ; i < grid.length ; i++) max = Math.max(max , grid[i][j]);
            ans += max;
        }
        return ans;
    }
}