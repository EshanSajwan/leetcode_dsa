class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26] , freq2 = new int[26];
        for(char ch : word1.toCharArray()){
            freq1[ch - 'a']++;
        }
        for(char ch : word2.toCharArray()){
            freq2[ch - 'a']++;
        }
        for(int i = 0 ; i < 26 ; i++){
            if((freq1[i] > 0 && freq2[i] > 0) || (freq1[i] == 0 && freq2[i] == 0))
            continue;
            else return false;
        }
        Map<Integer , Integer> 
        map1 = new HashMap<>() ,
        map2 = new HashMap<>() ;
        for(int i : freq1) map1.put(i , map1.getOrDefault(i , 0) + 1);
        
        for(int i : freq2) map2.put(i , map2.getOrDefault(i , 0) + 1);
        if(map1.size() != map2.size()) return false;
        for(int key : map1.keySet()){
            if(map2.containsKey(key) && map2.get(key) == map1.get(key)) continue;
            else return false;
        }
        return true;
    }
}