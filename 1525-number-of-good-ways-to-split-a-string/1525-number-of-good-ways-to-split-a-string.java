class Solution {
    public int numSplits(String s) {
        int count = 0;
        int seen[] = new int[26] , 
            prefix[] = new int[s.length()] , 
            suffix[] = new int[s.length()]c;
        for(int i = 0 ; i < s.length() ; i++){
            int ch = s.charAt(i) - 'a';
            if(seen[ch] == 0){
                seen[ch] = 1;
                count++;
            }
            prefix[i] = count;
        }
        count = 0;
        Arrays.fill(seen , 0);
        for(int i = s.length() - 1 ; i > -1 ; i--){
            int ch = s.charAt(i) - 'a';
            if(seen[ch] == 0){
                seen[ch] = 1;
                count++;
            }
            suffix[i] = count;
        }
        count = 0;
        for(int i = 0 ; i < s.length() - 1 ; i++){
            if(prefix[i] == suffix[i + 1]) count++;
        }
        return count;

    }
}