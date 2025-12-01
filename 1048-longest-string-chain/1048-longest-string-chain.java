class Solution {
    public int longestStrChain(String[] words) {

        //Arrays.sort(words);// so that len should always be inc.
        Arrays.sort(words, Comparator.comparingInt(String::length));


        int dp[]= new int[words.length];
        Arrays.fill(dp , 1);
        
        int maxi = 0;
        for(int i = 0 ; i < words.length ; i++){
            for(int prev = 0 ; prev < i ; prev++){
                if(check(words[prev] , words[i]) && dp[i] < dp[prev] +1){
                    dp[i] = dp[prev] +1;
                }
            }
            maxi = Math.max(maxi , dp[i]);
        }
        return maxi;
    }
    boolean check(String s1 , String s2){
        if(s1.length() +1 != s2.length()) return false;
        int i = 0 , j = 0;
        while(i < s1.length() && j < s2.length()){
            if(s1.charAt(i) == s2.charAt(j)){
                i++; j++;
            } else j++;
        }
        return i == s1.length() ; //&& j == s2.length();
    }
}