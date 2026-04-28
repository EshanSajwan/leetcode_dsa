class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> al = new ArrayList<>();
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++) al.add(grid[i][j]);
        }
        Collections.sort(al);
        int median = al.get(al.size() / 2);
        int op = 0;
        for(int i : al){
            if(Math.abs(i - median) % x != 0) return -1;
            op += Math.abs( i - median) / x;
        }
        return op;
    }
}