class Solution {
    public String decodeAtIndex(String s, int k) {
        long len = 0;
        for(char ch : s.toCharArray()){
            if(Character.isLetter(ch)) len++;
            else len *= ch - '0';
        }
        int x = s.length() -1;
        while(x > -1){
            k %= len;
            char ch = s.charAt(x--);
            if(Character.isLetter(ch) && (k == 0 || k == len)) return "" + ch;
            if(Character.isLetter(ch)) len--;
            else len /= ch - '0';
        }
        return "";
    }
}