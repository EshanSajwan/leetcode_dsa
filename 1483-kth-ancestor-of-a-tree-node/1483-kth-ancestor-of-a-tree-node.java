class TreeAncestor {
    int[][] ancestor;
    int n,m;
    public TreeAncestor(int n, int[] parent) {
        this.n = n;
         m = 16;
        // double k = (double)n;
        // while(k > 0){
        //     m++;
        //     k /= 2;
        // }
        ancestor = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                ancestor[i][j] = -1;
            }
        }
        for(int i = 0 ; i < n ; i++) ancestor[i][0] = parent[i];
        for(int j = 1 ; j < m ; j++){
            for(int node = 0 ; node < n ; node++){
                if(ancestor[node][j - 1] != -1)
                ancestor[node][j] = ancestor[ ancestor[node][j - 1] ][j-1];
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < m; j++) {
            if (((k >> j) & 1) == 1) { // If the j-th bit of k is set
                node = ancestor[node][j];
                if (node == -1) return -1; // Reached past root
            }
        }
        return node;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */