class Solution {
    public String modifyString(String s) {
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != '?') continue;
            char l = '0' , r = '0';
            if(i > 0) l = sb.charAt(i - 1);
            if(i < s.length() - 1) r = sb.charAt(i + 1);
            for(char ch = 'a' ; ch <= 'z' ; ch++){
                if(ch != l && ch != r){
                    sb.setCharAt(i , ch);
                    break;
                }
            }
        }
        return sb.toString();
    }
}