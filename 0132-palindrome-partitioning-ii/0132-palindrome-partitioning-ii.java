class Solution {
    Integer[] dp;
    public int minCut(String s) {
        dp = new Integer[s.length()];
       return PP(0 , s ) -1;
    }
     int PP(int pointer , String s ){

        if(pointer == s.length()) return 0;
        if(dp[pointer] != null) return dp[pointer];

        int minCost = Integer.MAX_VALUE;
       
        for(int i = pointer ; i < s.length() ; i++){

            if(isPal(pointer , i , s)){
               int cost = 1 + PP(i +1 , s);
               minCost = Math.min(minCost , cost);
            }
        }
        return dp[pointer] = minCost;
    }

    boolean isPal(int i , int j ,String sb){
        
        while(i < j) if(sb.charAt(i++) != sb.charAt(j--)) return false;
        return true;
    }
}