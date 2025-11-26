class Solution {
    public int numberOfSpecialChars(String word) {
        ArrayList<Character> smallAlpha = new ArrayList<>();
        Set<Character> bigAlpha = new HashSet<>();
        for(int i = 0 ; i < word.length() ;i++){
            if(Character.isUpperCase(word.charAt(i))) bigAlpha.add(word.charAt(i));
            else smallAlpha.add(word.charAt(i));
        }
        Set<Character> special = new HashSet<>();
        for(char ch : smallAlpha){
            if(bigAlpha.contains(Character.toUpperCase(ch))) special.add(ch);
        }
        return special.size();        
    }
}