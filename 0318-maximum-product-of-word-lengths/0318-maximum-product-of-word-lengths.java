class Solution {
    class pari{
        String s1 , s2;
        pari(String s1 , String s2){
            this.s1 = s1;
            this.s2 = s2;
        }
    }
    public int maxProduct(String[] words) {
        Set<String> wordList = new LinkedHashSet<>();
        for(String s : words) wordList.add(s);
        List<pari> list = new ArrayList<>();
        int n = wordList.size();
        List<String> finalWList = new ArrayList<>();
        for(String s : wordList)  finalWList.add(s);
        for(int x = 0 ; x < n -1 ; x++){
            String s1 = finalWList.get(x);
            for(int y = x + 1 ; y < n; y++){
                String s2 = finalWList.get(y);
                // if(s1.equals(s2)) continue;
                // String smaller = s1.length() < s2.length() ? s1 : s2;
                // String larger = smaller.equals(s1) ? s2 : s1;
                String smaller = "" , larger = "";
                if(s1.length() <= s2.length()){
                     smaller = s1;
                     larger = s2;
                }
                else {
                     smaller = s2;
                     larger = s1;
                }
                boolean flag = false;
                for(int i = 0 ; i < smaller.length() ; i++){
                    if( larger.indexOf(smaller.charAt(i)) != -1) 
                    {
                        flag = true;
                        break;
                    }
                }
                if(!flag) list.add(new pari(smaller , larger));
            }
        }
        int ans = 0;
        for(pari p : list){
            int op1 = p.s1.length() * p.s2.length();
            ans  = Math.max( ans , op1);
        }
        return ans;
    }
}