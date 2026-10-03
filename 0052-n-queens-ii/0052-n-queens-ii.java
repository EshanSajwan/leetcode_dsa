class Solution {
    int n , total;
    public int totalNQueens(int n) {
        this.n = n;
        total = 0;
        List<char[]> al = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            char[] arr = new char[n];
            Arrays.fill(arr , '.');
            al.add(arr);
        }
        for(int i = 0 ; i < n ; i++){
            al.get(0)[i] = 'Q';
            rani(0 , i , al);
            al.get(0)[i] = '.';
        }
        return total;
    }
    private void rani(int row , int col , List<char[]> al){
        if(row == n - 1){
            total++;
            return;
        }
        for(int i = 0 ; i < n ; i++){
            if(i != col && i - 1 != col && i + 1 != col && possible(row + 1 , i , al)){
                al.get(row + 1)[i] = 'Q';
                rani(row + 1 , i , al);
                al.get(row + 1)[i] = '.';
            }
        }
    }
    private boolean possible(int row , int col , List<char[]> al){
        // sirf col or diagonal check karna hai or vo bhi upar ka
        for(int i = 0 ; i < row ; i++) if(al.get(i)[col] == 'Q') return false;
        int i = row -1 , j = col - 1;
        while(i > -1 && j > -1){
            if(al.get(i)[j] == 'Q') return false;
            i--;j--;
        }
        i = row -1 ; j = col + 1;
        while(i > -1 && j < n){
            if(al.get(i)[j] == 'Q') return false;
            i--;j++;
        }
        return true;
    }
}