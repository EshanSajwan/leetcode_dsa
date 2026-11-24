class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(s.length() > t.length()) return false;
        return f(s, 0 , t , 0);
    }
    private boolean f(String s , int i , String t , int j){
        if(i == s.length()) return true;
        if(j == t.length()) return false;
        if(s.charAt(i) == t.charAt(j)) return f(s , i + 1 , t , j + 1);
        return f(s , i , t , j + 1);
    }
}