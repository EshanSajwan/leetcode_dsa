class Solution {
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> al = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(String s : words){
            for(char c : s.toCharArray()){
                if(c == separator){
                    if(sb.length() > 0) al.add(sb.toString());
                    sb = new StringBuilder();
                }
                else sb.append(c);
            }
            if(sb.length() > 0) {
                al.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return al;
    }
}