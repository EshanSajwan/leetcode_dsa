class Solution {
    int ans;
    public int maxProduct(String s) {
        ans = 0;
        StringBuilder sb1 = new StringBuilder() ,sb2 = new StringBuilder();
        subSeq(0 , sb1 , sb2 , s);
        return ans; 
    }
    private void subSeq(int i , StringBuilder sb1 , StringBuilder sb2 , String s){
        if(i == s.length())
        {
            if(isPal(sb1) && isPal(sb2)){
                ans = Math.max( ans , sb1.length() * sb2.length() );
            }
            return;
        }

        subSeq(i + 1 , sb1.append(s.charAt(i)) , sb2 , s);
        subSeq(i + 1 , sb1.deleteCharAt(sb1.length() - 1) , sb2.append(s.charAt(i)) , s);
        subSeq(i + 1 , sb1 , sb2.deleteCharAt(sb2.length() - 1) , s);
    }
    private boolean isPal(StringBuilder sb){
        int i = 0 , j = sb.length() - 1;
        while(i < j){
            if(sb.charAt(i++) != sb.charAt(j--)) return false;
        }
        return true;
    }
}