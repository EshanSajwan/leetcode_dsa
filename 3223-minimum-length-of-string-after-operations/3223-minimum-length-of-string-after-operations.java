class Solution {
    public int minimumLength(String s) {
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            map.put(s.charAt(i) , map.getOrDefault(s.charAt(i) , 0) + 1);
        }
        // char str[] = s.toCharArray();
        int op = 0;
        for(Map.Entry<Character , Integer> e : map.entrySet()){
            int size = e.getValue();
            if(size > 2) {
                if(size % 2 == 0) op += size - 2;
                else op += size - 1;
            }
            // while(list.size() > 2){
            //     str[list.get(0)] = '*' ;
            //     str[list.get(2)] = '*' ;
            //     list.remove(0); list.remove(1);
            // }
        }
        // StringBuilder sb = new StringBuilder();
        // for(char ch : str) if(ch != '*') sb.append(ch);
        return s.length() - op;
    }
}