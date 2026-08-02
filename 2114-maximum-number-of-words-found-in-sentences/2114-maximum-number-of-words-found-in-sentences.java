class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        for(String sentence : sentences){
            String[] words = sentence.split(" ");
            ans = Math.max( ans , words.length);
        }
        return ans;
    }
}