class Solution {
    public int lastRemaining(int n) {
        return elimination_Chamber(n , 'L');
    }
    private int elimination_Chamber(int n , char from){
        if(n == 1) return n;
        if(from == 'L' || n % 2 == 1) 
            return 2 * elimination_Chamber(n / 2 , from == 'L' ? 'R' : 'L');
        else return 2 * elimination_Chamber( n / 2 , from == 'L' ? 'R' : 'L') - 1;
    }
}