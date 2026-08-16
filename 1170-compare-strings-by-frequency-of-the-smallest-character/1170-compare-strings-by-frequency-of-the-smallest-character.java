class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // [3 , 2] and [1 , 2 , 3 , 4]
        // [2 , 3] and same
        int[] q = new int[queries.length] , w = new int[words.length];
        for(int i = 0 ; i < queries.length ; i++)
            q[i] = f(queries[i]);
        for(int i = 0 ; i < words.length ; i++)
            w[i] = f(words[i]);
        // Arrays.sort(w); Arrays.sort(q);
        // int i = 0 , j = 0;
        int[] ans = new int[q.length];
        // while(i < q.length){
        //     while(j < w.length && w[j] <= q[i]) j++;
        //     if(j < w.length) ans[i] = w.length - j;
        //     i++;
        // }
        for(int i = 0 ; i < q.length ; i++){
            int kitna = 0;
            for(int j = 0 ; j < w.length ; j++){
                if(w[j] > q[i]){
                    kitna++;
                }
            }
            ans[i] = kitna;
        }
        return ans;
    }
    private int f(String s){
        int[] arr = new int[26];
        for(char c : s.toCharArray()) arr[c - 'a']++;
        for(int i = 0 ; i < 26 ; i++) if(arr[i] > 0) return arr[i];
        return -1;
    }
}