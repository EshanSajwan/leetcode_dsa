class Solution {
    public boolean judgeSquareSum(int c) {
        int a = 0 , b = (int)Math.sqrt(c);
        while(a <= b){
            long m = (long)a * (long)a , n = (long)b * (long)b;
            long x = m + n;
            if((int)x == c) return true;
            else if(x < c) a++;
            else b--;
        }
        return false;
    }
}