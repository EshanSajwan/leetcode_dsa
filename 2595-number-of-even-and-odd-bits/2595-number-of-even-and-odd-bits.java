class Solution {
    public int[] evenOddBit(int n) {
        StringBuilder sb = new StringBuilder();
        while(n != 0){
            sb.append(n % 2);
            n /= 2;
        }
        int even = 0 , odd = 0;
        for(int i = sb.length() - 1 ; i > -1 ; i--){
            if(i % 2 == 0 && sb.charAt(i) == '1') even++;
            if(i % 2 == 1 && sb.charAt(i) == '1') odd++;
        }
        int[] ans = new int[2];
        ans[0] = even; ans[1] = odd;
        return ans;
    }
}