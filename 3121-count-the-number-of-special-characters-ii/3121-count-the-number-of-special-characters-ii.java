class Solution {
    public int numberOfSpecialChars(String word) {
        Map<Character , Integer> small = new HashMap<>();
        Map<Character , Integer> big = new HashMap<>();
        for(int i = 0 ; i < word.length() ;i++){
            if(Character.isUpperCase(word.charAt(i))) {
                if(big.containsKey(word.charAt(i))) continue;
                else big.put(word.charAt(i) , i);
            }
            else small.put(word.charAt(i) , i);
        }
        int ans =0;
        for(Map.Entry<Character , Integer> entry : small.entrySet()){
            if(big.containsKey(Character.toUpperCase(entry.getKey())) && entry.getValue() < big.get(Character.toUpperCase(entry.getKey()))) ans++;
        }
        
        return ans;   
    }
}