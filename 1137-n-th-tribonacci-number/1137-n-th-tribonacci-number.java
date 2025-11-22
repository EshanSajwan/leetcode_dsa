class Solution {
    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n < 3) return 1;

        int a = 0  , b = 1 , c = 1 , val = 0;
        for(int i = 3 ; i <= n ;i++){
            val = a + b + c;
            a = b ;
            b=c;
            c = val;
        }
        return val;

        }
}