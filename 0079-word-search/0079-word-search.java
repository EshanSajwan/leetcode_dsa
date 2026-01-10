class Solution {
    boolean visit[][];
    public boolean exist(char[][] board, String word) {
        int m = board.length , n = board[0].length;
        visit = new boolean[m][n];
        char firstLetter = word.charAt(0);
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j] == firstLetter){
                    if(dfs( 0 , word , i , j , board )) return true;
                }
            }
        }
        return false;
    }
    boolean dfs(int idx, String word , int i , int j , char[][] board){
        if(idx == word.length() - 1) return true;
        visit[i][j] = true;
        boolean left = false , right = false , up = false , down = false ;
        //up
        if(i-1 > -1 && !visit[i-1][j] && board[i-1][j] == word.charAt(idx + 1))
            up = dfs(idx + 1, word , i -1 , j  , board);
        if(up) return true;
        //right 
        if(j+1 < board[0].length && !visit[i][j + 1] && board[i][j + 1] == word.charAt(idx + 1))
            right = dfs(idx + 1, word , i , j + 1 , board);
        if(right) return true;
        //down
        if(i+1 < board.length && !visit[i+1][j] && board[i+1][j] == word.charAt(idx + 1))
            down = dfs(idx + 1, word , i+1 , j  , board);
        if(down) return true;
        //left
        if(j-1 > -1 && !visit[i][j -1] && board[i][j -1] == word.charAt(idx + 1))
            left = dfs(idx + 1, word , i , j -1  , board);
        if(left) return true;
        visit[i][j] = false;
        return false;
    }
}