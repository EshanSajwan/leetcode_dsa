class Solution {
    public long[] minTimeMaxPower(int n, int[][] edges, int power, int[] cost, int source, int target) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            List<Integer> vtx = new ArrayList<>();
            vtx.add(e[1]);vtx.add(e[2]);
            adj.get(e[0]).add(vtx);
        }
        int[] maxPower = new int[n];
        Arrays.fill(maxPower , -1);
        // maxPower[source] = power;
        // node -> {time , node , power}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a,b) -> Long.compare(a[0], b[0])
        );
        long[] ans = {-1 , -1};
        pq.offer( new long[]{0 , source , power});
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            if(curr[1] == target){
                if(ans[0] == -1 || ans[0] > curr[0]){
                    ans[0] = curr[0];
                    ans[1] = curr[2];
                }
                else if(ans[0] == curr[0]){
                    ans[1] = Math.max( ans[1] , curr[2]);
                }
                continue;
            }
            if(curr[2] < cost[(int)curr[1]]) continue;

            if(curr[2] <= maxPower[(int)curr[1]]) continue;
            else maxPower[(int)curr[1]] = (int)curr[2];

            for(List<Integer> node : adj.get((int)curr[1])){
                pq.offer(new long[]{(long)curr[0] + node.get(1), 
                node.get(0) , curr[2] - cost[(int)curr[1]]});
            }
        }
        return ans;
    }
}