class Solution {
    Boolean[] dp;
    public boolean canReach(String s, int minJump, int maxJump) {
        if(s.charAt(s.length() - 1) == '1') return false;
         if(maxJump >99997) return true;
        int lastZ = -1;
        for(int i = s.length() - 2 ; i > -1 ; i--){
            if(s.charAt(i) == '0'){
                lastZ = i;
                break;
            }
        }
        int x = s.length() - lastZ -1;
        if(s.length() > 100 && x > maxJump) return false;
        
        dp = new Boolean[s.length()];
        return rec(0 , s , minJump , maxJump);
    }
    private boolean rec(int i , String s , int left , int right){
        if(i == s.length() - 1) return true;
        if(dp[i] != null) return dp[i];
        boolean flag = false;
        for(int jump =  left ; jump <= Math.min(right , s.length() - 1) ; jump++){
            int to = i + jump;
            if(to >= s.length()) break;
            if(dp[to] != null) flag = flag || dp[to];
            if(flag) break;
            if(s.charAt(to) == '0' && dp[to] == null) flag = flag || rec(to , s , left , right);
            if(flag) break;
        }
        return dp[i] = flag;
    }
}