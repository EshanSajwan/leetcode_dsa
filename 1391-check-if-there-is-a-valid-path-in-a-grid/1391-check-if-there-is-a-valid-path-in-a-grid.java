class Solution {
    Map<Integer , List<String>> validDir;
    Map<String , Set<Integer>> validStep;
    int[] dR = { -1 , 0 , +1 , 0};
    int[] dC = { 0 , +1 , 0 , -1};
    //          { up , right , down , left}
    Map<String , Integer> move;
    boolean[][] visit;
    public boolean hasValidPath(int[][] grid) {
        validDir = new HashMap<>();
        for(int i = 1 ; i < 7; i++) validDir.put(i , new ArrayList<>());
        validDir.get(1).add("left");validDir.get(1).add("right");
        validDir.get(2).add("up");  validDir.get(2).add("down");
        validDir.get(3).add("left");validDir.get(3).add("down");
        validDir.get(4).add("down");validDir.get(4).add("right");
        validDir.get(5).add("left");validDir.get(5).add("up");
        validDir.get(6).add("up");  validDir.get(6).add("right");
        validStep = new HashMap<>();
        validStep.put("left" , new HashSet<>());
         validStep.get("left").add(1);validStep.get("left").add(4);validStep.get("left").add(6);
        validStep.put("right" , new HashSet<>());
         validStep.get("right").add(1);validStep.get("right").add(3);validStep.get("right").add(5);
        validStep.put("up" , new HashSet<>());
         validStep.get("up").add(2);validStep.get("up").add(3);validStep.get("up").add(4);
        validStep.put("down" , new HashSet<>());
         validStep.get("down").add(2);validStep.get("down").add(5);validStep.get("down").add(6);

        move = new HashMap<>();
        move.put("left" , 3); move.put("down" , 2); move.put("right" , 1); move.put("up" , 0);

        int m = grid.length , n = grid[0].length;
        visit = new boolean[m][n];
        return dfs(0 , 0 , grid) ;
    }
    private boolean dfs(int i , int j , int[][] grid){
        int m = grid.length , n = grid[0].length;
        if(i == m - 1 && j == n - 1) return true;
        visit[i][j] = true;
        
        for(String dir : validDir.get(grid[i][j])){
            int x = move.get(dir) ;
            int newR = i + dR[x] , newC = j + dC[x];
            if(newR > -1 && newR < m && newC > -1 && newC < n && !visit[newR][newC]){
                if(validStep.get(dir).contains(grid[newR][newC]) && dfs(newR , newC , grid))
                    return true;
            }
        }
        return false;
    }
}