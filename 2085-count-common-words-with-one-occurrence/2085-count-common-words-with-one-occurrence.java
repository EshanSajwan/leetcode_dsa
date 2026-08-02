class Solution {
    public int countWords(String[] words1, String[] words2) {
        Map<String , Integer> map1 = new HashMap<>(),
        map2 = new HashMap<>();
        for(String s : words1) map1.put(s , map1.getOrDefault(s , 0) +1 );
        for(String s : words2) map2.put(s , map2.getOrDefault(s , 0) +1 );
        int ans = 0;
        for(String s : words1) 
            if(map1.get(s) == 1 )
                if(map2.containsKey(s) && map2.get(s) == 1)
                    ans++;
        return ans;
    }
}