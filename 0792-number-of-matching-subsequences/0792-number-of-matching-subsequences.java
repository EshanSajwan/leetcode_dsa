class Solution {
    Map<String , Boolean> memo;
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        memo = new HashMap<>();
        for(String w : words){
            if(isSubsequence(w, s)) count++;
        }

        return count;
    }

    private boolean isSubsequence(String word, String s){
        if(word.length() > s.length()) return false;
        if(memo.containsKey( word )) return memo.get(word);
        int i = 0, j = 0;

        while(i < word.length() && j < s.length()){
            if(word.charAt(i) == s.charAt(j)){
                i++;
            }
            j++;
        }

        boolean x = i == word.length();
        memo.put(word , x);
        return x;
    }
}