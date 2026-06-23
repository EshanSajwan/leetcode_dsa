class Solution {
    public String getSmallestString(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); i++){
            char ch = s.charAt(i);
            int distance = Math.min( ch - 'a' , 26 - ch + 'a');
            if(distance <= k){
                sb.append('a');
                k -= distance;
            }
            else if (k > 0){
                sb.append((char)(ch - 'a' - k + 'a'));
                k = 0;
            }
            else sb.append(ch);
        }
        // for(int i = sb.length() ; i < s.length() ; i++) sb.append(s.charAt(i));
        return sb.toString();
    }
}