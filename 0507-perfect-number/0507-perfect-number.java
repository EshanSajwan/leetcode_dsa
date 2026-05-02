class Solution {
    public boolean checkPerfectNumber(int num) {
        int x = 1 , sum = 0;
        while(x <= num / 2){
            if(num % x == 0){
                sum += x;
            } 
            x++;
        }
        return num == sum;
    }
}