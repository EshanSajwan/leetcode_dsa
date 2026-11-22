class Solution {
    public String gcdOfStrings(String word1, String word2) {
        int len1 = Math.min(word1.length() , word2.length()) ,
            len2 = Math.max(word1.length() , word2.length()) ;
        int i = len1 , j = len2;
        while(i > 0){
            if(len1 % i == 0 && len2 % i == 0){
                int len = i;
                String target = "";
                if(len <= word1.length()) target = word1.substring(0 , len);
                else target = word2.substring(0 , len);
                int x = 0 , y = 0;
                while(x + len <= word1.length() && word1.substring(x , x + len).equals(target)) x += len;
                while(y + len <= word2.length() && word2.substring(y , y + len).equals(target)) y += len;
                if(x == word1.length() && y == word2.length()) 
                return word1.substring(0 , len);
            }
            i--;
        }
        return "";
    }
}