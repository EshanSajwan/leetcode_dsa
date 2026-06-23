class Solution {
    public String smallestString(String s) {
        if(allA(s)) return s.substring(0 , s.length() - 1) + "z";
        if(noA(s)) return preceedString(s);
        int i = 0;
        StringBuilder sb = new StringBuilder(s);
        while(i < s.length() && s.charAt(i) == 'a') i++; 
        while(i < s.length() && s.charAt(i) != 'a'){
            sb.setCharAt(i , (char)(s.charAt(i) - 'a' - 1 + 'a'));
            i++;
        }
        return sb.toString();
    }
    private boolean allA(String s){
        for(int i = 0  ; i < s.length() ; i++) if(s.charAt(i) != 'a') return false;
        return true;
    }
    private boolean noA(String s){
        for(int i = 0 ; i < s.length() ;i++) if(s.charAt(i) == 'a') return false;
        return true;
    }
    private String preceedString(String s){
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0 ; i < s.length() ; i++){
            sb.setCharAt(i , (char)(s.charAt(i) - 'a' - 1 + 'a'));
        }
        return sb.toString();
    }
}