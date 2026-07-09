class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int res = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');set.add('e');set.add('i');set.add('o');set.add('u');
        for(int i = left ; i < right + 1 ; i++){
            if(set.contains(words[i].charAt(0)) 
                &&
               set.contains(words[i].charAt(words[i].length() - 1)) ) res++;
        }
        return res;
    }
}