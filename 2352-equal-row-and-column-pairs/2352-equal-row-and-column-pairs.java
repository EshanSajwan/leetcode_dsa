class Solution {
    public int equalPairs(int[][] grid) {
        Map<List<Integer> , Integer> map = new HashMap<>();
        for(int[] row : grid) 
        {
            List<Integer> r = new ArrayList<>();
            for(int i : row) r.add(i);
            map.put(r , map.getOrDefault(r , 0) + 1);
        }
        int res = 0;
        for(int i = 0 ; i < grid.length ; i++){
            List<Integer> col = new ArrayList<>();
            for(int j = 0 ; j < grid.length ; j++){
                col.add(grid[j][i]);
            }
            if(map.containsKey(col)) res += map.get(col);
        }
        return res;
    }
}