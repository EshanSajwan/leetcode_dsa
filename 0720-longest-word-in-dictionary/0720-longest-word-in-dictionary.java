class Solution {
    class Trie{
        Trie[] arr;
        boolean isEnd ;
        Trie(){
            arr = new Trie[26];
            isEnd = false;
        }
    }
    Trie root;
    String ans = "";
    public String longestWord(String[] words) {
        root = new Trie();
        for(String w : words){
            put(0 , w , root);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 26 ; i++){
            if(root.arr[i] != null){
                sb.append((char)(i + 'a'));
                go(sb , root.arr[i]);
                sb.deleteCharAt(sb.length() - 1);
            } 
        }
        return ans;
    }

    private void go(StringBuilder sb , Trie node){
        if(!node.isEnd) return;
        check(sb);
        for(int i = 0 ; i < 26 ; i++){
            if(node.arr[i] != null){
                sb.append((char)(i + 'a'));
                go(sb , node.arr[i]);
                sb.deleteCharAt(sb.length() - 1);
            } 
        }
    }

    private void check(StringBuilder sb){
        if(sb.length() < ans.length()) return;
        if(sb.length() == ans.length()){
            for(int i = 0 ; i < sb.length() ; i++){
                if(sb.charAt(i) < ans.charAt(i)){
                    ans = sb.toString();
                    return;
                }
                else if(sb.charAt(i) > ans.charAt(i)){
                    return;
                }
            }
        }
        ans = sb.toString();
        return;
    }

    private void put(int i , String s , Trie node){
        if(i == s.length() ){
            node.isEnd = true;
            return;
        }
        int index = s.charAt(i) - 'a';
        if(node.arr[index] == null) node.arr[index] = new Trie();
        put(i + 1 , s , node.arr[index]);
    }
}