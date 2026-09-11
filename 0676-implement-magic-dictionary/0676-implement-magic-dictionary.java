class MagicDictionary {
    class Trie{
        Trie[] arr;
        boolean isEnd ;
        Trie(){
            arr = new Trie[26];
            isEnd = false;
        }
    }
    Trie root;

    public MagicDictionary() {
        root = new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        for(String s : dictionary){
            put(0 , s , root);
        }
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
    
    public boolean search(String searchWord) {
        return find(0 , searchWord , false , root);
        // find( index , sW , false -> unused 1 char changer)
    }

    private boolean find(int i , String s , boolean changer , Trie node){
        if(i == s.length()){
            if(!changer) return false;
            return node.isEnd;
        }
        int index = s.charAt(i) - 'a';
        if( node.arr[index] != null) 
            if( find(i + 1 , s , changer , node.arr[index]) ) 
                return true;
        //agar null hai , matlab hai hi nahi
        if(changer) return false;
        for(int j = 0 ; j < 26 ; j++){
            if(j == index || node.arr[j] == null) continue;
            if( find(i + 1 , s , true , node.arr[j]) ) return true;
        }
        return false; // case -> s me bacha hai lekin ab kuchh nahi hai dekhne kele
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */