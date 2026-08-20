class Solution {
    public int countBeautifulPairs(int[] nums) {
        int res = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int a = nums[i];
            while(a > 9) a /= 10;
            for(int j = i + 1 ; j < nums.length ; j++){
                int b = nums[j] % 10;
                if( gcd(a , b) == 1 ) res++;
            }
        }
        return res;
    }
     private int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}