class Solution {
    public String reformat(String s) {
        int[] alpha = new int[26] , num = new int[10];
        int numF = 0 , alphaF = 0;
        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                 num[ch - '0']++;
                 numF++;
            }
            else {
                alpha[ch - 'a']++;
                alphaF++;
            }
        }
        if(Math.abs(alphaF - numF) > 1) return "";
        int i = 0 , j = 0;
        i = findNext(num , i);
        j = findNext(alpha , j);
        StringBuilder sb = new StringBuilder();
        boolean takeNum = numF >= alphaF;
        while(i < 10 || j < 26){
            if(takeNum){
                if(i == 10) break;
                sb.append((char)(i + '0'));
                num[i]--;
                i = findNext(num , i);
                takeNum = false;
            }
            else{
                if(j == 26) break;
                sb.append((char)(j + 'a'));
                alpha[j]--;
                j = findNext(alpha , j);
                takeNum = true;
            }
        }
        if(sb.length() < s.length()) return "";
        return sb.toString();
    }
    private int findNext( int[] arr , int i){
        if(i == arr.length || arr[i] > 0) return i;
        return findNext(arr , i + 1);
    }
}