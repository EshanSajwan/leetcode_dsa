class Solution {
    public String majorityFrequencyGroup(String s) {
        Map<Integer , List<Character>> map =  new HashMap<>();
        // int maxF = 0 , f = 0;
        int[] arr = new int[26];
        for(char ch : s.toCharArray()) ++arr[ch - 'a'];
        for(int i = 0 ; i < 26 ; i++){
            if(arr[i] > 0){
                if(!map.containsKey(arr[i])) map.put(arr[i] , new ArrayList<>());
                map.get(arr[i]).add((char)('a' + i));
            }
        }
        int maxG = 0;
        for(int key : map.keySet()){
            maxG = Math.max( maxG , map.get(key).size());
        }
        int maxF = 0;
        for(int key : map.keySet()){
            if(map.get(key).size() == maxG){
                maxF = Math.max(maxF , key);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : map.get(maxF)) sb.append(ch);
        return sb.toString();

        // int[] freqCounter = new int[26];
        // for(int i = 0 ; i < 26 ; i++){
        //     int x = ++freqCounter[arr[i]];
        //     if(maxF < arr[i] * x){
        //         maxF = arr[i] * x;
        //         f = arr[i];
        //     }
        // }
        // StringBuilder sb =  new StringBuilder();
        // for(int i = 0 ; i < 26 ; i++) if(arr[i] == f) sb.append((char)('a' + i));
        // return sb.toString();
    }
}