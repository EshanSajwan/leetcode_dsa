class Solution {
    boolean[] visit;
    int[] leftChild , rightChild;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] par = new int[n];
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        visit = new boolean[n];
        Arrays.fill(par , -1);
        for(int i = 0 ; i < n; i++){
            if(leftChild[i] != -1) {
                if(par[leftChild[i]] != -1 && par[leftChild[i]] != i ) return false;
                par[leftChild[i]] = i;
                if(par[i] == leftChild[i]) return false;
            }
            if(rightChild[i] != -1) {
                if(par[rightChild[i]] != -1 && par[rightChild[i]] != i ) return false;
                par[rightChild[i]] = i;
                if(par[i] == rightChild[i]) return false;
            }
        }
        int root = 0;
        for(int i = 0 ; i < n ; i++) if(par[i] == -1) root++;
        if (root != 1) return false;
         
        for(int i = 0 ; i < n ; i++) if(par[i] != -1) return dfs(i);
        return true; 
    }
    private boolean dfs(int x){
        visit[x] = true;
        boolean left = true , right = true;
        if(leftChild[x] !=  -1){
            if(visit[leftChild[x]]) return false;
            else left = dfs(leftChild[x]);
        }
        if(rightChild[x] != -1){
            if(visit[rightChild[x]]) return false;
            else right = dfs(rightChild[x]);
        }
        return left && right;
    }
}