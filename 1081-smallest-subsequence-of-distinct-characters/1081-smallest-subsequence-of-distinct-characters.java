class Solution {
    public String smallestSubsequence(String s) {
        int[] lastIndex = new int[26];
        StringBuilder sb = new StringBuilder();
        boolean[] used = new boolean[26];
        for(int i = 0 ; i < s.length() ; i++) lastIndex[s.charAt(i) - 'a'] = i;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);

            if(used[ch - 'a']) continue;

            while(sb.length() > 0 &&
                sb.charAt(sb.length() - 1) > ch &&
                lastIndex[sb.charAt(sb.length() - 1) - 'a'] > i) 
                {
                    used[sb.charAt(sb.length() - 1) - 'a'] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            
            sb.append(ch);
            used[ch - 'a'] = true;
        }
        return sb.toString();
    }
}