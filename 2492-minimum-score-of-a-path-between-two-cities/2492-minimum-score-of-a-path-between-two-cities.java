class Solution {
    boolean[] visit ;
    List<List<int[]>> adj;
    int dist;
    public int minScore(int n, int[][] roads) {
        dist = 10001;
        visit = new boolean[n + 1];
        adj = new ArrayList<>();
        for(int i = 0 ; i < n + 1 ; i++) adj.add( new ArrayList<>() );
        for(int[] r : roads){
            adj.get(r[0]).add(new int[]{ r[1] , r[2] });
            // adj.get(r[0])[0] = r[1];
            // adj.get(r[0])[1] = r[2];
            adj.get(r[1]).add(new int[]{ r[0] , r[2] });
            // adj.get(r[1])[0] = r[0];
            // adj.get(r[1])[1] = r[2];
        }
        visit[1] = true;
        findMinScore(1);
        return dist;
    }
    private void findMinScore(int i ){

        for(int[] arr : adj.get(i)){

            dist = Math.min( dist , arr[1]);

            if(!visit[arr[0]]){
                visit[arr[0]] = true;
                findMinScore( arr[0] );
            }
        }

    }
}