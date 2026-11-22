class Solution {
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
        int[] isVowel = new int[256];
        isVowel['a'] = 1;isVowel['A'] = 1;
        isVowel['e'] = 1;isVowel['E'] = 1;
        isVowel['i'] = 1;isVowel['I'] = 1;
        isVowel['o'] = 1;isVowel['O'] = 1;
        isVowel['u'] = 1;isVowel['U'] = 1;
        int i = 0 , j = s.length() - 1;
        while(i < j){
            if(isVowel[str[i]] == 1 && isVowel[str[j]] == 1){
                char t = str[i];
                str[i] = str[j];
                str[j] = t;
                i++;
                j--;
            }
            if(isVowel[str[i]] == 0) i++;
            if(isVowel[str[j]] == 0) j--;
        }
        return new String(str);
    }
}