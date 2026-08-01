class Solution {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] count = new int[11][11];
        int res = 0;
        for(int i = 0 ; i < n + 1 ; i++){
            for(int j = 0 ; j < pick.length ; j++){
                if(pick[j][0] == i){
                    count[i][pick[j][1]]++;
                    if(count[i][pick[j][1]] > i){
                        res++;
                        break;
                    } 
                }
            }
        }
        return res;
    }
}