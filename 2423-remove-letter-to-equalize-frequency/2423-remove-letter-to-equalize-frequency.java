class Solution {
    public boolean equalFrequency(String word) {
        int f[] = new int[26];
        for(int i = 0 ; i < word.length() ; i++) f[word.charAt(i) - 'a']++;
        for(int i = 0; i < word.length() ; i++){
            f[word.charAt(i) - 'a']--;
            boolean flag = true;
            int[] curr = f.clone();
            Arrays.sort(curr);
            for(int j = 24 ; j > -1 ; j--){
                if(curr[j] == 0) break;
                if(curr[j] != curr[j + 1]){
                    flag = false;
                    break;
                }
            }
            if(flag) return true;
            f[word.charAt(i) - 'a']++;
        }
        return false;
    }
}