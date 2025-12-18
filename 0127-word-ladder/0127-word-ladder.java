class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String str : wordList)  set.add(str);
        
        class pair{
                String s;
                int level;
                pair(String s , int lvl){
                    this.s = s;
                    this.level = lvl;
                }
        }

        Queue<pair> q = new LinkedList<>();
        q.offer(new pair(beginWord , 1));
        if(set.contains(beginWord)) set.remove(beginWord);
        while(!q.isEmpty()){
            pair curr = q.poll();
            if(curr.s.equals(endWord)) return curr.level;
            StringBuilder sb = new StringBuilder(curr.s);
            for(int i = 0 ; i < sb.length() ; i++){
                char check = sb.charAt(i);
                for(char ch = 'a' ; ch <= 'z' ; ch++){
                    if(sb.charAt(i) != ch){
                        sb.setCharAt(i , ch);
                        if(set.contains(sb.toString())){
                            q.offer(new pair(sb.toString() , curr.level +1));
                            set.remove(sb.toString());
                        }
                    }
                }
                sb.setCharAt(i , check);
            }
        }
        return 0;
    }
}