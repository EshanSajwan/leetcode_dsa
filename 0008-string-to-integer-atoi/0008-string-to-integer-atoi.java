class Solution {
    public int myAtoi(String s) {
       s = s.trim();
       if(s.length() == 0) return 0;
       long ans = 0;
       int i =0;
       
       boolean positive = true;
       if(s.charAt(i) =='+' || s.charAt(i) == '-'){
        positive = s.charAt(i++) =='+';
       }
        while(i < s.length() && Character.isDigit(s.charAt(i))){
            ans = (ans * 10) + (s.charAt(i) - '0');

            if(ans > Integer.MAX_VALUE){
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            i++;
        }
        if(!positive) ans = -ans;
        return (int)ans;
    }
}