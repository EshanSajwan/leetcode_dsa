class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) return true;
        if(!s.contains("abc")) return false;
        int pos = s.indexOf("abc");
        return isValid(s.substring(0 , pos) + s.substring(pos + 3));
    }
}