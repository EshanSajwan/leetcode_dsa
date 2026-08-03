class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        while(firstWord.length() > 0 && firstWord.charAt(0) == 'a')
            firstWord = firstWord.substring(1);
        while(secondWord.length() > 0 && secondWord.charAt(0) == 'a')
            secondWord = secondWord.substring(1);
        while(targetWord.length() > 0 && targetWord.charAt(0) == 'a')
            targetWord = targetWord.substring(1);
        int i = firstWord.length() - 1 ;
        int j = secondWord.length() - 1 ;
        int k = targetWord.length() - 1 ;
        int carry = 0;
        char ch = '@';
        while(i > -1 && j > -1){
            int sum = carry + firstWord.charAt(i) - 'a' + secondWord.charAt(j) - 'a';
            if(sum > 9){
                carry = 1;
                ch = (char)('a' + sum - 10);
            }
            else{
                carry = 0;
                ch = (char)('a' + sum);
            }
            if(k == -1 || targetWord.charAt(k) != ch) return false;
            k--;
            i--;
            j--;
        }
        while(i > -1){
            int sum = carry + firstWord.charAt(i) - 'a' ;
            if(sum > 9){
                carry = 1;
                 ch = (char)('a' + sum - 10);
            }
            else{
                carry = 0;
                 ch = (char)('a' + sum);
            }
            if(k == -1 || targetWord.charAt(k) != ch) return false;
            k--;
            i--;
        }
        while(j > -1){
            int sum = carry + secondWord.charAt(j) - 'a' ;
            if(sum > 9){
                carry = 1;
                 ch = (char)('a' + sum - 10);
            }
            else{
                carry = 0;
                 ch = (char)('a' + sum);
            }
            if(k == -1 || targetWord.charAt(k) != ch) return false;
            k--;
            j--;
        }
        if(carry == 1){
            if(k == 0 && targetWord.charAt(k) == 'b') k--;
            else if(k == -1) return false;
        }
        if(k > -1) return false;
        return true;
    }

}