class Solution {
    public int mySqrt(int x) {
        if(x == 0) return 0;
        if(x < 4) return 1;
        long i = 1 , j = x / 2, ans = 0;
        while(i <= j){
            
            long mid = (i+j)/ 2;
            if((mid * mid) < x) {
                ans = mid;
                i = mid + 1;
                }
            else if(mid * mid > x)  j = mid -1;
            else return (int)mid;
        }
        return (int)ans;
    }
}