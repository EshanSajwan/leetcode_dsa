class Solution {
    List<String> list;
    // Map<Integer , ArrayList<Character>> numpad; 
    String[] numpad;
    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        // numpad = new HashMap<>();
        numpad = new String[10];
        numpad[0] = "";
        numpad[1] = "";
        numpad[2] = "abc";
        numpad[3] = "def";
        numpad[4] = "ghi";
        numpad[5] = "jkl";
        numpad[6] = "mno";
        numpad[7] = "pqrs";
        numpad[8] = "tuv";
        numpad[9] = "wxyz";
        // for(int i = 2; i < 10 ; i++) numpad.put(i , new ArrayList<>());
        // for(Map.Entry<Integer , ArrayList<Character>> entry : numpad.entrySet()){
        //     switch(entry.getKey()){
        //         case 2 ->{
        //             for(int i = 0 ; i < 3 ; i++) entry.getValue().add((char)('a' + i));
        //             }
        //         case 3 ->
        //             {for(int i = 0 ; i < 3 ; i++) entry.getValue().add((char)('d' + i));}
        //         case 4 ->
        //             {for(int i = 0 ; i < 3 ; i++) entry.getValue().add((char)('g' + i));  }  
        //         case 5 ->
        //             {for(int i = 0 ; i < 3 ; i++) entry.getValue().add((char)('j' + i));}
        //         case 6 ->
        //             {for(int i = 0 ; i < 3 ; i++) entry.getValue().add((char)('m' + i));}
        //         case 7 ->
        //             {for(int i = 0 ; i < 4 ; i++) entry.getValue().add((char)('p' + i));}
        //         case 8 ->
        //             {for(int i = 0 ; i < 3 ; i++) entry.getValue().add((char)('t' + i));}
        //         case 9 ->
        //             {for(int i = 0 ; i < 4 ; i++) entry.getValue().add((char)('w' + i));}
        //         default -> {continue;}
        //     }
        // }
        combinations( 0 , digits , digits.length() , new StringBuilder());
        return list;
    }
    void combinations(int i , String digit , int n , StringBuilder sb){
        int number = digit.charAt(i) - '0';
        // List<Character> li = numpad.get(number);
        String str = numpad[number];
        for(int p = 0 ; p  < str.length() ; p++){
            char ch = str.charAt(p);
            sb.append(ch);
            if(sb.length() == n) list.add(new StringBuilder(sb).toString());
            else combinations(i + 1 , digit , n , sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}