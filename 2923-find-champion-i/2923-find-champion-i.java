class Solution {
    public int findChampion(int[][] grid) {
        int []teams = new int[grid.length];
        int champ = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid.length ; j++){
                if(i == j) continue;
                if(grid[i][j] == 1) teams[i]++;
                else teams[j]++;
                champ = Math.max( champ , Math.max(teams[i] , teams[j]));
            }
        }
        for(int i = 0 ; i < teams.length ; i++)
        if(teams[i] == champ) 
        return i;
        return -1;
    }
}