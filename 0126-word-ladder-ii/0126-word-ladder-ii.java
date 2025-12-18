class Solution {
    List<List<String>> ans ;
    Map<String , Integer> map;
    String B;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        ans = new ArrayList<>();
        map = new HashMap<>();
        B = beginWord;
        Set<String> set = new HashSet<>();
        for(String s : wordList) set.add(s);
        if(!set.contains(endWord)) return ans;
        Queue<String > q = new LinkedList<>();
        q.offer(beginWord);
        map.put(beginWord , 1);
        if(set.contains(beginWord)) set.remove(beginWord);
        while(!q.isEmpty()){
            StringBuilder sb = new StringBuilder(q.poll());
            String curr = sb.toString();

            if(curr.equals(endWord)) break;
            
            for(int i = 0 ; i < sb.length() ; i++){
                char original = sb.charAt(i);
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    if(ch != original){
                        sb.setCharAt(i , ch);
                        if(set.contains(sb.toString())){
                            q.offer(sb.toString());
                            map.put(sb.toString() , map.get(curr) +1);
                            set.remove(sb.toString());
                        }
                    }
                }
                sb.setCharAt(i , original);
            }
        }
        ArrayList<String> seq = new ArrayList<>();
        seq.add(endWord);
        dfs(endWord , seq);
        return ans;
    }
    void dfs(String word , ArrayList<String> seq) // BACKTRACKING KARNI HAI
    {
        if(word.equals(B)){
            ArrayList<String> list = new ArrayList<>(seq);
            Collections.reverse(list);
            ans.add(list);
            return ;
        }
        StringBuilder sb = new StringBuilder(word);            
            for(int i = 0 ; i < sb.length() ; i++){
                char original = sb.charAt(i);
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    if(ch != original){
                        sb.setCharAt(i , ch);
                        if(map.containsKey(sb.toString()) && map.get(word) == map.get(sb.toString()) + 1){
                            seq.add(sb.toString());
                            dfs(sb.toString() , seq);
                            seq.removeLast();
                        }
                    }
                }
                sb.setCharAt(i , original);
            }
    }
}