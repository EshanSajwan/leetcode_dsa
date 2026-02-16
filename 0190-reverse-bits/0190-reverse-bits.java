class Solution {
    public int reverseBits(int n) {
        int num = n;
        StringBuilder binary = new StringBuilder();
        while(num != 0){
            char bit = num % 2 == 0 ? '0' : '1';
            binary.append(bit);
            num /= 2;
        }
        while(binary.length() != 32) binary.append('0');
        int pow = 0 , ans = 0;
        for(int i = 31 ; i > -1 ; i--){
            ans += Math.pow(2 , pow++) * (binary.charAt(i) - '0');
        }
        return ans;
    }
}