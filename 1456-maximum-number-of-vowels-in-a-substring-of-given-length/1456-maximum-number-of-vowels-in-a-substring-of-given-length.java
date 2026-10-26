class Solution {
    public int maxVowels(String s, int k) {
        int res = 0 , count = 0;
        int[] isV = new int[26];
        isV['a' - 'a'] = 1;
        isV['e' - 'a'] = 1;
        isV['i' - 'a'] = 1;
        isV['o' - 'a'] = 1;
        isV['u' - 'a'] = 1;
        for(int i = 0 ; i < s.length() ; i++){
            if(isV[s.charAt(i) - 'a'] == 1) count++;
            if(i > k - 2){
                res = Math.max(res , count);
                if(isV[s.charAt(i - k + 1) - 'a'] == 1) count--;
            }
        }
        return res;
    }
}