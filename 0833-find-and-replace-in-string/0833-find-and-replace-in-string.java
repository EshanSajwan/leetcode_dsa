class Solution {
    record pair(int ind , String ss , String t){}
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        List<pair> al = new ArrayList<>();
        boolean []visit = new boolean[s.length()];
        for(int i = 0 ; i < indices.length ; i++)
        al.add(new pair(indices[i] , sources[i] , targets[i]));
        Collections.sort(al , (a , b) -> a.ind - b.ind);
        int additional = 0;
        for(int i = 0 ; i < al.size() ; i++){
            if(visit[al.get(i).ind]) continue;
            int pos = al.get(i).ind + additional;
            int start = pos;
            if(s.contains(al.get(i).ss)){
                String ss = al.get(i).ss;
                int j = 0;
                while(pos < s.length() && j < ss.length()
                 && s.charAt(pos) == ss.charAt(j)) {
                    pos++;
                    j++;
                 }
                if(pos - start == ss.length()) {
                    s = s.substring(0 , start) + al.get(i).t + s.substring(pos);
                    additional += al.get(i).t.length() - pos + start;
                     visit[al.get(i).ind] = true;
                }
            }
        }
        return s;
    }
}