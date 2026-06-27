class Solution {
    public String arrangeWords(String text) {
        Map<Integer , List<String>> map = new TreeMap<>();
        String[] arr = text.split(" ");
        for(String s : arr){
            int len = s.length();
            map.putIfAbsent(len , new ArrayList<>());
            map.get(len).add(s);
        }
        String res = "";
        for(Map.Entry<Integer , List<String>> entry : map.entrySet()){
            for(String s : entry.getValue()) res += s + " ";
        }        
        StringBuilder sb = new StringBuilder( res );
        sb.setCharAt(0 , Character.toUpperCase(sb.charAt(0)));
        for(int i = 1 ; i < sb.length() ; i++) 
            if(Character.isUpperCase(sb.charAt(i)))
                 sb.setCharAt(i , Character.toLowerCase(sb.charAt(i)));
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}