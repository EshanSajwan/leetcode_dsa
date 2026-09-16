class Solution {
    class Trie{
        Trie[] arr;
        int count;
        Trie(){
            this.arr = new Trie[26];
            this.count = 0;
        }
    }
    Trie root;
    public int[] sumPrefixScores(String[] words) {
        // complexity ho gayi (1000 * 1000) + ( 1000 * 26 ) ~~> 10^6 worst case
        root = new Trie();
        for(String word : words){
            ghusao(0 , word , root );
        }
        int[] ans = new int[words.length];
        for( int i = 0 ; i < ans.length ; i++ ){
            ans[i] = prefixs_Lao(0 , words[i] , root);
        }
        return ans;
    } 
    private int prefixs_Lao(int i , String word , Trie root){
        if(i == word.length()) return root.count;
        return root.count + prefixs_Lao(i + 1 , word , root.arr[word.charAt(i) - 'a']);
    }
    private void ghusao(int i , String w , Trie root){
        if(i == w.length()) return;
        int index = w.charAt(i) - 'a';
        if( root.arr[index] == null)
            root.arr[index] = new Trie();
        root.arr[index].count++;
        ghusao(i + 1 , w , root.arr[index]);
    }
}