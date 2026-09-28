class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> al = new ArrayList<>();
        for(String q : queries){
            int i = 0 , j = 0;
            while(i < q.length() && j < pattern.length() ){
                if(q.charAt(i) >= 'a' && q.charAt(i) <= 'z') {
                    if(j < pattern.length() && q.charAt(i) == pattern.charAt(j)) j++;
                    i++;
                }
                else{
                    if(q.charAt(i) != pattern.charAt(j)) break;
                    else{
                        i++; j++;
                        while(i < q.length() && j < pattern.length() && 
                            q.charAt(i) == pattern.charAt(j))
                        {
                            i++;
                            j++;
                        }
                    }
                }
            }
            if(j == pattern.length()) {
                while(i < q.length() && q.charAt(i) >= 'a' && q.charAt(i) <= 'z') i++;
            }
            al.add( i == q.length() && j == pattern.length() );
        }
        return al;
    }
}