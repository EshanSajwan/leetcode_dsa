class Solution {
    public int generateKey(int num1, int num2, int num3) {
        int key = 0 , mul = 1;
        while(true){
            int one = 10 , two = 10 , three = 10;
            if(num1 != 0 ) {
                one = num1 % 10;
                num1 /= 10;
            }
            if(one == 10) one = 0;
            if(num2 != 0 ) {
                two = num2 % 10;
                num2 /= 10;
            }
            if(two == 10) two = 0;
            if(num3 != 0 ) {
                three = num3 % 10;
                num3 /= 10;
            }
            if(three == 10) three = 0;
            int k = Math.min(one , Math.min(two , three));
            key = k * mul + key;
            mul *= 10;
            if(num1 == 0 && num2 == 0 && num3 == 0) return key;
        }
    }
}