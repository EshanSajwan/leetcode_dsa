class Solution {
    public boolean checkRecord(String s) {
        int absent = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char status = s.charAt(i);
            if(status == 'A') absent++;
            else if(status == 'L'){
                if((i + 1 < s.length() && s.charAt(i + 1) == 'L') && (i + 2 < s.length() && s.charAt(i + 2) == 'L')) return false;
            }
            if(absent == 2) return false;
        }
        return true;
    }
}