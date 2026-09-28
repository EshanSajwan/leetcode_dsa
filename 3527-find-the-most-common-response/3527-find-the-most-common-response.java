class Solution {
    public String findCommonResponse(List<List<String>> responses) {
        Map<String , Integer> map = new HashMap<>();
        Set<String> set;
        int f = 0;
        for(List<String> al : responses){
            set = new HashSet<>();
            for(String s : al){
                if(set.contains(s)) continue;
                set.add(s);
                map.put(s , map.getOrDefault(s , 0) + 1);
                f = Math.max( f , map.get(s) );
            }
        }
        String ans = null;
        for(Map.Entry<String , Integer> e : map.entrySet()){
            if(e.getValue() == f){
                if(ans == null) ans = e.getKey();
                else{
                    // ans = lexiBaby(ans , e.getKey());
                    int comp = ans.compareTo(e.getKey());
                    if(comp > 0) ans = e.getKey();
                }
            }
        }
        return ans;
    }
    private String lexiBaby(String a , String b){
        for(int i = 0 ; i < Math.min(a.length() , b.length()) ; i++){
            if(a.charAt(i) != b.charAt(i)){
                return a.charAt(i) < b.charAt(i) ? a : b;
            }
        }
        return a.length() < b.length() ? a : b;
    }
}