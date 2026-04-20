class Solution {
    public int minimumLength(String s) {
        Map<Character , List<Integer>> map = new HashMap<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(!map.containsKey(s.charAt(i))) map.put(s.charAt(i) , new ArrayList<>());
            map.get(s.charAt(i)).add(i);
        }
        // char str[] = s.toCharArray();
        int op = 0;
        for(Map.Entry<Character , List<Integer>> e : map.entrySet()){
            List<Integer> list = e.getValue();
            int size = list.size();
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