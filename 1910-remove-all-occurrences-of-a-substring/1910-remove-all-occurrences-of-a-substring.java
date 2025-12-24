class Solution {
    public String removeOccurrences(String s, String part) {
        return fxn(s , part);
    }
    String fxn(String s , String part){
        if(s.indexOf(part) == -1) return s;
        StringBuilder sb = new StringBuilder();
        int idx = s.indexOf(part);
        sb.append(s.substring(0 , idx));
        sb.append(s.substring(idx + part.length() , s.length()));
        return fxn(sb.toString()  , part);
    }
}