class Solution {
    int[] count;
    Map<String , Long> anagrams;
    Map<Integer , Long> factorial_List;
    int mod = (int)1e9 + 7;
    public int countAnagrams(String s) {
        anagrams = new HashMap<>();
        factorial_List = new HashMap<>();
        String words[] = s.split(" ");
        count = new int[words.length];
        int i = 0;
        for(String w : words){
            count[i++] = calcAnagrams(w);
        }
        long ans = 1;
        for(int x : count){
            ans = (ans * (x % mod)) % mod;
        }
        return (int)ans;
    }
    private int calcAnagrams(String s){
        if(anagrams.containsKey(s)) return (int)(anagrams.get(s) % mod);
        int[] alpha = new int[26];
        
        for(char ch : s.toCharArray()) {
            alpha[ch - 'a']++;
        }
        
        if(!factorial_List.containsKey(s.length())) {
            long fac = 1 ;
            for(int x = 1 ; x <= s.length() ; x++) {
                fac = (fac * x) % mod;
            }
            factorial_List.put(s.length() , fac);
        }
        long fac = factorial_List.get(s.length());
        for(int freq : alpha){
            int n = freq;
            if(n > 1) {
                if(!factorial_List.containsKey(n)){
                    long val = n;
                    for(int i = n - 1 ; i > 0 ; i--) val = (val * i) % mod;
                    factorial_List.put(n , val);
                }
                fac = (int)((fac * modInverse(factorial_List.get(n))) % mod);
            }
        }
        anagrams.put(s , fac);
        return (int)fac;
    }
    long power(long x, long y) {
        long res = 1;
        x %= mod;
        while (y > 0) {
            if ((y & 1) == 1) res = (res * x) % mod;
            x = (x * x) % mod;
            y >>= 1;
        }
        return res;
    }

    long modInverse(long x) {
        return power(x, mod - 2);
    }
}