class Solution {
    List<Integer>[] adj;
    Map<Integer , int[]> taken;
    String colors;
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        adj = new ArrayList[n];
        for(int i = 0 ; i < n ; i++) adj[i] = new ArrayList<>();
        int[] indegree = new int[n];
        for(int[] e : edges){
            adj[e[0]].add(e[1]);
            indegree[e[1]]++;
        }
        List<Integer> al = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            al.add(curr);
            for(int vx : adj[curr]){
                indegree[vx]--;
                if(indegree[vx] == 0) q.offer(vx);
            }
        }
        if(al.size() != n) return -1;
        // **************************************************
        int[] colFreq = new int[26];
        this.colors = colors;
        // taken = new int[n];
        // Arrays.fill(taken , -1);
        taken = new HashMap<>();
        int maxi = 0;
        for(int i = 0 ; i < n ; i++){
            if(!taken.containsKey(i))
            maxi = Math.max(maxi , dfs(i)[26]);
        }
        return maxi;
    }
    private int[] dfs(int i) {
        if (taken.containsKey(i)) return taken.get(i);
        
        int[] res = new int[27]; 
        
        for (int vx : adj[i]) {
            int[] child = dfs(vx);
            for (int c = 0; c < 26; c++) {
                res[c] = Math.max(res[c], child[c]);
            }
        }
        
        int myColorIndex = colors.charAt(i) - 'a';
        res[myColorIndex]++;
        
        int maxi = 0;
        for (int c = 0; c < 26; c++) {
            maxi = Math.max(maxi, res[c]);
        }
        res[26] = maxi;

        taken.put(i, res);
        return res;
    }
}