class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int minTime = 1_000_000_00;
        for(int[] g : ghosts) minTime = Math.min(minTime , 
                        Math.max( g[0] , target[0]) - Math.min(g[0] , target[0]) 
                        +
                        Math.max( g[1] , target[1]) - Math.min(g[1] , target[1]));
        if(minTime <= Math.abs(target[0]) + Math.abs(target[1])) return false;
        
        return true;
    }
}