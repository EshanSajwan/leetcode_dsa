class Solution {
    public int alternateDigitSum(int n) {
        int x = 1;
        String s = String.valueOf(n);
        int sum = 0;
        for(char ch : s.toCharArray()){
            sum += (ch - '0') * x;
            x *= -1;
        }
        return sum;
    }
}