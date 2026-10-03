class Solution {
    class Trie{
        Trie[] arr;
        String s;
        Trie(){
            this.arr = new Trie[26];
            this.s = null;
        }
    }
    Trie root;
    char[][] board;
    List<String> al;
    boolean[][] visit;
    int[][] Dir = {{-1 , 0} , {0 , 1} , {1 , 0} , {0 , -1}};
    public List<String> findWords(char[][] board, String[] words) {
        root = new Trie();
        this.board = board;
        al = new ArrayList<>();
        visit = new boolean[board.length][board[0].length];
        for(String w : words) insert(0 , w , root);
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                int pos = board[i][j] - 'a';
                if(root.arr[pos] != null){
                    boolean allDone = findAll(i , j , root.arr[pos]);
                    if(allDone) root.arr[pos] = null;
                }
            }
        }
        return al;
    }
    private boolean findAll(int i , int j , Trie node){
        visit[i][j] = true;
        if(node.s != null) {
            al.add(node.s);
            node.s = null;
        }
        for(int[] dir : Dir){
            int newR = i + dir[0] , newC = j + dir[1];
            if(newR > -1 && newR < board.length && 
               newC > -1 && newC < board[0].length &&
               !visit[newR][newC] && 
               node.arr[ board[newR][newC] - 'a' ] != null){
                boolean allDone = findAll(newR , newC , node.arr[ board[newR][newC] - 'a' ]);
                if(allDone) node.arr[board[newR][newC] - 'a' ] = null;
               }
        }
        boolean nothingLeft = true;
        for(int k = 0 ; k < 26 ; k++){
            if(node.arr[k] != null){
                nothingLeft = false;
                break;
            }
        }
        visit[i][j] = false;
        return nothingLeft;
    }
    private void insert(int i , String w , Trie node){
        if(i == w.length()){
            node.s = w;
            return;
        }
        int pos = w.charAt(i) - 'a';
        if(node.arr[pos] == null) node.arr[pos] = new Trie();
        insert(i + 1 , w , node.arr[pos]);
    }
}