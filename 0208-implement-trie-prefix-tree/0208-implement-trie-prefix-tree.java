class Trie {
    class Node {
        Node[] arr ;
        boolean flag;
        Node(){
            arr = new Node[26];
            flag = false;
        }
    }
    Node root;
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.arr[ch - 'a'] != null){
                curr = curr.arr[ch - 'a'];
            }
            else{
                curr.arr[ch - 'a'] = new Node();
                curr = curr.arr[ch - 'a'];
            }
        }
        curr.flag = true;
    }
    
    public boolean search(String word) {
        
        Node curr = root;
        for(char ch : word.toCharArray()){
            if(curr.arr[ch - 'a'] == null) return false;
            curr = curr.arr[ch - 'a'];
        }
        return curr.flag;
    }
    
    public boolean startsWith(String prefix) {
        Node curr = root;
        for(char ch : prefix.toCharArray()){
            if(curr.arr[ch - 'a'] == null) return false;
            curr = curr.arr[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */