class Solution {
    public int maximum69Number (int num) {
        int temp = 0;
        while(num > 0){
            temp = temp * 10 + num % 10;
            num /= 10;
        }
        while(temp > 0){
            if(temp % 10 == 6){
                num = num * 10 + 9;
                temp /= 10;
                break;
            }
            else {
                num = num * 10 + temp % 10;
                temp /= 10;
            }
        }
        while(temp > 0){
            num = num * 10 + temp % 10;
            temp /= 10;
        }
        return num;
    }
}