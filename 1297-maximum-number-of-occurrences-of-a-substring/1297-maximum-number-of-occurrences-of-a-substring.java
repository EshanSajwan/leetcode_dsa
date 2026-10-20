class Solution {
    Map<String , Integer> memo;
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        memo = new HashMap<>();
        int[] freq = new int[26];
        int i = 0 , j = 0 ,lc = 0 , maxi = 0;
        for( i = 0 ; i < s.length() - minSize + 1 ; i++){
            freq = new int[26];
            lc = 0;
            for(j = i ; j < Math.min(s.length() , i + maxSize) ; j++){
                int index = s.charAt(j) - 'a';
                if(freq[index] == 0){
                    lc++;
                }
                freq[index]++;
                if(lc <= maxLetters && j - i + 1 >= minSize ){
                    String tar = s.substring(i , j + 1);
                    memo.put(tar , memo.getOrDefault(tar , 0) + 1);
                    maxi = Math.max(maxi , memo.get(tar));
                }
                if(lc > maxLetters) break;
            }
        }
        // while( j < s.length()){
        //     int index = s.charAt(j) - 'a';
        //     if(freq[index] == 0){
        //         lc++;
        //     }
        //     freq[index]++;
        //     int size = j - i + 1;
        //     if(lc <= maxLetters && size >= minSize && size <= maxSize){
        //         maxi = Math.max(maxi , countOcc(s.substring(i , j + 1) , s));
        //     }
        //     if(lc > maxLetters){
        //         while(i < j && lc > maxLetters){
        //             index = s.charAt(i) - 'a';
        //             freq[index]--;
        //             if(freq[index] == 0) lc--;
        //             i++;
        //         }
        //         size = j - i + 1;
        //         if(size >= minSize && size <= maxSize)
        //         maxi = Math.max(maxi , countOcc(s.substring(i , j + 1) , s));
        //     }
        //     if(size > maxSize){
        //         index = s.charAt(i) - 'a';
        //         freq[index]--;
        //         if(freq[index] == 0) lc--;
        //         i++;
        //         maxi = Math.max(maxi , countOcc(s.substring(i , j + 1) , s));
        //     }
        //     j++;
        // }
        return maxi;
    }
    private int countOcc(String tar , String s){
        if(memo.containsKey(tar)) return memo.get(tar);
        int count = 0;
        String curr = new String(s);
        while(curr.contains(tar)){
            count++;
            int firstIndex = curr.indexOf(tar);
            curr = curr.substring(firstIndex + 1);
        }
        memo.put(tar , count);
        return count;
    }
}