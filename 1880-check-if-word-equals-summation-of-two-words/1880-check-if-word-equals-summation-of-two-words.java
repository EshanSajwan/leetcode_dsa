class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        String num1 = "";
        for(char ch : firstWord.toCharArray())
            num1 += (char)('0' + ch - 'a');
        String num2 = "";
        for(char ch : secondWord.toCharArray())
            num2 += (char)('0' + ch - 'a');
        String target = "";
        for(char ch : targetWord.toCharArray())
            target += (char)('0' + ch - 'a');

        return 
        Integer.parseInt(num1) + Integer.parseInt(num2) == 
        Integer.parseInt(target);
    }

}