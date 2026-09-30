class Solution {
    public int numRookCaptures(char[][] board) {
        for(int i = 0 ; i < 8 ; i++){
            for(int j = 0 ; j < 8 ; j++){
                if(board[i][j] == 'R')
                return check(i , j , board);
            }
        }
        return -1;
    }
    private int check(int i , int j , char[][] B){
        int a = i -1, b = j -1 , count = 0;
        while(a > -1){
            if(B[a][j] == 'B') break;
            else if(B[a][j] == 'p') {
                count++;
                break;
            }
            else a--;
        }
        a = i + 1;
        while(a < 8){
            if(B[a][j] == 'B') break;
            else if(B[a][j] == 'p') {
                count++;
                break;
            }
            else a++;
        }
        while(b > -1){
            if(B[i][b] == 'B') break;
            else if(B[i][b] == 'p'){
                count++;
                break;
            }
            else b--;
        }
        b = j + 1;
        while(b < 8){
            if(B[i][b] == 'B') break;
            else if(B[i][b] == 'p'){
                count++;
                break;
            }
            else b++;
        }
        return count;
    }
}